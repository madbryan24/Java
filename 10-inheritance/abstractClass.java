public class abstractClass{
    public static void main(String[] args){
        student s1 = new student();
	student s2 = new student("Nguyen Khanh Linh");
	s1.name = "Ha Le Thinh";
	s1.age = 20;
	
        s1.action();

	s1.eat();
	s1.sleep();
	//inheritance
	s1.love();
	//abstract class
    }
}

class human{
    public void eat(){
	System.out.println("Eat");
    }
}

class human1 extends human{ //human1 can you method of human
    public void sleep(){
	System.out.println("Sleep");
    }
}

//Abstract class can have no info
//cannot create variable from abstract class
// inheriting from abstract class must define the method
abstract class human2 extends human1{
    public abstract void love();
}
//method of abstract class mustn't have a body

class student extends human2{ //student can you method of human1
    String name;
    int age;
    public student(String name){
	System.out.println(name);
    } // this will run if there is parameters included
    
    public student(){
	System.out.println("Here is student's creation function");
    } // this will run when creating variable and preceedingly before any method
    
    public void action(){
	System.out.println("Studying");
    }

    public void love(){
	System.out.println("love");
    } //define the method of abstract class
}
