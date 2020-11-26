package Competition.CodeVita9.MockVita9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class PrimeFibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int n1 = Integer.parseInt(str[0]);
        int n2 = Integer.parseInt(str[1]);
       System.out.println(primeFibonacci(n1, n2));
    }

    private static long primeFibonacci(int n1, int n2) {
        boolean[] arr = new boolean[n2+1];
        
        for (int p = 2; p*p<=n2; p++) {
            if(arr[p]==false){
                for (int i = p*2; i <=n2 ; i+=p) {
                    arr[i] = true;
                }
            }
        }
        List<Integer> primeList = new ArrayList<>();
        for (int i = n1; i <= n2; i++) {
            if (!arr[i]) {
                primeList.add(i);
            }
        }
       // System.out.println("primelist is");
       // System.out.println(primeList.toString());
        HashSet<String> permutationList = new HashSet<>();
        for (int i = 0; i < primeList.size(); i++) {
            for (int j = 0; j < primeList.size(); j++) {
                if (i!=j) {
                    String k = String.valueOf(primeList.get(i))+String.valueOf(primeList.get(j));
                    permutationList.add(k);
                }
            }
        }
      // System.out.println(permutationList.toString());
      // System.out.println("max"+Collections.max(permutationList));
      Integer max = null;
      for (String string : permutationList) {
          if (max==null) {
              max = Integer.valueOf(string);
          }
          else if (max<Integer.valueOf(string)) {
              max = Integer.valueOf(string);
          }
      }
     // System.out.println(max);
      boolean[] array = new boolean[max+1];
      for (int p = 2; p*p<=max; p++) {
        if(array[p]==false){
            for (int i = p*2; i <=max ; i+=p) {
                array[i] = true;
            }
        }
    }
    List<Integer> secondPrimeList = new ArrayList<>();
    for (String s : permutationList) {
        if (!array[Integer.valueOf(s)]) {
            secondPrimeList.add(Integer.valueOf(s));
        }
        
    }
    Collections.sort(secondPrimeList);  
    int smallest = secondPrimeList.get(0);
    int largest = secondPrimeList.get(secondPrimeList.size()-1);
     //System.out.println(secondPrimeList.size()+"----");
    // System.out.println("smallest"+smallest);
      //  System.out.println("largest"+largest);
        return fibonacciSequence(smallest,largest, secondPrimeList.size());
   
    }

    private static long fibonacciSequence(long smallest, long largest, int n) {
        int i=3;
        long value = 0;
        while (i<=n) {
            value = smallest+largest;
            smallest = largest;
            largest = value;
            i++;
        }
        return value;
    }
    
}