package Competition.Hackerrank.Medium;

import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.sql.Array;
//import java.util.Arrays;

public class AlmostSorted {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // File file = new File("inputAlmostSorted.txt");
        // File file = new File("input.txt");
        // BufferedReader br = new BufferedReader(new FileReader(file));
        // PrintWriter writer = new PrintWriter("result.txt","UTF-8");
        // writer.println();
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("\\s+");
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(almostSorted(arr));
        // writer.println(almostSorted(arr));
        br.close();
        // writer.close();
    }

    private static String almostSorted(int[] arr) {
        if (arr.length == 2) {
            if (arr[0] < arr[1])
                return "yes";
            else {
                return "yes\nswap " + 1 + " " + 2;
            }
        }
        int i = 0;
        int j = 0;
     //   StringBuilder sb = new StringBuilder("");
        int n = arr.length;
        boolean flag = false;
        int len = 0;
        int store = -1;
        while (i < n - 1) {
            if (arr[i] > arr[i + 1]) {// && !flag) {
                if (!flag) {
                    flag = true;
                    store = i;
                }
                len++;

                j = i + 1;
            }
            i++;
        }
        if (len == 0) {
            return "yes";
        }
       // System.out.println("storeeee" + store + j + "len" + len);
        if (len == 2 || len == 1) {
            if (store == 0 && len == 1) {
                return "no";
            }
            int peak1 = (store == 0) ? store : store - 1;
            int valley2 = j;
            int valley1 = store;
            int peak2 = valley2 - 1;
           // System.out.println(peak1 + " " + valley1 + " " + peak2 + " " + valley2);
            if (arr[valley1] < arr[peak2] || arr[valley2] < arr[peak1] || arr[valley2] > arr[valley1]
                    || arr[peak1] > arr[peak2]) {
                return "no";
            }

            swap(j, store, arr);
            for (int k = 0; k < arr.length - 1; k++) {
                for (int k2 = k + 1; k2 < arr.length; k2++) {
                    if (arr[k] > arr[k2]) {
                        return "no";
                    }
                }
            }
            return "yes\nswap " + (store + 1) + " " + (j + 1);
        }

        else {
                String[] tempReverse = reverse(arr, arr.length);
                if(tempReverse[0].equals("true")){
                    System.out.println(tempReverse[1]);
                    System.out.println(tempReverse[2]);
                    
                }
                else{
                    System.out.println(tempReverse[1]);
                    
                }
            /*
            StringBuilder rev = new StringBuilder(sb.substring(store, j + 1));
            // System.out.println(rev"re");
            sb.replace(store, j + 1, rev.reverse().toString());
            System.out.println(rev + "re");
            int[] resultArray = new int[n];

            for (int k = 0; k < arr.length; k++) {
                // System.out.println("sb char"+sb.charAt(k));
                resultArray[k] = Integer.valueOf(sb.substring(k, k + 1));
                // System.out.println("ressss"+resultArray[k]);
            }
            System.out.println("resultant array" + Arrays.toString(resultArray));
            for (int k = 0; k < arr.length - 1; k++) {
                for (int k2 = k; k2 < arr.length; k2++) {
                    if (resultArray[k] > resultArray[k2]) {
                        // System.out.println(resultArray[k]);
                        // System.out.println(resultArray[k2]);
                        return "no";
                    }
                }
            }
            */
            //return "yes\nreverse " + (store + 1) + " " + (i);
            return "";
        }
        //
    }

    private static void swap(int j, int store, int[] arr) {
        int temp = arr[j];
        arr[j] = arr[store];
        arr[store] = temp;
    }
     private static String[] reverse(int[] arr, int size){
         int a = 0 ;
         int b = 0;
         boolean flag = true;
         for(int i=0; i<size-1; i++){
             if(arr[i]>arr[i+1]&& flag){
                 a = i;
                 flag = false;
                 break;
             }
         }
         for(int i=a; i<size-1; i++){
             if(arr[i]<arr[i+1]){
                 b = i;
                break;
             }
             if(i==size-2){
                 b = size-1;
             }
         }
         System.out.println(a+"  --  "+b);
         if(checkSorted(reversePart(arr, a, b),size)){
             String[] aa = {"true", "yes", "reverse "+(a+1)+" "+(b+1)};
                return aa;
         }
         else{
             String[] aa = {"false", "no"};
             return aa;
         }
     }

     private static boolean checkSorted(int[] arr,int n){
         for(int i=0; i<n-1; i++){
             if(arr[i]>arr[i+1]){
                 return false;
             }
         }
         return true;
     }

    private static int[] reversePart(int[] arr, int a, int b){
        int[] temp = new int[b-a+1];
        int j = b-a;
        for(int i=0; i<=b-a; i++ ){
            temp[j--] = arr[a+i];
        }
        j = 0;
        for(int i=a; i<=b; i++){
            arr[i] = temp[j++];
        }
        return arr;

    }
}