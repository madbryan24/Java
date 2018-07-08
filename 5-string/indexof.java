public class indexof{
    public static void main(String[] args){
	String s = new String("Linh ham, you are mine,you");
	String s1 = new String("are mine");
	String s2 = new String("you"); // stop when found the first "you"
	String s3 = new String("enjoy it");
	int p1 = s.indexOf(s1);
	int p2 = s.indexOf(s2);
	int p3 = s.indexOf(s3);
	System.out.println(p1);
	System.out.println(p2);
	System.out.println(p3);
    }
}
