package Competition.CodeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChefAndNumbers {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int n = Integer.parseInt(br.readLine()); 
            String[] str = br.readLine().split("\\s+");
            int input[] = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] =  Integer.parseInt(str[i]);
            }
            int[] count = new int[1001];
            count[0] = 0;
            for (int i = 0; i < n; i++) {
                count[input[i]]++;
                if ((i+1)<n && input[i+1]==input[i]) {
                    input[i+1] = 0;
                    i++;
                }
            }
            int[] arr = count.clone();
            Arrays.sort(count);
            int max = count[1000];
           // System.out.println(max);
            int i=1;
            for (; i < 10001; i++) {
                if (arr[i] == max) {
                    //System.out.println(arr[i]);
                    break;
                }
            }
            System.out.println(i);
        }
    }

}