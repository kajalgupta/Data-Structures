package GeeksForGeeks.HardProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("\\s+");
            int[] nums = new int[n];
            for (int i = 0; i < str.length; i++) {
                //list.add(Integer.parseInt(str[i]));
                nums[i] = Integer.parseInt(str[i]);
            }
            String result = canPartition(nums) ? "YES" : "NO";
            System.out.println(result);

        }
    }

    private static boolean canPartition(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        if (total%2!=0) {
            return false; 
        }
        return canPartition(nums,total/2);
    }

    private static boolean canPartition(int[] nums, int sum) {
        boolean[][] dp = new boolean[nums.length][sum+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        Arrays.sort(nums);
        int i=0;
        for (int j = 1; j < sum+1; j++) {
            if (j<nums[i]) {
                dp[i][j] = false;
            }
            else if (j==nums[i]) {
                dp[i][j] = true;
            }
            else{
                break;
            }
            
        }
        for ( i = 1; i < dp.length; i++) {
            for (int j = 1; j <sum+1; j++) {
                if (nums[i]>j) {
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                
                }
            }
        }
        //System.out.println(
           return dp[dp.length-1][sum];
    }

}