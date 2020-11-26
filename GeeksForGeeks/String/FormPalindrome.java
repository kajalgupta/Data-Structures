package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * FormPalindrome
 */
public class FormPalindrome {
    public static int getMinimumInsertion(String str, int l, int h) {

        if(l>h) return Integer.MAX_VALUE;
        if(l==h) return 0;
        if(l==h-1) 
        return (str.charAt(l)==str.charAt(h))?0:1;
        if(str.charAt(l)==str.charAt(h))
            return getMinimumInsertion(str, l+1, h-1);
        else
            return Math.min(getMinimumInsertion(str, l, h-1), getMinimumInsertion(str, l+1, h))+1;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            String str = br.readLine();
            System.out.println(getMinimumInsertion(str, 0, str.length()-1));
           // List<Integer> li = new ArrayList<>();

        }
    }
}