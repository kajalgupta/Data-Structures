package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


/**
 * RemoveCommonCharacters
 */
public class RemoveCommonCharacters {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            String s1 = br.readLine();
            String s2 = br.readLine();           
            HashMap<Character,Integer> map = new HashMap<>();
            StringBuilder sb = new StringBuilder(" ");
            for (int i = 0; i < s2.length(); i++) {
                map.put(s2.charAt(i),1);   
            }
            for (int i = 0; i < s1.length(); i++) {
                if (map.containsKey(s1.charAt(i))) {
                    map.put(s1.charAt(i), 2);
                }
                else sb.append(s1.charAt(i));
                  
            }
            /*for(Map.Entry<Character,Integer> entry : map.entrySet()){
                if (entry.getValue()==1) {
                    sb.append(entry.getKey());
                }
            }
            */
            for (int i = 0; i < s2.length(); i++) {
                if (map.get(s2.charAt(i)) == 1)
                 {
                     sb.append(s2.charAt(i));
                    //map.put(s1.charAt(i), 2);
                }
                
                  
            }

            if (sb.toString().equals(" ")) {
                System.out.println(-1);
            }
            else{
                System.out.println(sb.toString());
            }
            

        }
       


    }
}