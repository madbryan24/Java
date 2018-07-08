import java.util.Scanner;

public class function4{
    public static void zz() {
	Scanner sc = new Scanner(System.in);
	System.out.println("please enter your love: ");
	String s = sc.nextLine();
	System.out.println("Your life is: " + s);
    }

    public static int oz() {
	int a=5,b=10;
	int tong = a+b;
	return tong;
    }

    public static void zo(int a, int b) {
	int tong =a*b;
	System.out.println(tong);
    }

    public static int oo(int a, int b){
	int tong =a-b;
	return tong;
    }
    
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("1. 0 return, 0 para");
	System.out.println("2. 1 return, 0 para");
	System.out.println("3. 0 return, 1 para");
	System.out.println("4. 1 return, 1 para");
	int choice;	
	choice = sc.nextInt();
	
	switch (choice){
	case 1:{
	    zz();
	}
	    break;
	case 2:{
	    System.out.println(oz());
	}
	    break;
	case 3:{
	    int a=5,b=10;
	    zo(a,b);
	}
	    break;
	case 4:{
	    int a=5,b=10;
	    int n = oo(a,b);
	    System.out.println(n);
	}
	    break;
	default:{
	    System.out.println("Day invalid");
	}
	}
    }
}
