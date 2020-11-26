import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SaveThePrisonner {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String[] str = br.readLine().split("\\s+");
            long n = Long.parseLong(str[0]);
            long m = Long.parseLong(str[1]);
            long s = Long.parseLong(str[2]);
            System.out.println("ans is"+saveThePrisoner(n, m, s));
        }
        
    }

    private static long saveThePrisoner(long n, long m, long s) {
        if (n>m) {
            if (s+m-1 <= n) {
                return s+m-1;
            } else {
                m -= (n-s+1);
            }
            return m;
        } else  {
            if (m%n==0) {
                if(s==1)
                return n;
                return s-1;
            }
            else{
                System.out.println("----------"+m%n);
                return (s+(m%n)-1)%n==0?n:(s+(m%n)-1)%n;
            }
        }
       
    }
    
}