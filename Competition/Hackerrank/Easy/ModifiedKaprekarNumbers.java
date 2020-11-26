package Competition.Hackerrank.Easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModifiedKaprekarNumbers {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
   int p = sc.nextInt();
  sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?"); 
  int q = sc.nextInt();
  sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?"); 
  
   kaprekarNumbersInRange(p,q);
   sc.close();
    }

    private static void kaprekarNumbersInRange(int p, int q) {
        boolean flag = false;
        for (int i = p; i <=q; i++) {
            long n = i;
            String square = String.valueOf(n*n);
            int d = String.valueOf(square).length();//n;
            int r = Integer.parseInt((square.substring(d/2, square.length()).isEmpty()?"0":square.substring(d/2)));
            int l = Integer.parseInt(square.substring(0, d/2).isEmpty()?"0":square.substring(0,d/2));
            if (l+r==n) {
                System.out.print(n+" ");
                flag = true;
                
            }

        }
        if(!flag) System.out.println("INVALID RANGE");
       // System.out.println(result.toString());
    }
    

    
}