package Competition.Hackerrank.Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class AshtonAndString {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());
            System.out.println(ashtonString(str, k));
             }
    }

    private static char ashtonString(String str, int k) {
        char[] arr = str.toCharArray();
        // ArrayList<String> list = new ArrayList<>();
         TreeSet<String> tset = new TreeSet<String>();
         for (int i = 0; i < str.length(); i++) {
             tset.add(Character.toString(arr[i]));
           // list.add(Character.toString(str.charAt(i)));
         }
         tset.forEach(i->System.out.println(i+" "));
         StringBuilder result = new StringBuilder(); 
            if(k<=tset.size()){
                //tset.forEach(i->result.append(i));
                for (String string : tset) {
                    result.append(string);
                   // System.out.println("-----------");
                    if (result.length()>=k) {
                        break;
                    }
                }
            
                return result.charAt(k-1);
            }
             
            
        
     
        return '0';
    }
    
}