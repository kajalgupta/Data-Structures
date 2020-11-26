import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class HighestValuePalindrome {
     public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split("\\s+");
    int n = Integer.parseInt(str[0]);
    int k = Integer.parseInt(str[1]);
    String string = br.readLine();
    System.out.println(check(string, n, k));
    }

    private static String check(String str, int n, int k) {

        int even = ( n%2 == 0 ) ? 1 : 0;
       for (int i = 1; i < str.length()/2 ; i++) {
            if ( str.charAt(n/2 - i) == str.charAt(n/2 + i - even ) ) {
                
            }
        }
        return null;
    }
}
