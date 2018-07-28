/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.socketserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class SocketServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        try{
            System.out.println("Server is waiting to accept user...");
            //create a server socket
            ServerSocket serverSocket = new ServerSocket(5252);
            //client socket
            Socket clientSocket = serverSocket.accept();
            //receive
            InputStream inputStream = clientSocket.getInputStream();
            Scanner sc = new Scanner(inputStream);
            //send
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);

            while(sc.hasNextLine()){
                //receive msg
                String receiveString = sc.nextLine();
                System.out.println("Receive from client: "+receiveString);    
                
                //send msg
                printWriter.println("Server's data is transmitted");
            }
            
            
            
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            System.out.println("Server Work has Stopped");
        }
    }
}
