/**
 * KnapsackDynamicProgramming - top down approach!
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class KnapsackDynamicProgramming {

     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String[] str = br.readLine().split("\\s+");
            int s = Integer.parseInt(str[0]);
            
            int n = Integer.parseInt(str[1]);
            int[] weight = new int[n];
            int[] values = new int[n];
            for(int i = 0; i < n; i++){
                String[] str2 = br.readLine().split("\\s+");
                weight[i] = Integer.parseInt(str2[0]);
                values[i] = Integer.parseInt(str2[1]);
            }
            System.out.println(knapsack(weight, values, s, n));
  
        }

    }

    private static int knapsack(int[] weight, int[] values, int w, int n) {
        int dp[][] = new int[n+1][w+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(weight[i - 1] > j )
                    dp[i][j] = dp[i-1][j];
                else{
                    dp[i][j] = Math.max(values[i - 1] + dp[i-1][j - weight[i - 1]], dp[i-1][j] );
                }
                }
            }
        printSets(dp, weight,w, values);
        return dp[n][w];
    }

    private static void printSets(int[][] dp, int[] weight, int w, int[] values) {

        int last = dp[dp.length-1][dp[0].length - 1];
        int j = dp[0].length - 1;
        for (int i = dp.length - 2 ;i >= 0; i--) {
            if(last == dp[i][j]){
                continue;
            }
            else{
                 w -= weight[i];
                System.out.println(weight[i] + "val - "+ values[i]);
                j = w;
                if(i != 0)
                last = dp[--i][j];          
            }
        }
    }
}