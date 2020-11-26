package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
//import java.util.stream.Stream;

/**
 * RepeatedCharacter
 */
public class RepeatedCharacter {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            String str = br.readLine();
            LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < str.length(); i++) {
                if(map.containsKey(str.charAt(i)))
                    map.put(str.charAt(i), map.get(str.charAt(i))+1);
                else
                    map.put(str.charAt(i), 1);
            }
            /*map.forEach((K, V) -> {
                if(V>1){
                    System.out.println(K);
                    break;
                }
            });
            */
            int flag = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if(entry.getValue()>1){
                    flag = 1;
                    System.out.println(entry.getKey());
                    break;
                } 
            }
            if(flag==0) System.out.println(-1);

        }
    }
}