public class getterSetter{
    public static void main(String[] args){
        student s1 = new student();
	s1.setName("Ha Le Thinh");
	s1.setAge(20);
	
	System.out.println(s1.getName());
	System.out.println(s1.getAge());
    }
}

class student{
    private String name;
    private int age; //cannot get private info
    public void action(){
	System.out.println("Studying");
    }

    public void setName(String name){
	this.name = name;
    }
    public String getName(){
	return name;
    }

    public void setAge(int age){
	this.age = age;
    }
    public int getAge(){
	return age;
    }
    
}
