package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int n = Integer.parseInt(br.readLine()); 
            String[] str = br.readLine().split("\\s+");
            int[] arr = new int[n];
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
                int lastDigit = arr[i]>9?arr[i]/10:arr[i];
                if (!list.contains(lastDigit)) {
                    list.add(lastDigit);
                }
            }
            nextPermutation(arr,n);
        }
    }

    private static void nextPermutation(int[] arr, int n) {
        int k=n-1;
        int i=0;
        for ( i = n-2; i>=0; i--) {
            if(arr[i]<arr[i+1]){
                while(arr[i]>arr[k]){
                    k--;
                }
                int data = arr[i];
                arr[i] = arr[k];
                arr[k] = data;
                break;
            }
        }
        Arrays.sort(arr, i+1, n);
        System.out.println(Arrays.toString(arr).replace("[", "").replaceAll("]", "").replaceAll(",", ""));
    }
    
}