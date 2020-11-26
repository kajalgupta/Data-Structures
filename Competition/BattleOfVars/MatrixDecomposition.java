package Competition.BattleOfVars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MatrixDecomposition {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String[] str = br.readLine().split("\\s+");
            int n = Integer.parseInt(str[0]);
            int a  = Integer.parseInt(str[1]);
            long modulus = 1000000007;
            //long pi = a;
            long psum = 0;
            int i = 1;
            long base = a;
            while (i<=n) {
              //pi = exp(a*pi,2*i-1,modulus);
              long pi = exp(base, 2*i-1, modulus);
              base = ((base%modulus)*(pi%modulus))%modulus;
              psum = ((psum%modulus) + (pi%modulus))%modulus;
              System.out.println("in while pi "+pi);
              System.out.println("in while psum "+psum);
              i++;
            }
            System.out.println("answer"+psum%modulus);
            /*-----------------Not Efficient Appproach ----------------------------------------------------
            //List<Integer> list = new ArrayList<>();
           // List<Integer> list = new ArrayList<>(Collections.nCopies(n, a));
           BigInteger[] matrix = new BigInteger[n*n];
            Arrays.fill(matrix, BigInteger.valueOf(a));
            int i = 1;
            //System.out.println(list);
            BigInteger psum = BigInteger.ZERO;
            
            int length = n*n;
            while (i<=n) {
                int deleteElements = 2*i-1;
                BigInteger pi = BigInteger.ONE;
                BigInteger num = matrix[0];
                for (int k = 1;  k<=deleteElements; k++) {
                    
                    pi  = pi.multiply(num);
                  //  System.out.println(i+" is i");
                  //  System.out.println("pi is "+pi+"for i "+i);
                    length--;
                }
               // System.out.println(matrix[0]);
                //System.out.println(pi);
                for (int j = 0; j < length; j++) {
                   matrix[j] = matrix[j].multiply(pi);
                }
                pi = pi.mod(BigInteger.valueOf(1000000007));
                psum = psum.add(pi);
                i++;        
            }
         //System.out.println(psum%1000000007);
           System.out.println(psum.mod(BigInteger.valueOf(1000000007)));
           ------------------------------------------------------------------------------------------------
           */
        }
    }

    private static long exp(long base, long exponent, long modulus) {
      if (exponent==1) {
        return base%modulus;
      }
      if ((exponent&1)==1) {
        return ((base%modulus)*exp(base, exponent-1, modulus)%modulus);
      }
      long ans = exp(base, exponent/2, modulus);
      //System.out.println("in recursion");
      return (ans*ans)%modulus;
    }
}