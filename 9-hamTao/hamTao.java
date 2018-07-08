public class hamTao{
    public static void main(String[] args){
        student s1 = new student();
	s1.name = "Ha Le Thinh";
	s1.age = 20;
	
	System.out.println(s1.name);
	System.out.println(s1.age);
        s1.action();
    }
}

class student{
    String name;
    int age;
    public student(){
	System.out.println("Here is student's creation function");
    } // this will run when creating variable and preceedingly before any method
    
    public void action(){
	System.out.println("Studying");
    }
}
