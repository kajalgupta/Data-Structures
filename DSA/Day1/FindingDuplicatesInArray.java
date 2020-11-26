package DSA.Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindingDuplicatesInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(findDuplicateNumber(arr));
    }

    private static int findDuplicateNumber(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]==arr[i+1]) {
                return arr[i];
            }
        }
        return -1;
    }
    
}