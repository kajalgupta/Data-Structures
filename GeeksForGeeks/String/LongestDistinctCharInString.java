package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * LongestDistinctCharInString
 */
public class LongestDistinctCharInString {
    public static void main(String[] args) throws Exception {
        
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for(int t = Integer.parseInt(br.readLine()); t>0; t--){ 
        char[] sb = br.readLine().toCharArray();
        
        List<Integer> lengthList = new ArrayList<>();
        for (int i = 0; i < sb.length; i++) {
            int j;
            HashSet<Character> set = new HashSet<>();
            set.add(sb[i]);
            for ( j = i+1; j < sb.length; j++) {
                if(!set.add(sb[j]))
                    break;
                else
                    set.add(sb[j]);
            }
            System.out.println(j+ " "+i);
            lengthList.add(j-i);
        }
        System.out.println(Collections.max(lengthList));
    }
    }

}