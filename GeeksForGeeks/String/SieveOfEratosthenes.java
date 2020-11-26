package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SieveOfEratosthenes
 */
public class SieveOfEratosthenes {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            int n = Integer.parseInt(br.readLine());
            boolean[] arr = new boolean[n+1];
            
            //System.out.println(arr[2]);
            for (int p = 2; p*p<=n; p++) {
                if(arr[p]==false){
                    for (int i = p*2; i <=n ; i+=p) {
                        arr[i] = true;
                    }
                }
            }
            System.out.println(arr[2]);
            for (int i = 2; i < arr.length; i++) {
                if(arr[i]==false) System.out.print(i+" ");
            }
         System.out.println();
        }
    }
}