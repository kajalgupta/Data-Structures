package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MinimumNumberOfJumps {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("\\s+");
            int[] input = new int[n];
            for (int i = 0; i < str.length; i++) {
                input[i] = Integer.parseInt(str[i]);
            }
            //System.out.println(countJumps(input, n));
            int result = (countJumps(input, n)==2147483646)?-1:countJumps(input,n);
        System.out.println(result);
        }
    }

    private static int countJumps(int[] list, int length) {
        
        int[] jumps = new int[length];
        //Arrays.fill(jumps, 10000000);
        for(int i=1; i < list.length ; i++){
            jumps[i] = Integer.MAX_VALUE-1;
        }
        jumps[0] = 0;
        //System.out.println("max"+jumps[1]);
        if (list[0]==0) {
            return -1;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (i<=j+list[j]) {
                    jumps[i] = Math.min(jumps[j]+1, jumps[i]);
                }
            }
        }
       
        return jumps[length-1];
    }

}