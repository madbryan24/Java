/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg12.pkg3.createexception;

/**
 *
 * @author asus
 */
public class CreateException {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s1 = "linh";
        String s2 = "linh";
        String s3 = "thinh";
        try{
            copy(s1, s2);
            copy(s1, s3);
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            copy(s1, s3);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void copy(String s1,String s2) throws Exception{
        if(s1.equals(s2)) 
            throw new myException("Duplicated Files");
        else
            System.out.println("Copy Files Successfully");
    }
    
}

class myException extends Exception{
    public myException(String msg){
        super(msg);
    }
    public myException(String msg, Throwable cause){
        super(msg, cause);
    }
}
