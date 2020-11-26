package Competition.Hackerrank.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class testing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+"); 
        int n = str.length;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        StringBuilder sb2 = new StringBuilder("");
        for (int k = 0; k < n; k++) {
            sb2.append(arr[k]);
        }
        int store=0;
        int j=2;
        StringBuilder rev = new StringBuilder(sb2.substring(store, j + 1));
        System.out.println(rev);
    }
    
}