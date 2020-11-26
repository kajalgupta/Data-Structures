package Competition.Hackerrank.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;

public class LarrysArray {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int n = Integer.parseInt(br.readLine()); 
            String[] str = br.readLine().split("\\s+");
            int[] arr = new int[n]; 
            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(str[j]);     
            }
           System.out.println(larrysArray(arr));
            

        }
    }

    private static String larrysArray(int[] arr) {
        int inversionCount = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]>arr[j]) {
                    inversionCount++;
                }
            }
             
        }
        if (inversionCount%2==0) {
            return "YES";
        }
        return "NO";
    }
}