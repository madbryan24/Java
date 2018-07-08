public class statict{
    public static void main(String[] args){
        student s1 = new student();
	
	System.out.println(student.point);
	student.action(); //call method with static without creating a variable
    }
}

class student{
    String name;
    int age;
    public static int point = 10;
    public static void action(){
	System.out.println("Studying");
    }

    public void eat(){
	System.out.println("Eat");
    }
    public void sleep(){
	System.out.println("Sleep");
    }


}
