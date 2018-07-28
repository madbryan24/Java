/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5.rmitest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author asus
 */
public class myClientFrame extends JFrame implements ActionListener{
    JPanel mainPanel,filterPanel,buttonPanel;
    JLabel firstNumber,resultJLabel;
    JTextField firstField,secondField,resultField;
    JButton sendButton,exitButton;
    

    public myClientFrame(String s){
        super(s);
    //create vari
        mainPanel = new JPanel();
        filterPanel = new JPanel();
        buttonPanel = new JPanel();
        firstNumber = new JLabel("First Number");
        resultJLabel = new JLabel("Result");
        firstField = new JTextField();
        resultField  = new JTextField();
        sendButton = new JButton("Send");
        exitButton = new JButton("Exit");
    //filter
        TitledBorder title = new TitledBorder("Filter");
        filterPanel.setBorder(title);
        filterPanel.setLayout(new GridLayout(3,2));
        filterPanel.add(firstNumber);
        filterPanel.add(firstField);
        filterPanel.add(resultJLabel);
        filterPanel.add(resultField);
    //Button
        sendButton.addActionListener(this);
        exitButton.addActionListener(this);
        TitledBorder title1 = new TitledBorder("Button");
        buttonPanel.setBorder(title1);
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
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
        if(ae.getSource() == sendButton){
            try {
            // Gọi server đang lắng nghe tại cổng 7777
            Registry reg = LocateRegistry.getRegistry("localhost", 7777);

            // Lấy đối tượng từ xa
            ICalculator cal = (ICalculator) reg.lookup("RMICalSer");

            // Gọi phương thức từ xa
            double result = cal.square(Double.parseDouble(firstField.getText()));

            // Hiển thị kết quả
            resultField.setText(String.valueOf(result));
          } catch (Exception e) {
             e.printStackTrace();
          }
        }

        else if(ae.getSource() == exitButton){
                System.exit(0);
        }
        
    }   
}
