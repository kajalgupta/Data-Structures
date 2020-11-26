package GeeksForGeeks.HardProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinimumSumPartition {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] array = new int[n];
            for (int i = 0; i < str.length; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            System.out.println(findMinimumSumPartition(array));
        }
    }

    private static int findMinimumSumPartition(int[] array) {
        int total = 0;
        for (int i : array) {
            total += i;
        }
        int sum = (total % 2 != 0) ? total / 2 + 1 : total / 2;
        int minPossibleSubSetSum1 = possibleSubsetSum(array, sum, total);
        int minPossibleSubsetSum2 = total - minPossibleSubSetSum1;
        return (minPossibleSubSetSum1 - minPossibleSubsetSum2);
    }

    private static int possibleSubsetSum(int[] array, int sum, int total) {
        boolean[][] dp = new boolean[array.length][total];
        Arrays.sort(array);
        for (int j = 0; j < dp.length; j++) {
            dp[j][0] = true;
        }
        dp[0][array[0]] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j < array[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - array[i]];
                }

            }

        }
        if (dp[array.length - 1][sum]) // subset with half sum is possible
            return sum;
        return nextPossibleSubsetSum(array, dp, sum + 1);
    }

    private static int nextPossibleSubsetSum(int[] array, boolean[][] dp, int sum) {
        int i = 0;
        dp[0][sum] = sum > array[i] ? false : true;
        for (int j = 1; j < dp.length; j++) {

            if (sum< array[i]) {
                dp[j][sum] = dp[j - 1][sum];
            } else {
                dp[j][sum] = dp[j - 1][sum] || dp[j - 1][sum - array[j]];
            }

            //dp[j][sum] = dp[j - 1][sum] || dp[j - 1][sum - array[j]];
            if (dp[j][sum]) {
                return sum;
            }
        }

        return nextPossibleSubsetSum(array, dp, sum + 1);
    }

}