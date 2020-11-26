package Competition.Hackerrank.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServiceLane {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int n = Integer.parseInt(str[0]);
         String[] str2 = br.readLine().split("\\s+");
         int[] arr = new int[n]; 
         for (int i = 0; i < n; i++) {
             arr[i] = Integer.parseInt(str[i]);
         }      
         int[][] cases = new int[Integer.parseInt(str[1])][2];
         int k = 0;
         for(int t = Integer.parseInt(str[1]); t>0; t--){
             String[] str3 = br.readLine().split("\\s+");
            int i = Integer.parseInt(str3[0]);
                int j = Integer.parseInt(str3[1]);
                cases[k][0] = i;
                cases[k++][1] = j;
            }
         int[] result = serviceLane(n, cases, arr);
    }

    private static int[] serviceLane(int n, int[][] cases, int[] arr) {
        int[] res = new int[cases.length];
        for (int i = 0; i < res.length; i++) {
            int a = cases[i][0];
            int b = cases[i][1];
            int min = arr[a];
            for (int j = ++a; j <=b; j++) {
                if(arr[j]<min) min = arr[j];
            }
            res[i] = min;
        }
        return res;
    }
}