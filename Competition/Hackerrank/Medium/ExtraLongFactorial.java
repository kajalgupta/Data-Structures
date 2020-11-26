import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        extraLongFactorial(n);
        scanner.close();
    }

    private static void extraLongFactorial(int n) {
        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            
            f = f.multiply(BigInteger.valueOf(i));            
        }
        System.out.println(f);
    }
    
}