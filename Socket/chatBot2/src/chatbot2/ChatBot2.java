/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class ChatBot2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            //Tạo đối tượng Socket đại diện cho cs
            Socket clientSocket = new Socket("localhost", 5252);
            //Tạo đối tượng dùng để nhận dữ liệu từ server
            InputStream inputStream = clientSocket.getInputStream();
            Scanner sc = new Scanner(inputStream);
            Scanner sc1 = new Scanner(System.in);
            //Tạo đối tượng dùng để gửi dữ liệu đến server
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);

            //send msg
            printWriter.println("Client's connected:");
            //receive msg
            while(sc.hasNextLine()){
                //receive msg
                String receiveString = sc.nextLine();
                System.out.println("from Server: "+receiveString);
                //send msg
                String s = sc1.nextLine();
                System.out.println("Client 2: "+s);
                printWriter.println(s);
            }
            
            inputStream.close();
            outputStream.close();
            clientSocket.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            System.out.println("Client Work has Stopped");
        }
    }
    
}
