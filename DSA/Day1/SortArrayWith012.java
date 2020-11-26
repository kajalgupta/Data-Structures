package DSA.Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortArrayWith012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        sortArrayInPlace(arr);

    }

    private static void sortArrayInPlace(int[] arr) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0) zeroCount++;
            else if(arr[i]==1) oneCount++;
            else twoCount++;
        }
        int i=0;
        for (;i < zeroCount; i++) {
            arr[i] = 0;
        }
        int j = 0;
        for (;j< oneCount; i++, j++) {
            arr[i] = 1;
        }for (j=0;j < twoCount; i++,j++) {
            arr[i] = 2;
        }
        System.out.println(Arrays.toString(arr).replace("[", "").replace("]", "").replace(",", ""));
        return;
    }
    
}