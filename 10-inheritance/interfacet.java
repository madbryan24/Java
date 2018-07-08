public class interfacet{
    public static void main(String[] args){
        student s1 = new student();
	s1.name = "Ha Le Thinh";
	s1.age = 20;
	
	System.out.println(s1.name);
	System.out.println(s1.age);
        s1.action();

	s1.eat();
	s1.sleep();
    }
}

interface human{
    public void eat();
}
interface human1{ 
    public void sleep();
}

class student implements human1,human{ // can inherite more than 1
    String name;
    int age;

    public void action(){
	System.out.println("Studying");
    }

    public void eat(){
	System.out.println("Eat");
    }
    public void sleep(){
	System.out.println("Sleep");
    }


}
