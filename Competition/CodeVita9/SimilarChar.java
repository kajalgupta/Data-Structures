package Competition.CodeVita9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SimilarChar {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int n = Integer.parseInt(br.readLine()); 
        br.readLine();
        String str = br.readLine();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int q = Integer.parseInt(br.readLine()); q>0; q--){
            int index = Integer.parseInt(br.readLine()); 
            if (map.containsKey(index)) {
                System.out.println(map.get(index));
            }else{
            char c = str.charAt(index-1);
            int count = 0;
            int fromIndex = 0;
            while ((fromIndex = str.indexOf(c, fromIndex))!=-1 && fromIndex<index-1) {
                count++;
                fromIndex++;
            }
            //str.indexOf(c, 0);
            
            /*
            for (int i = 0; i < index-1; i++) {
                if (str.charAt(i)==c) {
                    count++;
                }
            }
            */
            map.put(index, count);
            System.out.println(count);
        }
    }
    }
    
}