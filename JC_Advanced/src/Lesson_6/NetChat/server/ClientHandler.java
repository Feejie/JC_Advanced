package Lesson_6.NetChat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler {

    private MainServer server;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private List<String> blacklist;
    private String nick;

    private boolean myMsg;

    public ClientHandler(MainServer server, Socket socket) {
        try {
            this.blacklist = new ArrayList<>();
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        myMsg = false;
                        while (true) {
                            String str = in.readUTF();
                            if(str.startsWith("/auth")) {
                                String[] tokens = str.split(" ");
                                String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);
                                if(newNick != null) {
                                    if (!server.checkNick(newNick)){
                                        sendMsg("/authok");
                                        nick = newNick;
                                        server.subscribe(ClientHandler.this);
                                        break;
                                    } else {
                                        sendMsg("Учетная запись занята");
                                    }

                                } else {
                                    sendMsg("Неверный логин/пароль");
                                }
                            }
                        }

                        while (true) {
                            String str = in.readUTF();
                            if (str.startsWith("/")) {
                                if (str.equals("/end")) {
                                    out.writeUTF("/serverclosed");
                                    break;
                                }
                                if (str.startsWith("/w ")) {
                                    String[] tokens = str.split(" ", 3);
                                    server.privateMsg(ClientHandler.this, tokens[1], tokens[2]);
                                }
                                if (str.startsWith("/blacklist ")) {
                                    String[] tokens = str.split(" ");
                                    blacklist.add(tokens[1]);
                                    sendMsg("Пользователь " + tokens[1] + " добавлен в черный список");
                                }

                                // Исключение из blacklist

                                if (str.startsWith("/reblacklist ")) {
                                    String[] tokens = str.split(" ");
                                    blacklist.remove(tokens[1]);
                                    sendMsg("Пользователь " + tokens[1] + " удален из черного списка");
                                }
                            } else {
                                server.broadcastMsg(ClientHandler.this, str);

                                /**
                                 * Реализация ориентации собщений
                                 */

                                out.writeUTF("/mymsg");
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        server.unsubscribe(ClientHandler.this);
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkBlackList(String nick) {
        return blacklist.contains(nick);
    }

    public String getNick(){
        return this.nick;
    }

    public void sendMsg(String msg) {
        try {
            myMsg = true;
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isMyMsg() {
        return myMsg;
    }

}
