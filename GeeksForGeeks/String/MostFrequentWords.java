package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * MostFrequentWords
 */
public class MostFrequentWords {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t> 0; t--) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("\\s+");
            HashMap<String, Integer> map = new HashMap<>();
            List<String> list = new ArrayList<>();
            List<String> maxlist = new ArrayList<>();
            
            for (int i = 0; i < str.length; i++) {
                list.add(str[i]);
                if (map.containsKey(str[i])) {
                    map.put(str[i],map.get(str[i])+1);
                }
                else{
                    map.put(str[i], 1);
                }    
            }
            //System.out.println(map);
            int max = Collections.max(map.values());
            map.forEach((K, V) -> {
                if (V==max)
                maxlist.add(K);
            });
            //System.out.println(maxlist);
            if (maxlist.size()>1) {
                int maxIndex = list.indexOf(maxlist.get(0));
               for (int i = 1; i < maxlist.size(); i++) {
                   int index = list.indexOf(maxlist.get(i));
                   if (index>maxIndex) {
                       maxIndex = index;
                   }
               }
               System.out.println(list.get(maxIndex)); 
            }
            else{
                System.out.println(maxlist);
            }
        } 
    }
}