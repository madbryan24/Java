/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.socketthreadserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author asus
 */
public class SocketThreadServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            System.out.println("Server is waiting to accept user...");
            //create a server socket
            ServerSocket serverSocket = new ServerSocket(5252);
            int clientNumber = 0;
            //client socket
            Socket clientSocket = serverSocket.accept();
            ServerThread svthread = new ServerThread(clientSocket,clientNumber++);
            svthread.start();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
