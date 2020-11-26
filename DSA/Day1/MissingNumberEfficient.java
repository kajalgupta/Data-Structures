package DSA.Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumberEfficient {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(findMissingNumber(arr));

    }

    private static int findMissingNumber(int[] arr) {
       
        
        int missingNumber = arr.length;
        int i =0;
        while (i<arr.length) {
            missingNumber ^= i^arr[i];
            i++;
        }
        return missingNumber;
    }
    
}