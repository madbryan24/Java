

public class innerClass{
    public static void main(String[] args){
        student s1 = new student();
	s1.name = "Ha Le Thinh";
	s1.age = 20;
	
	s1.outerShow();// outerShow will call innerShow

    }
}



class student{ 
    String name;
    int age;
    public void outerShow(){
	inner n = new inner();
	n.innerShow();
    } 
    

    class inner{
        public void innerShow(){
	    System.out.println("inner");
	} 
    }

}
