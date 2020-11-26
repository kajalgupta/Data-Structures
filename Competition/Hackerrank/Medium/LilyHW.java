import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class LilyHW {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("\\s+");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
        arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(lilyHw(arr,n));
        
    }

    private static int lilyHw(int[] arr, int n) {
        int swaps = 0;
        int swapsDesc = 0;
        //int swappedElements = 0;
        int[] copy = Arrays.copyOf(arr, n);
        int[] arr2 = Arrays.copyOf(arr, n);
        boolean[] flag = new boolean[n];
        Arrays.sort(copy);
        int[] descCopy = new int[n];
       for (int i = 0; i < descCopy.length; i++) {
           descCopy[i] = copy[n-1-i];
       }
       for (int i = 0; i < n; i++) {
        if (!flag[i]) {
        int sortedIndex = binarySearchDesc(arr[i], descCopy, n);
        if (sortedIndex-i != 0) {
            int temp = arr[i];
            arr[i] = arr[sortedIndex];
            arr[sortedIndex] = temp;
            flag[sortedIndex] = true;
            swapsDesc++;
            i-=1;
           // System.out.println(Arrays.toString(arr));
        }
    }

    }
    for (int i = 0; i < n; i++) {
        flag[i] = false;
    }
        for (int i = 0; i < n; i++) {
            if (!flag[i]) {
            int sortedIndex = binarySearch(arr2[i], copy, n);
            if (sortedIndex-i != 0) {
                int temp = arr2[i];
                arr2[i] = arr2[sortedIndex];
                arr2[sortedIndex] = temp;
                flag[sortedIndex] = true; 
                swaps++;
                i-=1;
               // System.out.println(Arrays.toString(arr2));
            }
        }

        }
       System.out.println(swaps+"----"+swapsDesc);
        return swaps<swapsDesc?swaps:swapsDesc;
    }

    private static int binarySearch(int element, int[] copy, int n) {
        int low = 0; 
        int high = n-1;
        while (low<=high) {
            int mid = (low+high)/2;
            if (copy[mid] == element) {
                return mid;
            }
            else if (copy[mid]<element) {
                low = mid+1;
            }
            else{
                high = mid -1;
            }
        }
        return 0;
    }
    private static int binarySearchDesc(int element, int[] copy, int n) {
        int low = 0; 
        int high = n-1;
        while (low<=high) {
            int mid = (low+high)/2;
            if (copy[mid] == element) {
                return mid;
            }
            else if (copy[mid]>element) {
                low = mid+1;
            }
            else{
                high = mid -1;
            }
        }
        return 0;
    }
}