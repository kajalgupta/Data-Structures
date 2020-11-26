package Competition.CodeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ChefAndRecipe {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int n = Integer.parseInt(br.readLine()); 
            String[] str = br.readLine().split("\\s+");
            int[] arr = new int[n];
            int max = 0;
            for (int i = 0; i < str.length; i++) {
                arr[i] =  Integer.parseInt(str[i]);
                if(arr[i]>max) max = arr[i];
            }
            System.out.println(chefRecipe(arr,max,n));
        }
    }

    private static String chefRecipe(int[] arr, int max, int n) {
        boolean[] flag = new boolean[max+1];
            for (int i = 0; i < n; i++) {
                if (flag[arr[i]]) {
                    System.out.println(i);
                    return "NO";
                }
                flag[arr[i]] = true;
                while (i<n-1 && arr[i]==arr[i+1]) {
                    i++;
                }
            }
            Arrays.sort(arr);
           // int[] freq = new int[n];
           List<Integer> freq = new ArrayList<>();
            int k =0;
            for (int i = 0; i < n; i++) {
                int count = 1;
                    while (i<n-1 && arr[i]==arr[i+1]) {
                        count++;
                        i++;
                    }    
                    //freq[k] = count;
                    freq.add(count);
                    k++;
            }
           // Arrays.sort(freq);
           Collections.sort(freq);
            //System.out.println("freq array is");
            // for (int i = 0; i < freq.size(); i++) {
            //     System.out.println(freq[i]);
            // }
            n = freq.size();
            for (int i = 0; i <n ; i++) {
                if (i<n-1 && freq.get(i)==freq.get(i+1)) {
                    //System.out.println("i is"+i);
                    return "NO";
                }
            }
            return "YES";
    }
}