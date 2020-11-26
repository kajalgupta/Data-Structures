package Competition.Hackerrank.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringsIntroduction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A =  br.readLine();
        String B =  br.readLine();
        System.out.println(A.length()+B.length());
        System.out.println(isLexicographicallyGreater(A,B));
        System.out.println(A.substring(0, 1).toUpperCase()+A.substring(1)+" "+B.substring(0, 1).toUpperCase()+B.substring(1));

        
    }

    private static String isLexicographicallyGreater(String a, String b) {
        int n = (a.length()<b.length())?a.length():b.length();
            for (int i = 0; i < n; i++) {
                if(a.charAt(i)<b.charAt(i))
                return "No";
                if(a.charAt(i)>b.charAt(i))
                return "Yes";
                
            }
            if (a.length()>b.length()) {
                return "Yes";
            }
            
            
        return "No";
    }
}