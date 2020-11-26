package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SaveIronMan
 */
public class SaveIronMan {

    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            
            convertAlphaNumeric(br.readLine().toCharArray());
        }
    }

    private static void convertAlphaNumeric(char[] charArray) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
       System.out.println(checkPalindrome(sb.toString().toLowerCase())); 
    }

    private static String checkPalindrome(String string) {
        System.out.println(string);
        int length = string.length();
        int i=0;
        int j = 0;
        if (length%2==0) {
            j = length/2;
            i = j-1;
        } else {
            j = length/2+1;
            i = j-2;
        }
        char[] charray = string.toCharArray();
        while (i>=0 && j<length) {
            if (charray[i]==charray[j]) {
                --i;
                j++;
            } 
            else{
                return "NO";
            }
        }
        return "YES";
        
    }

    
}