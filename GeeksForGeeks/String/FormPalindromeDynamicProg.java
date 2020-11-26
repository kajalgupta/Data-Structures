package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * FormPalindromeDynamicProg
 */
public class FormPalindromeDynamicProg {

    public static int getMinInsertion(char str[], int n) {
        int[][] table = new int[n][n];
        //int h=0;
        for (int len = 1; len < n; len++) {
            for (int l = 0, h=len; h <n ; l++, h++) {
                table[l][h] =  (str[l]==str[h]) ? table[l+1][h-1] : Math.min(table[l][h-1], table[l+1][h])+1;
            }
        }
        return table[0][n-1];
        
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            String s = br.readLine();
            System.out.println(getMinInsertion( s.toCharArray(), s.length()));
        }
    }
}