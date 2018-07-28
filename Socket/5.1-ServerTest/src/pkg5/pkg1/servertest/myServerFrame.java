/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5.pkg1.servertest;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author asus
 */
public class myServerFrame extends JFrame implements ActionListener{
    JButton startButton;
    public myServerFrame(String s){
        super(s);
        startButton = new JButton("Start");
        startButton.addActionListener(this);
        this.setLayout(new FlowLayout());
        this.add(startButton);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            //Tạo đối tượng Registry
            Registry reg = LocateRegistry.createRegistry(7777);

            //Đăng ký Remote Object
            CalculatorImpl ci = new CalculatorImpl();
            reg.bind("RMICalSer", ci);
       } catch (Exception e) {
          e.printStackTrace();
       }
    }
}
