package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * URL_Shortener
 */
public class URL_Shortener {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            long n = Long.parseLong(br.readLine());
            long rem = 0;
            long temp = n;
            StringBuilder sb = new StringBuilder();
            String format = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            while (n>0) {
                rem = n%62;
                n = n/62;
                sb.append(format.charAt((int)rem));
            }
            System.out.println(sb.reverse().toString());
            System.out.println(temp);
        }
    }
}