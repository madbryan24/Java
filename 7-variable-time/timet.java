import java.util.Date;
import java.text.SimpleDateFormat;

public class timet{
    public static void main(String[] args){
	Date day = new Date();
	SimpleDateFormat n = new SimpleDateFormat("HH:mm:ss");
	String time = n.format(day.getTime());
	System.out.println(time);
    }
}
