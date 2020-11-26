import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class AlternatingCharacters {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String str = br.readLine();
            StringBuilder  sb = new StringBuilder(str);
            int count = 0;
            for (int i = 0; i < sb.length()-1; i++) {
                if(sb.charAt(i) == sb.charAt(i+1)){     
                    sb.deleteCharAt(i);
                    i--;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
