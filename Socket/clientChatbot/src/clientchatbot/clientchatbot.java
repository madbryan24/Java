/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientchatbot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
public class clientchatbot extends JFrame implements ActionListener{
    JPanel mainPanel,buttonPanel;
    static JTextArea txTextArea;
    JTextField txTextField;
    JButton sendButton;
    
    static Socket clientSocket;
    static InputStream inputStream;
    static Scanner sc ;
    static Scanner sc1;
    static OutputStream outputStream ;
    static PrintWriter printWriter ;
    public clientchatbot(String s){
        super(s);
        
    //create vari
        mainPanel = new JPanel();
        buttonPanel = new JPanel();
        txTextArea = new JTextArea();
        txTextField = new JTextField(30);
        sendButton = new JButton("Send");
    //txtArea
        
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
    /**
     * @param args the command line arguments
     */
        // TODO code application logic here
        

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == sendButton){
                String msgout="";
            try {
                msgout=txTextField.getText().trim();
                printWriter.println("Client: "+msgout);
            } catch (Exception e) {
            }
        }

    }
    
    public static void main(String[] args) {
        // TODO code application logic here
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                clientchatbot jrsce = new clientchatbot("Client");
                jrsce.setSize(350, 350);
                jrsce.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jrsce.setVisible(true);
            }
        });     
            
        try {
            //Tạo đối tượng Socket đại diện cho cs
            clientSocket = new Socket("localhost", 5252);
            //Tạo đối tượng dùng để nhận dữ liệu từ server
            inputStream = clientSocket.getInputStream();
            Scanner sc = new Scanner(inputStream);
             //Tạo đối tượng dùng để gửi dữ liệu đến server
            outputStream = clientSocket.getOutputStream();
            printWriter = new PrintWriter(outputStream, true);
            //send msg
            printWriter.println("Client's connected:");
            //receive msg
            while(sc.hasNextLine()){
                //receive msg
                String receiveString = sc.nextLine();
                System.out.println("from Server: "+receiveString);
                txTextArea.setText(txTextArea.getText().trim() + "\n" + receiveString);
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            System.out.println("Client Work has Stopped");
        }    
    }
    
}
