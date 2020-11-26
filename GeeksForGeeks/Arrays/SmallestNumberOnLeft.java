package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestNumberOnLeft {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int n = Integer.parseInt(br.readLine()); 
            String[] str = br.readLine().split("\\s+");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            StringBuilder result = new StringBuilder("-1");
            int small = arr[0];
            //int flag = 0;
            for (int i = 1; i < arr.length; i++) {
                int flag = 0;
                for (int j = 0; j < i; j++) {
                    if(arr[i]>arr[j]){
                        small = arr[j];      
                        flag = 1;
                    }
                }
                if(flag==0){
                     result.append(" ");
                     result.append(-1);
                }
                else{
                    result.append(" ");
                        result.append(small); 
                }
            }
            /*
            for(int i=1; i<n; i++){
                result.append(" ");
                if(arr[i]>arr[i-1]){
                    result.append(arr[i-1]);
                    if(arr[i-1]<small)
                    small = arr[i-1];
                }
               
                else{
                    if(arr[i]>small){
                        result.append(small); 
                    }
                    else{
                        small = arr[i];
                        result.append(-1);
                    }
                   
                    //small = arr[i];
                }
            }
            */
            System.out.println(result);
        }
    }

}