package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;

/**
 * StringIgnorance
 */
public class StringIgnorance {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
            char[] str = br.readLine().toCharArray();
            //HashSet<Character> set = new HashSet<Character>();
            List<Character> list = new ArrayList<>();
            String resultString = "";

            for(int i=0; i<str.length; i++){

              // if(Character.isUpperCase(str[i])){
                if (list.contains(str[i])){
                    list.remove((Character)str[i]);
               } 
               else if(list.contains((char)(str[i]+32))){
                list.remove((Character)(char)(str[i]+32));
               }
               else if(list.contains((char)(str[i]-32))){
                list.remove((char)(str[i]-32));
               }
              else {
                   list.add(str[i]);
                    resultString += str[i];
               }
                //set.add(str.charAt(i));
            }
            //System.out.println(resultString.substring(0, 1).toUpperCase() + resultString.substring(1));
            System.out.println(resultString);
        }
    }
}