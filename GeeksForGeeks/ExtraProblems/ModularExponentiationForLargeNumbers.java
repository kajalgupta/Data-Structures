package GeeksForGeeks.ExtraProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ModularExponentiationForLargeNumbers {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String[] str = br.readLine().split("\\s+");
            long a = Long.parseLong(str[0]);
            long b = Long.parseLong(str[1]);
            long x = Long.parseLong(str[2]);
            long ans = exponentCalculation(a,b,x);
            System.out.println(ans);
        }
    }

    private static long exponentCalculation(long base, long exponent, long mod) {
        if (exponent==1) {
            return base%mod;
        }
        if ((exponent&1)==1) {
            return ((base%mod)*exponentCalculation(base, exponent-1, mod)%mod);
        }
        long ans =  exponentCalculation(base, exponent/2, mod);
        return (ans*ans)%mod;
    }

}