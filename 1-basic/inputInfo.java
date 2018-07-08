import java.util.Scanner;

public class inputInfo{
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String name;
	int age;
	System.out.println("Please enter name:");
	name = sc.nextLine();
	System.out.println("Please enter name:");
	age = sc.nextInt();
	System.out.println("Your info:");
	System.out.print("Name: ");
	System.out.println(name);
	System.out.print("Age: ");
	System.out.println(age);
    }
}
