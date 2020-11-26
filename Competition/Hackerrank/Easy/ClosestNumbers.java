package Competition.Hackerrank.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ClosestNumbers {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int n = Integer.parseInt(br.readLine());
             
            int[] arr = new int[n];
            String[] str = br.readLine().split("\\s+");
            for (int i = 0; i <n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Object[] result = closestNumbers(arr);
            System.out.println(result);
        }
   // }

    private static Object[] closestNumbers(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> arrList = new ArrayList<>();
       // int[] result = new int[arr.length];
        int minDifference = Integer.MAX_VALUE;
        int k = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int diff = arr[i+1]-arr[i];
            if (diff<minDifference) {
                minDifference = diff;
            }
        }
        for (int i = 0; i < arr.length-1; i++) {
            int diff = arr[i+1]-arr[i];
                if (diff==minDifference) {
                      //result[k++] = arr[i];
                      arrList.add(arr[i]);
                      arrList.add(arr[i+1]);
                }            
        }
        return arrList.toArray();
    }
}
/*abstract

-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854

*/