package Competition.Hackerrank.Easy;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HalloweenSale {

    // Complete the howManyGames function below.
    static int howManyGames(int p, int d, int m, int s) {
        
        // Return the number of games you can buy
        if (s<p) {
            return 0;
        }
        if (s==p) {
            return 1;
        }
        //Series Solution
        int firstTerm = p;
        int n=1;
//       p-d>s
            s-=p;
        while (p-d>m) {
            p-=d;
            if (p>s) {
                return n;
            }
            s-=p;          
            n++;
        }
        System.out.println("last p "+p);
        int productCount = n;
        //int money = n/2*(2*firstTerm+(n-1)*d);
        /*
        int money = n*(firstTerm+p);
        money = money/2;

        System.out.println("money to be subtracted"+money);
        int remainningMoney = s-money;
        System.out.println("products"+productCount);
        productCount += remainningMoney/m;
     */
    productCount+= s/m;
        /*
        s-=p; //80-20
        int count = 1;
        while (s>=m) {
            
            if (p<m) {
                p=m;
            }
            else p-=d;
            s-=p;
            if (s<0) {
                return count;
            }
            System.out.println("s is"+s);//9908//9909
            System.out.println("count  is"+count);//9908//9909
            
            count++;
        }
        */
        return productCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] pdms = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pdms[0]);

        int d = Integer.parseInt(pdms[1]);

        int m = Integer.parseInt(pdms[2]);

        int s = Integer.parseInt(pdms[3]);

        int answer = howManyGames(p, d, m, s);
        System.out.println(answer);
        //bufferedWriter.write(String.valueOf(answer));
       // bufferedWriter.newLine();

      //  bufferedWriter.close();

        scanner.close();
    }
}
