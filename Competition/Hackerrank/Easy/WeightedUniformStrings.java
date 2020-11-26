import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class WeightedUniformStrings {
    
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String str = br.readLine();
         
         int last = 0;
         char[] ch = str.toCharArray();
         int continuous = 1;
         Set<Integer> list = new HashSet<>();
         for (char c : ch) {
             int temp = c-'a'+1;
             if (temp == last) {
                 continuous++;
             }
             else{
                 continuous = 1;
                 last = temp;
             }
             list.add( continuous*temp);
         }
        // List<Integer> list = new ArrayList<>();
         for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int n = Integer.parseInt(br.readLine());
            if (list.contains( n )) {
                System.out.println("Yes");
            }
            else  System.out.println("No");
                
         }
    }


}
