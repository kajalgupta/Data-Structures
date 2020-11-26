package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * LongestPalindrome
 */
public class LongestPalindrome {

    public static void printSubStr(String str, int low, int high) {
        System.out.println(str.substring(low,high+1));
    }

    public static void LongestPalindromeSubstring(String str) {
        int length = str.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int maxLength = 1;
        int count = 0;
        //length - 2
        for (int i = 0; i < dp.length-1; i++) {
            if (str.charAt(i)==str.charAt(i+1)) {
                dp[i][i+1] = true;
                ++count;
                if(count==1)
                start =i;
                //start = i;
                maxLength = 2;
            }
        }
        for (int k = 3; k<= dp.length; k++) {
            for (int i = 0; i <=length-k; i++) {
                int j = i+k-1;
                if (dp[i+1][j-1] && str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = true;
                    if(k>maxLength){
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        printSubStr(str,start, start+maxLength-1);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String str =  br.readLine();
            LongestPalindromeSubstring (str);

            }
        }

    }
