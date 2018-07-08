
public class napChong{
    public static void main(String[] args){
	hinhHoc h = new hinhHoc();
	h.area(4);
	h.area(13,11);
    }
}

class hinhHoc{
    public void area(int a){
	int area = a*a;
	System.out.println(area);
    }
    public void area(int a,int b){
	int area = a*b;
	System.out.println(area);
    }
    // 2 functions with same name but different para
}
