/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3.serversocketframe;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author asus
 */
public class NewClass extends JFrame implements ActionListener{
    JButton startButton;
    public NewClass(String s){
        super(s);
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        this.setLayout(new FlowLayout());
        this.add(startButton);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            System.out.println("Server is waiting to accept user...");
            //create a server socket
            ServerSocket serverSocket = new ServerSocket(5252);
            int clientNumber = 0;
            //client socket
            Socket clientSocket = serverSocket.accept();
            serverThread svthread = new serverThread(clientSocket,clientNumber++);
            svthread.start();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
