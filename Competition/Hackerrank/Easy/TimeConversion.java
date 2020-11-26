package Competition.Hackerrank.Easy;


    import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {
    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        
        /*
         * Write your code here.
         */
            String a = new String("12:00:00AM");
            String b = new String("12:00:00PM");
            if(s.equals(a)) return "00:00:00";
            if(s.equals(b)) return "12:00:00";
            if (s.startsWith("12")&& s.endsWith("AM")) {
                StringBuilder sb = new StringBuilder(s);
                sb.delete(s.length()-2, s.length());
                sb.replace(0, 2, "00");
            }
            if (s.startsWith("12")&& s.endsWith("PM")) {
                StringBuilder sb = new StringBuilder(s.substring(0, s.length()-2));
                //sb.delete(s.length()-2, s.length());
                //sb.replace(0, 2, "00");
                return sb.toString();
            }
            if (s.endsWith("PM")) {
                StringBuilder sb = new StringBuilder(s);
                sb.delete(s.length()-2, s.length());
                String val = String.valueOf(Integer.parseInt(sb.substring(0, 2))+12);
               // System.out.println(
                    sb.replace(0, 2, val);
                return sb.toString();
            }
            else{
                StringBuilder sb = new StringBuilder(s);
                sb.delete(s.length()-2, s.length());
                return sb.toString();
            }
        //return s;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);
       // System.out.println(result);
        //bw.write(result);
        //bw.newLine();

        //bw.close();
    }
}

    
