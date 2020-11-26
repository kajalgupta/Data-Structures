package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

import java.util.TreeMap;

/**
 * SecondMostrepeated
 */
public class SecondMostrepeated {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            TreeMap<String, Integer> map = new TreeMap<>();
            for (int i = 0; i < str.length; i++) {
                if (map.containsKey(str[i])){
                    map.put(str[i], map.get(str[i])+1);
                } else {
                    map.put(str[i], 1);
                }
            }
            List<Integer> list = new ArrayList<>();
            map.forEach((K,V) -> {
                list.add(V);
            });
            Collections.sort(list);
            
            map.forEach((K,V) -> {
                if(V==list.get(list.size()-2))
                 System.out.println(K);;
            });
//System.out.println(map + "   "+ max);
        }
    }
}