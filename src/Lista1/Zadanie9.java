import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Zadanie9 {


    public static boolean checkIP(String ip) {
        String pattern = "((25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9])";
        return ip.matches(pattern);
    }

    public static boolean checkDate(String date) {
        String pattern = "((0[1-9])|([1-2][0-9])|(3[0-1]))-((0[1-9])|(1[0-2]))-[0-9]{4}";
        if (date.matches(pattern)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            try {
                dateFormat.parse(date);
                return true;
            } catch (ParseException ex) {
                return false;
            }

        }
        return false;
    }
}
