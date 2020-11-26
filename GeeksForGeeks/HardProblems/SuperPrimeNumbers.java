package GeeksForGeeks.HardProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class SuperPrimeNumbers {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[10000001];
        int[] array = new int[10000001];
        arr = findingPrimesThroughSieves(arr.length);   
        //System.out.println(arr[4]);
        array = findingSuperPrime(arr);
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(array[n]);
        }
    }

    private static boolean[] findingPrimesThroughSieves(int length) { 
        boolean[] array = new boolean[length];
        for (int p = 2; p*p<array.length; p++) {
            if (array[p]==false) {
                for (int i = p*2; i <array.length; i=i+p) {
                    array[i] = true;
                }
            }
        }
      // arr = 
        return array;  
    }

    private static int[] findingSuperPrime(boolean[] array) {
        List<Integer> list = new ArrayList<>();
        int n = 0;
        for (int i = 2; i < array.length; i++) {
            if (!array[i]) {
                list.add(i);
                n++;
            }
        }
        //System.out.println();
        System.out.println("list element is "+list.get(2));
        int[] superPrimeCount = new int[array.length];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (list.contains(list.get(i)-list.get(i-1))) {
                count++;
                superPrimeCount[list.get(i)] = count;
            }
            //else{
             //   superPrimeCount[list.get(i)] = count;
            //}
        }
        for (int i = 6; i < superPrimeCount.length; i++) {
            if (superPrimeCount[i]==0) {
                superPrimeCount[i] = superPrimeCount[i-1];
            }
        }
        return superPrimeCount;
    }
}