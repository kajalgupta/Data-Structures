import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class StringConstruction {

     public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for(int t = Integer.parseInt(br.readLine()); t>0; t--){
        String str1 = br.readLine();
       
        System.out.println(solve(str1));

    }
    }

    private static int solve(String str1) {
        int money = 0;
        int[] char1 = new int[26];
        for ( int i = 0 ; i < str1.length() ; i++ ) {
            if(char1[ str1.charAt(i) - 97 ] != 0) continue;
            char1[ str1.charAt(i) - 97 ] += 1;
            money += 1;
        }
        return money;
    }
    
}
