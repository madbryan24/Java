/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5.rmitest;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author asus
 */
public interface ICalculator extends Remote{
    public double square(double a) throws RemoteException;
}
