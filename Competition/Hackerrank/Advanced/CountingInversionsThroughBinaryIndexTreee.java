import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountingInversionsThroughBinaryIndexTreee {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("\\s+");
            int[] arr = new int[n];
            for (int i = 0; i < n ; i++){
            arr[i] = Integer.parseInt(str[i]);
            }
           System.out.println(countInversion(arr, n));
        }
    }

    private static int countInversion(int[] arr, int n) {
        System.out.println("array is"+ Arrays.toString(arr));
        convert(arr);
       // System.out.println("array is"+ Arrays.toString(arr));
        int[] bit = new int[arr.length+1];
       // return 0;
        for (int i = 0; i < bit.length; i++) {
            bit[i] = 0;
        }
        int invCount = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            invCount += getSum(bit, arr[i]-1); //parent
            updateBinaryindexTree(bit, 1, arr[i]);
        }
        return invCount;
    }

    private static void updateBinaryindexTree(int[] bit, int value, int index) {
        //getNext
        while (index<bit.length) {
            bit[index] += value;
            index = getNext(index);
        }
    }

    private static int getNext(int index) {
        return index+(index & -index);
    }

    private static int getSum(int[] bit, int index) {
        int sum = 0;
       // index = index+1;
        while (index >0) {
            sum += bit[index];
            index = getParent(index);
        } 
        return sum;
    }

    private static int getParent(int index) {

        return index - (index & -index );
    }

    private static int[] convert(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = binarySearch(copy,arr[i])+1;
        }
        return arr;
    }

    private static int binarySearch(int[] copy, int element) {
        int indexLow = 0;
        int high = copy.length-1;
        while (indexLow<=high) {
            int mid = (indexLow+high)/2;
            if (copy[mid]==element) {
                return mid;
            }
           else if (element < copy[mid]) {
               high = mid-1; 
            }
            else
                indexLow = mid+1;
        }
        return -1;
    }
}