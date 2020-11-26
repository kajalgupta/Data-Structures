package GeeksForGeeks.HardProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinimumNumberToMakeMedian {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
            String[] str = br.readLine().split("\\s+");
            int N = Integer.parseInt(str[0]);
            int X = Integer.parseInt(str[1]);
            String[] str2 = br.readLine().split("\\s+");
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(str2[i]);
            }
            System.out.println(minNumberToMakeMedianX(arr, N, X));
        }
    }

    private static int minNumberToMakeMedianX(int[] arr, int n, int X) {
        // System.out.println(Arrays.toString(arr));
        int maxHeapRoot = 0; // ELEMENTS LESSER THAN X
        int minHeapRoot = Integer.MAX_VALUE;
        int minElementsCount = 0;
        int maxElementsCount = 0;
        int medianEqualsElementCount = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(X);
            System.out.println("arr" + arr[i]);
            if (arr[i] <= X) {
                minElementsCount++;
                System.out.println("hey");
                System.out.println(minElementsCount);
                if (arr[i] > maxHeapRoot) {
                    maxHeapRoot = arr[i];
                }
            }
            // else if (arr[i]>X) {
            else {
                maxElementsCount++;
                if (arr[i] < minHeapRoot) {
                    minHeapRoot = arr[i];
                }
            }
            // else medianEqualsElementCount = 1;
        }
        int difference = Math.abs(maxElementsCount - minElementsCount);
        int median = (minHeapRoot + maxHeapRoot) / 2;
        System.out.println("median is" + median);
        if (median == X) {
            return difference;
        }

        System.out.println("min elements count" + minElementsCount);
        System.out.println("max elements count" + maxElementsCount);
        if (minElementsCount == maxElementsCount)
                return 1; 
        if (maxElementsCount == 0) { // minElementsCount==n-1 && minElementsCount==n
            return minElementsCount;
        }
        /*
        if (minElementsCount < maxElementsCount) {
            int difference = maxElementsCount - minElementsCount;
            return difference;

        }
        */  

        // if (medianEqualsElementCount==1 &&
        if (Math.abs(maxElementsCount - minElementsCount) == 1) {
            return 1;

        }
System.out.println();

        int elements = difference-1;
        /*
        if (n % 2 != 0 && difference >= 1) {
            // elements = difference-1; //damn sure this no. of elements needs to be added. 
         2   if (maxHeapRoot == X) { 
                return elements;
            } else {
                return ++elements;
            }
        }
        */
         if (minElementsCount>maxElementsCount) {
        if (maxHeapRoot == X) { 
            return elements;
        } else {
            return elements+2;
            //return ++elements;
        }
    }
        if (minElementsCount<maxElementsCount) {
            if (minHeapRoot==X) {
                return elements;
            }
            else{
                return elements+2;
            }
            
        }
        return 0; 
    }
}