import java.util.Scanner;

public class arrayt{
    public static void main(String[] args) {
	int i,j;
	int a[] = new int[10];
	for(i=0;i<10;i++){
	    a[i]=i;
	    System.out.print(a[i] + " ");
	}
	System.out.println("");
	System.out.println("");
	
	float b[][] = new float[5][10];
	float m=1;
	for(i=0;i<5;i++){
	    for(j=0;j<10;j++){
		b[i][j]=m;
		System.out.print(b[i][j] + " ");
		m++;
	    }
	    System.out.println("");
	}
    }
}
