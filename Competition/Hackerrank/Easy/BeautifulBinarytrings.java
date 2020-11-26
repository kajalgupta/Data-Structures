import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BeautifulBinarytrings {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());
         String str = br.readLine();
         String str2 = str;
         int count = 0;
         for (int i = 0; i < str.length() - 2 ; i++) {
             if (str.charAt(i) == '0' && str.charAt(i+1) == '1' && str.charAt(i+2) == '0' ) {
                 str2 = str.substring(0, i+2) + "1" ;
                 str = (i+3 < str.length()) ? str2 + str.substring(i+3) : str2;
                 System.out.println(str);
                 count += 1;
             }
         }
         
         System.out.println(count);
    }
}
