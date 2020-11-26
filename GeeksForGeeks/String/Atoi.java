package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Atoi
 */
public class Atoi {

    public static int atoi(String str) {
        if(str.charAt(0)=='-'){
            StringBuilder sb = new StringBuilder(str);
            sb.deleteCharAt(0);
            str = sb.toString();
            if(str!=null && str.matches("^[0-9]+"))
            return Integer.parseInt(str)*-1;
        }
         
        if(str!=null && str.matches("^[0-9]+"))
        return Integer.parseInt(str);
        return -1;
       

        
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t >0; t--) {
            System.out.println(atoi(br.readLine()));
        }
    }
}