package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * StringRotatedBy2Places
 */
public class StringRotatedBy2Places {

    static String check(String s1, String s2){
        s1 = s1+s1;
        if(s1.contains(s2))
        return "1";
        return "0";
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            System.out.println(check(br.readLine(), br.readLine()));
        }
    }
}