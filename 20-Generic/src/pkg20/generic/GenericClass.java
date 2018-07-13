/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20.generic;

/**
 *
 * @author asus
 */
public class GenericClass {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.setT(new Integer(10));
        stringBox.setT(new String("Hello World"));

        System.out.printf("Gia tri integer la :%d\n\n", integerBox.getT());
        System.out.printf("Gia tri string la :%s\n", stringBox.getT());
    }
}

class Box<T>{
    private T t;
    public void setT(T t){
        this.t = t;
    }
    public T getT(){
        return t;
    }
}
