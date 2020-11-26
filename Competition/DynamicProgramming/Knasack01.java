import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Knasack01 {
    static int s = 0;
    static int n = 0;
     public static void main(String[] args) throws IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String[] str = br.readLine().split("\\s+");
            s = Integer.parseInt(str[0]);
            n = Integer.parseInt(str[1]);
            int dp[][] = new int[s+1][n+1];
            int[] weight = new int[n];
            int[] values = new int[n];
            for(int i = 0; i < n; i++){
                String[] str2 = br.readLine().split("\\s+");
                weight[i] = Integer.parseInt(str2[0]);
                values[i] = Integer.parseInt(str2[1]);
            }
            System.out.println(knapsack(weight, values, s, n, dp));
        }
    }
    static int profit = 0;
    
    
    private static int knapsack(int[] weight, int[] values, int capacity, int n, int[][] dp) {
        //System.out.println("profi"+profit);
        if( n == 0 || capacity == 0){
            return 0;
        }
        if(dp[capacity][n-1] != 0)
            return dp[capacity][n-1];
        else if(weight[n - 1] > capacity){
            return dp[capacity][n-1] = knapsack(weight, values, capacity, n-1, dp);
        }
        else{
            return dp[capacity][n-1] = Math.max (values[n - 1] + knapsack(weight, values, capacity - weight[n - 1], n -1,
                    dp), knapsack(weight, values, capacity, n - 1, dp));
        }
      //  return profi;
    }
}
