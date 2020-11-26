package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * NonRepeatingCharacter
 */
public class NonRepeatingCharacter {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            int n = Integer.parseInt(br.readLine().trim());
            String str = br.readLine();
            HashSet<Character> set = new HashSet<>();
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if(!set.add(str.charAt(i)))
                list.add(str.charAt(i));
            }
            int flag = 0;
            for (int j = 0; j < n; j++) {
                if (!list.contains(str.charAt(j))) {
                    flag =1;
                    System.out.println(str.charAt(j));
                    break;
                }
            }
            if(flag==0) System.out.println(-1);
        }
    }
}