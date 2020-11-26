package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * SmllestPalindrome
 */
public class SmllestPalindrome {

    static String PalindromeSubsequence(String s){
        int size = s.length();
        if (size==1) {
            return s;
        }
        else{
            List<String> list = new ArrayList<>();
            for (int i = 0; i < s.length()-1; i++) {
                if (s.charAt(i)==s.charAt(i+1)) {
                    StringBuilder x = new StringBuilder(); 
                    x.append(s.charAt(i+1));
                    list.add(x.toString());
                }
            }
            if (list.isEmpty()) {
                //int length = 3;
                for (int i = 1; i < size-1; i++) {
                    //for (int j = i+1; j < size-1; j++) {
                        if (s.charAt(i-1)==s.charAt(i+1)) {
                            StringBuilder temp = new StringBuilder(); 
                            temp.append(s.charAt(i-1));
                            temp.append(s.charAt(i));
                            temp.append(s.charAt(i+1));
                            
                        }
                        
                    //}
                }
            }
        }
        return "-1";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        System.out.println(PalindromeSubsequence(st)); 
    }
}