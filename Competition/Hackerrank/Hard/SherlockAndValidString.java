import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SherlockAndValidString {
     public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(find(str));

    }

    private static String find(String str) {
        if (str.length() == 1) {
            return "YES";
        }
        Map<Character, Integer > map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get( str.charAt(i) )+1 );
            }
            else{
                map.put(str.charAt(i), 1);
            }
        }
        
        int maxValue = Collections.max(map.values());
        List<Integer> result = new ArrayList<>();
        for (Map.Entry< Character, Integer > entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        Collections.sort(result);
        
        int min = result.get(0);
        int max = result.get( result.size() - 1 );
        if(min == max) return "YES";
        Map<Integer, Integer > map2 = new HashMap<>();
        for (Integer integer : result) {
            if (map2.containsKey(integer)) {
                map2.put(integer, map2.get(integer)+1 );
            } else {
                map2.put(integer, 1);
            }
        }
        if (map2.size() >  2) {
            return "NO";
        }
        int key1 = -1;
        int value1 = -1;
        int value2 = -1;
        int key2 = -1;
        boolean flag = false;
        for (Map.Entry<Integer, Integer> entry : map2.entrySet() ) {
            if(!flag) {key1 = entry.getKey();
                value1 = entry.getValue();
                flag = true;
            }
            else {key2 = entry.getKey();
                value2 = entry.getValue();
            }
        }
        if (value1 != 1 && value2 != 1) {
            return "NO";   
        }

        if(Math.abs(key1-key2) != 1) return "NO";
        if ((key1==1 && value1 == 1) || (key2==1 && value2 == 1)) {
            return "YES";
        }
        if(value1 == 1 ){
            if (key1 - key2 == 1) {
                return "YES";
            }
            else{
                return "NO";
            }
        }
        else{
            if (key2 - key1 == 1) {
                return "YES";
            }
            else{
                return "NO";
            }
        }

     }
}
