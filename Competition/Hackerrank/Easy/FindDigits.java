import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindDigits {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int n = Integer.parseInt(br.readLine());
            System.out.println(find(n));
        }
    }

    private static int find(int n) {
        if (n/10<0) {
            return 1;
        }
        int divisorCount = 0;
        int num = n;
        while (n!=0) {
            int digit = n%10;
            if (digit!=0 && num%digit==0) {
                divisorCount++;
            }
            n=n/10;
            
        }

        return divisorCount;
    }
    
}