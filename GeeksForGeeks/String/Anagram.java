

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Anagram
 */
public class Anagram {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            String[] arr = br.readLine().split(" ");
            System.out.println(arr.length);
            String str1 = arr[0];
            
            System.out.println(str1);
            String str2 = arr[1];
            System.out.println(str2);
            if(str1.length()==str2.length()){
                
            }
            List<Character> li = new ArrayList<>();
            System.out.println(li);
            for(char c : str1.toCharArray()){
                li.add(c);
            }
            //System.out.println(li);
            //StringBuilder sb = new StringBuilder(arr[0]);
            for (char c: str2.toCharArray()) {
               if (li.contains(c)) {
                   li.remove(Character.valueOf(c));
               }
            }
          
            if(li.isEmpty())
                System.out.println("YES");
                else{
                    System.out.println("NO");
                }
          
        }
    }
}