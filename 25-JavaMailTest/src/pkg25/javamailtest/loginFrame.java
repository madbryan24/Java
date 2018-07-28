/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg25.javamailtest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author asus
 */
public class loginFrame extends JFrame implements ActionListener{
    JPanel mainPanel,accountPanel,messPanel,buttonPanel;
    JLabel accountLabel,passLabel,toLabel,subjectLabel,messLabel;
    JTextField accountField,toField,subjectField,messField;
    JPasswordField passField;
    JButton sendButton,exitButton;
    public loginFrame(String s){
        super(s);
        mainPanel = new JPanel();
        accountPanel = new JPanel();
        messPanel = new JPanel();
        buttonPanel = new JPanel();
        accountLabel = new JLabel("Account");
        passLabel = new JLabel("Password");
        toLabel = new JLabel("To");
        subjectLabel = new JLabel("Subject");
        messLabel = new JLabel("Message");
        accountField = new JTextField();
        passField = new JPasswordField();
        toField = new JTextField();
        subjectField = new JTextField();
        messField = new JTextField();
        sendButton = new JButton("Send");
        exitButton = new JButton("Exit");
    //account
        TitledBorder title = new TitledBorder("Account");
        accountPanel.setBorder(title);
        accountPanel.setLayout(new GridLayout(2,2));
        accountPanel.add(accountLabel);
        accountPanel.add(accountField);
        accountPanel.add(passLabel);
        accountPanel.add(passField);
    //mess   
        TitledBorder title1 = new TitledBorder("Message");
        messPanel.setBorder(title1);
        messPanel.setLayout(new GridLayout(3,2));
        messPanel.add(toLabel);
        messPanel.add(toField);
        messPanel.add(subjectLabel);
        messPanel.add(subjectField);
        messPanel.add(messLabel);
        messPanel.add(messField);
    //button
        sendButton.addActionListener(this);
        exitButton.addActionListener(this);
        TitledBorder title2 = new TitledBorder("Button");
        buttonPanel.setBorder(title2);
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
        buttonPanel.add(sendButton);
        buttonPanel.add(exitButton);
    //main
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.add(accountPanel);
        mainPanel.add(messPanel);
        mainPanel.add(buttonPanel);
        this.add(mainPanel);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == sendButton){
            try {
                Properties p = new Properties();
                p.put("mail.smtp.auth", "true");
                p.put("mail.smtp.starttls.enable", "true");
                p.put("mail.smtp.host", "smtp.gmail.com");
                p.put("mail.smtp.port", 587);
                
                String accountName = accountField.getText().toString();
                char[] accountPassword = passField.getPassword();
                String Password = new String(accountPassword);
                System.out.println(accountPassword);
                System.out.println(Password);
                Session s = Session.getInstance(p, new javax.mail.Authenticator() {
                    @Override
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(accountName,Password);
                    }
                });
                
                Message msg = new MimeMessage(s);
                msg.setFrom(new InternetAddress(accountName));
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toField.getText()));
                msg.setSubject(subjectField.getText());
                msg.setText(messField.getText());
                
                Transport.send(msg);
                
                System.out.println("Sending Email Successfully");
            } catch (MessagingException ex) {
                Logger.getLogger(loginFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(ae.getSource() == exitButton){
                System.exit(0);
        }
    }
    
}
