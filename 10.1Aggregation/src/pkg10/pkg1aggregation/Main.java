/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg10.pkg1aggregation;

/**
 *
 * @author asus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        triangular T1,T2;
        point A = new point(11,13);
        point B = new point(6,5);
        point C = new point(10,7);
        point D = new point(28,10);
        T1 = new triangular(A, B, C, D);
        T2 = new triangular();
        T1.triangularPrint();
        T2.triangularPrint();      
    }
    
}

class point{
    private int x;
    private int y;
    
    public point(){}
    
    public point(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return y;
    }
    
    public void pointPrint(){
        System.out.println("(" + x + ", " + y + ")");
    }
}

class triangular{
    private point d1,d2,d3,d4;
    
    public triangular(){
        this.d1 = new point(0,0);
        this.d2 = new point(0,1);
        this.d3 = new point(1,1);
        this.d4 = new point(1,0);
    }
    
    public triangular(point p1,point p2,point p3,point p4){
        this.d1 = p1;
        this.d2 = p2;
        this.d3 = p3;
        this.d4 = p4;
    }
    
    public void triangularPrint(){
        d1.pointPrint();
        d2.pointPrint();
        d3.pointPrint();
        d4.pointPrint();
        System.out.println();
    }
    
}


