package Competition.CodeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndDemonetisation {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t> 0; t--) {
            String[] str = br.readLine().split("\\s+");
            long S = Long.parseLong(str[0]);
            long N = Long.parseLong(str[1]);
            System.out.println(coinsNeeded(S,N));
        }

    }
   private static long coinsNeeded(long S, long N){
       if (S==1) {
           return 1;
       }
       if (S%N==0) {
           return S/N;
       } else {
           long x = S/N;
           long k = (S-x*N)%2==0?1:2;
          // System.out.println(S-x*N);
           return x+k;
       }

    }
    
}