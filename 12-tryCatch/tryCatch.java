import java.util.Scanner;

public class tryCatch{
    public static void main(String[] args){
	int a,b;
	float div=0;
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter a: ");
	a = sc.nextInt();
	System.out.print("Enter b: ");
	b = sc.nextInt();
	//try catch still run the rest of the code if wrong
	try{
	    div = (float)a/b;
	}catch(ArithmeticException e){
	    System.out.println("Wrong logic");
	}finally{ // always run regardless of wrong or right
	    System.out.println("Here's finally");
	}
	System.out.println("a : b = " + div);
    }
}
