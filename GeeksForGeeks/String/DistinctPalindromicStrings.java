package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * DistinctPalindromicStrings
 */
public class DistinctPalindromicStrings {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            String str = br.readLine();
            
            HashSet<String> resultSet = new HashSet<>();
            boolean[][] dp = new boolean[str.length()][str.length()];
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                resultSet.add(Character.toString(str.charAt(i)));
                dp[i][i] = true;
            }
            
            for (int i = 0; i < dp.length-1; i++) {
                if (str.charAt(i)==str.charAt(i+1)) {
                    dp[i][i+1] = true;
                    resultSet.add(str.substring(i, i+2)); 
                }
            }
            for (int k = 3; k <= dp.length; k++) {
                for (int i = 0; i <= dp.length-k; i++) {
                    int j =i+k-1;
                    if(dp[i+1][j-1] && str.charAt(i)==str.charAt(j)){
                        dp[i][j] = true;
                        System.out.println(str.substring(i, j+1));
                        resultSet.add(str.substring(i, j+1));
                    }
                    
                }
            }
            System.out.println(resultSet.size());
        }
    }
}