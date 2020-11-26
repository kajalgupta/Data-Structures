import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SubsetSumProblem {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("\\s+");
        int[] arr = new int[n];
        
            for (int i = 0; i < n ; i++){
            arr[i] = Integer.parseInt(str[i]);
            }
        int target = Integer.parseInt(br.readLine());
        System.out.println(SubsetSum(arr, target));
    }

    private static boolean SubsetSum(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length+1][target+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i == 0)
                    dp[i][j] = false;
                if(j == 0)
                    dp[i][j] = true;
            }
        }
        dp[0][0] = true;
        int sum = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(sum + j > target){
                    dp[i][j] = dp[i-1][j];
                }
                else
                dp[i][j] =  dp[i-1][j] || dp[i-1][target - j];
            }
        }
        return dp[arr.length][target];
    }
}
