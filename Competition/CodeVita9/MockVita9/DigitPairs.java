package CodeVita9.MockVita9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;

public class DigitPairs {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("\\s+");
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++){
        arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(calculate(arr, n));
    }

    private static int calculate(int[] arr, int n) {
        int possiblePairs = 0;
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int a = value/100;
            int b = (value%100)/10;
            int c = value%10;
            int largest = 0;
            int smallest = 0;
            if (a>b && a>c) {
                largest = a;
                if (b>c) {
                    smallest = c;
                }
                else smallest = b;
            }
            else if (c>b && c>a) {
                largest = c;
                if (b>a) {
                    smallest = a;
                    //System.out.println(a+"a & b"+b);
                }
                else smallest = b;
            }
            else{
                largest = b;
                if (c>a) {
                    smallest = a;
                }
                else smallest = c;
            }
            arr[i] = largest*11 + smallest*7;
            if (arr[i]/100 >=1) {
                int b2 = (arr[i]%100)/10;
            int c2 = arr[i]%10;
            arr[i] = b2*10+c2;
           // System.out.println(arr[i]+"-----");
            }
            if (arr[i]/10 >= 1) {
                arr[i] = arr[i]/10;
            }
        }
      //  System.out.println("-------"+Arrays.toString(arr));
        int[] count = new int[10];
        for (int i = 0; i < n; i+=2) {
            count[arr[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i]==2) {
                possiblePairs++;
            }
            if (count[i]>2) {
                possiblePairs += 2;
            }
        }
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
        for (int i = 1; i < n; i+=2) {
            count[arr[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i]==2) {
                possiblePairs++;
            }
            if (count[i]>2) {
                possiblePairs += 2;
            }
        }


        return possiblePairs;
    }
    
}