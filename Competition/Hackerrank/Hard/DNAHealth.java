import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class DNAHealth {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());
         String[] genes = br.readLine().split("\\s+");
         String[] healthstr = br.readLine().split("\\s+");
         int[] health = new int[ n ];
         for (int i = 0; i < healthstr.length; i++) {
             health[i] = Integer.valueOf( healthstr[i] );
         }
         int strands = Integer.parseInt(br.readLine());
         while (strands > 0) {
            String[] str = br.readLine().split("\\s+");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);
            String d = str[2];
            
            --strands;
             
         }
    }
}
