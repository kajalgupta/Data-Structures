package Competition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AnotherBirthdayPresent {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String[] str = br.readLine().split("\\s+");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            String[] str2 = br.readLine().split("\\s+");
            int[] arr = new int[n];
            boolean[] arr3 = new boolean[n+1];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str2[i]);  
            }
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (arr[i]>n) {
                    flag = true;
                    break;
                }
                else{
                    arr3[arr[i]] = true;
                }
            }
            int[] arr2 = arr.clone();
           
            Arrays.sort(arr2);
            int countSorted = 0;
            if(flag==false){
                //int count = 0;
            int c = 0;
            
            for(int i = 0; i < n; i++){
                if(arr[i]!=arr2[i]){
                    int temp = arr[i] - (i+1);
                    if(temp % k == 0){
                        countSorted += temp;
                    }else{
                        c += Math.abs(temp);
                    }
                }
            }

            if(countSorted == 0 && c == 0){

                System.out.println("yes");
            }else{
                System.out.println("no");
            }

            }
            else{

            


            
           // while (!Arrays.equals(arr, arr3)) {
               while(true){
                int swap = 0;
            for (int i = 0; i < n-k; i++) {
                if (arr[i]!=arr2[i] && arr[i]>arr[i+k]) {
                
                   int temp = arr[i];
                   arr[i] = arr[i+k];
                   arr[i+k] = temp; 
                    swap++;
            
            if (arr[i]==arr2[i]) {
                countSorted++;
            }
            if (arr[i+k]==arr2[i+k]) {
                countSorted++;
            }
         }
        }
        if (swap==0 || countSorted==n) {
            break;
        }
    }
    if(Arrays.equals(arr, arr2)){
        System.out.println("yes");
       }
       else{
        System.out.println("no");
       }
    }
           // System.out.println(arr2.toString());
            //System.out.println(arr.toString());
           // System.out.println(Arrays.toString(arr2));
           //System.out.println(Arrays.toString(arr));
/*
           if(Arrays.equals(arr, arr2)){
            System.out.println("yes");
           }
           else{
               //reverse
               for(int i=0; i<n/2; i++){
                int temp = arr2[i];
                arr2[i] = arr2[n -i -1];
                arr2[n -i -1] = temp;
            }
            if(Arrays.equals(arr, arr2)){
                System.out.println("yes");
               }
               else{
                System.out.println("no");
               }
              
           }
           */
           //System.out.println(Arrays.toString(arr2));
           //System.out.println(Arrays.toString(arr));
        }
    }

}