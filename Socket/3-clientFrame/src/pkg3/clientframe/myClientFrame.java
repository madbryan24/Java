/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3.clientframe;

import java.awt.GridLayout;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author asus
 */
public class myClientFrame extends JFrame implements ActionListener{
    JPanel mainPanel,filterPanel,buttonPanel;
    JLabel firstNumber,secondNumber,resultJLabel;
    JTextField firstField,secondField,resultField;
    JButton connectButton,sendButton,exitButton;
    
    Socket clientSocket=null;
    InputStream inputStream = null;
    OutputStream outputStream =null;
    PrintWriter printWriter =null;
    Scanner sc=null;
    public myClientFrame(String s){
        super(s);
    //create vari
        mainPanel = new JPanel();
        filterPanel = new JPanel();
        buttonPanel = new JPanel();
        firstNumber = new JLabel("First Number");
        secondNumber  = new JLabel("Second Number");
        resultJLabel = new JLabel("Result");
        firstField = new JTextField();
        secondField = new JTextField();
        resultField  = new JTextField();
        connectButton = new JButton("Connect");
        sendButton = new JButton("Send");
        exitButton = new JButton("Exit");
    //filter
        TitledBorder title = new TitledBorder("Filter");
        filterPanel.setBorder(title);
        filterPanel.setLayout(new GridLayout(3,2));
        filterPanel.add(firstNumber);
        filterPanel.add(firstField);
        filterPanel.add(secondNumber);
        filterPanel.add(secondField);
        filterPanel.add(resultJLabel);
        filterPanel.add(resultField);
    //Button
        connectButton.addActionListener(this);
        sendButton.addActionListener(this);
        exitButton.addActionListener(this);
        TitledBorder title1 = new TitledBorder("Button");
        buttonPanel.setBorder(title1);
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
        buttonPanel.add(connectButton);
        buttonPanel.add(sendButton);
        buttonPanel.add(exitButton);
    //main
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.X_AXIS));
        mainPanel.add(filterPanel);
        mainPanel.add(buttonPanel);
        this.add(mainPanel);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == connectButton){
            try {
                clientSocket = new Socket("localhost", 5252);
                
                JOptionPane.showMessageDialog(this,"Connecting Successfully","Info",JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(myClientFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(ae.getSource() == sendButton){
            
            try {
                 //Tạo đối tượng dùng để nhận dữ liệu từ server
                inputStream = clientSocket.getInputStream();
                sc = new Scanner(inputStream);
                //Tạo đối tượng dùng để gửi dữ liệu đến server
                outputStream = clientSocket.getOutputStream();
                printWriter = new PrintWriter(outputStream, true);
                //send msg
                String s1 = firstField.getText();
                String s2 = secondField.getText();
                System.out.println("s1 is: "+s1);
                System.out.println("s2 is: "+s2);               
                printWriter.println(s1);
                printWriter.println(s2);
                
                while(sc.hasNextLine()){
                    //receive msg
                    String receiveString = sc.nextLine();
                    System.out.println("recei is: " + receiveString);
                    resultField.setText(receiveString); 
                }
                
            }catch (NullPointerException e){
               e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(myClientFrame.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } 
        else if(ae.getSource() == exitButton){
            try {
                inputStream.close();
                outputStream.close();
                clientSocket.close();
                System.exit(0);
            } catch (IOException ex) {
                Logger.getLogger(myClientFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }   
    
}
