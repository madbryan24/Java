import java.util.Scanner;

public class switcht{
    public static void main(String[] args) {
	int a;
	Scanner sc = new Scanner(System.in);
	System.out.println("Please enter day in week:");
	a = sc.nextInt();
	switch (a){
	case 2:{
	    System.out.println("Today is Monday");
	}
	    break;
	case 3:{
	    System.out.println("Today is Tuesday");
	}
	    break;
	case 4:{
	    System.out.println("Today is Wednesday");
	}
	    break;
	case 5:{
	    System.out.println("Today is Thursday");
	}
	    break;
	case 6:{
	    System.out.println("Today is Friday");
	}
	    break;
	case 7:{
	    System.out.println("Today is Saturday");
	}
	    break;
	default:{
	    System.out.println("Day invalid");
	}
	    break;
	}
    }
}
