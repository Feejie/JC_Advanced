package Lesson_6.Homework;

import java.io.IOException;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleClient{

    public static void main(String[] args) {

        try {
            final String IP_ADRESS = "localhost";
            final int PORT = 7000;
            Socket socket = new Socket(IP_ADRESS, PORT);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Scanner sc = new Scanner(System.in);

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String str = null;
                            str = in.readUTF();
                            if(str.equals("/end")) {
                                out.writeUTF("/end");
                                break;
                            }
                            System.out.println("Server " + str);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            t1.start();

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            System.out.println("Введите сообщение");
                            String str = sc.nextLine();
                            System.out.println("Сообщение отправлено!");
                            out.writeUTF(str);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            t2.setDaemon(true);
            t2.start();

            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
//    public static void main(String[] args) {
//        new ConsoleClient();
//    }
}
