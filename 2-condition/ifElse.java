import java.util.Scanner;

public class ifElse{
    public static void main(String[] args) {
	int a;
	Scanner sc = new Scanner(System.in);
	System.out.println("Please enter number:");
	a = sc.nextInt();
	if(a > 0) System.out.println("a > 0");
	else if(a < 0) System.out.println("a < 0");
        else System.out.println("a = 0");
    }
}
