

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JumpingOnTheCloudsRevisited {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        String[] str2 = br.readLine().split("\\s+");
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str2[i]);
        }
        System.out.println(jumpingOnClouds(arr, k));
    }

    private static int jumpingOnClouds(int[] arr, int k) {
        int start = 0;
        
        int n= arr.length;
        int E = 100;
        if (n==k) {
            return (arr[0] == 1)?E-3:E-1;
        }
        int next =  start+k;
        E = (arr[next] == 1)?E-3:E-1;
        
        while (next!=0) {
           
           // else{
                next = next+k;
                if (next > n-1) {
                    int remain = next-(n-1);
                    next = remain-1;
                }
                //start = next;
               System.out.println(next+"----");
            
            E = (arr[next] == 1)?E-3:E-1;
            System.out.println(E+"++");
            
        }
        return E;
    }
    
}