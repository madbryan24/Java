import java.util.ArrayList;

public class arrayList{
    public static void main(String[] args) {
	int i;
        ArrayList<Integer> a = new ArrayList<Integer>();
	for(i=0;i<10;i++){
	    a.add(i);
	    System.out.print(a.get(i) + " ");
	}
	System.out.println("");
    }
}
