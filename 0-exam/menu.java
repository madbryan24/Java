
import java.util.Scanner;

public class project1Student{
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int choice;
	do{
	    System.out.println("MENU");
	    System.out.println("1. ");
	    System.out.println("2. ");
	    System.out.println("3. ");
	    System.out.println("4. ");
	    System.out.println("5. ");
	    System.out.println("6. ");
	    System.out.println("7. ");
	    System.out.println("8. ");
	    System.out.print("Enter the function you want to execute: ");
	    choice = sc.nextInt();

	    if(choice!=1 && choice!=2 && choice!=3 && choice!=4 && choice!=5 && choice!=6 && choice!=7 && choice!=8){
		System.out.println("Wrong input, please try again \n");
	    }

	    switch (choice){
            case 1:{
            }
                break;

            case 2:{
            }
                break;

            case 3:{
            }
                break;

            case 4:{
            }
                break;

            case 5:{
            }
                break;

            case 6:{
	    }
                break;
	    case 7:{
	    }
                break;
	    case 8:{
	    }
                break;

            default: break;
	    }
	}while(choice!=8);
    }
}
