public class classt{
    public static void main(String[] args){
        student s1 = new student();
	s1.name = "Ha Le Thinh";
	s1.age = 20;
	
	System.out.println(s1.name);
	System.out.println(s1.age);
    }
}

class student{
    String name;
    int age;
    public void action(){
	System.out.println("Studying");
    }
}
