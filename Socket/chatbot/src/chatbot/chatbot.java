/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class chatbot extends JFrame implements ActionListener{
    static JPanel mainPanel,buttonPanel;
    static JTextArea txTextArea;
    static JTextField txTextField;
    static JButton sendButton;
    
    static ServerSocket serverSocket;
    static Socket clientSocket;
            
    static InputStream inputStream;
    static Scanner sc ;
    static Scanner sc1;
    static OutputStream outputStream ;
    static PrintWriter printWriter ;
    
    public chatbot(String s){
        super(s);
        
    //create vari
        mainPanel = new JPanel();
        buttonPanel = new JPanel();
        txTextArea = new JTextArea();
        txTextField = new JTextField(30);
        sendButton = new JButton("Send");
    
    //button
        sendButton.addActionListener(this);
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
        buttonPanel.add(txTextField);
        buttonPanel.add(sendButton);
    //main
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.add(txTextArea);
        mainPanel.add(buttonPanel);
        this.add(mainPanel);
    }
  
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == sendButton){
                String msgout="";
            try {
                msgout=txTextField.getText().trim();
                printWriter.println("Server: "+msgout);
            } catch (Exception e) {
            }
        }
    }
    
    public static void main(String[] args) {
            
            EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        chatbot jrsce = new chatbot("Server");
                        jrsce.setSize(350, 350);
                        jrsce.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        jrsce.setVisible(true);
                    }
            });
        
        try {
            serverSocket = new ServerSocket(5252);
            clientSocket = serverSocket.accept();
            System.out.println("Server start");
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();
            printWriter = new PrintWriter(outputStream, true);
            sc = new Scanner(inputStream);
            //receive msg
            while(sc.hasNextLine()){
                //receive msg
                String receiveString = sc.nextLine();
                System.out.println("from Client: "+receiveString);
                txTextArea.setText(txTextArea.getText().trim() + "\n" + receiveString);
            }
        } catch (IOException ex) {
            Logger.getLogger(chatbot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

