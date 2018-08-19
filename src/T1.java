import java.text.SimpleDateFormat;
import java.util.Date;

public class T1 {

    public static void main(String[] args) {
        String id = "";
        try {
            Integer seq = new Integer(400000);
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMM");
            id += sdFormat.format(new Date());
            id += String.format("%05d", seq % 100000);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        System.out.println(id);
    }
}
