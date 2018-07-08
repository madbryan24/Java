public class ghiDe{
    public static void main(String[] args){
        student s1 = new student();
	s1.eat();

    }
}

class human{
    public void eat(){
	System.out.println("Eat");
    }
}


class student extends human{ //student can you method of human
    public void eat(){
	super.eat(); //call the function overwrited if needed
	System.out.println("Studying"); 
    }//overwrite the function eat
}
