package GeeksForGeeks.HardProblems;

 /*
* @author [Milan Kushwah]
* @create date 2020-03-26 04:17:46
* @modify date 2020-03-26 04:17:46
* @desc [description]
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SuperPrimes {
   public static void main(String[] args) throws IOException {
       boolean sieve[] =  sieveOfEratosthenes(10000001);
       ArrayList<Integer> listPrime = new ArrayList<>();
       for(int i = 2; i < sieve.length; i++){
           if(sieve[i]){
               listPrime.add(i);
           }
       }
       int arr[] = solution(sieve, listPrime);
       int temp = 0;
       for(int i = 0; i < arr.length; i++){
           arr[i] = temp + arr[i];
           temp = arr[i];
       }
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       for (int j = Integer.parseInt(br.readLine()); j > 0; j--) {
           int index = Integer.parseInt(br.readLine());
           System.out.println(arr[index]);
       }
   }

   static boolean[] sieveOfEratosthenes(int size){
       boolean prime[] = new boolean[size];
       Arrays.fill(prime, true);
       prime[0] = false;
       prime[1] = false;
       for(int i = 2; i*i < size; i++){
           if(prime[i]){
               for(int p = i*i; p < size; p+=i){
                   prime[p] = false;
               }
           }
       }
       return prime;
   }

   static int[] solution(boolean sieve[], ArrayList<Integer> listPrime){
       int arr[] = new int[sieve.length];
       System.out.println("List is "+listPrime);
       Arrays.fill(arr, 0);int index = 5, point = 1;
       for(int i = 5; i < sieve.length; i++){
           if(sieve[i]){
               int temp = i - listPrime.get(point);
               if(sieve[temp]){
                   arr[i] = 1;
               }
               point++;
           }
       }
       return arr;
   }

}