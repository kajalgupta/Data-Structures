package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * GeekAndItsColouredStrings
 */
public class GeekAndItsColouredStrings {
    

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            String[] input = br.readLine().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int r = Integer.parseInt(input[1]);
            int g = Integer.parseInt(input[2]);
            int b = Integer.parseInt(input[3]);
            int rem = n-(r+g+b);
            long ans =0;
            for (int i = 0; i <= rem; i++) {
                for (int j = 0; j <= rem; j++) {
                    int k = rem - (i+j);
                    if(k<0) break;
                    ans += fact(n)/(fact(r+i)*fact(b+j)*fact(g+k));
                }
                
            }
            System.out.println(ans);
        }
    }

    private static long fact(int n) {
        long factorial =1;
        if(n==0)
            return 1;
        while (n>=1) {
            factorial  = factorial*n;
            --n;
        }
        return factorial;
    }
}