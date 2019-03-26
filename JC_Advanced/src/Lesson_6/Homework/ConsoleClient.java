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
            System.out.println("Say something...");

            try {
                while (true) {
                    String s = sc.nextLine();
                    String str = in.readUTF();

                    System.out.println(s);

                    System.out.println(str);

                    out.writeUTF(s);
                }
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        new ConsoleClient();
//    }
}
