/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5.pkg1.servertest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author asus
 */
public class CalculatorImpl extends UnicastRemoteObject implements ICalculator{
    public CalculatorImpl() throws RemoteException{
        System.out.println("square function has been created");
    }
    @Override
    public double square(double a) throws RemoteException {
         return a*a;
    }
    
}
