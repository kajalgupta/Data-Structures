package Competition.BattleOfVars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RackUpTheCoupons {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); 
        String[] str = br.readLine().split("\\s+");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        int z = Integer.parseInt(str[2]);
        int a = t-x;
        if (a==y || a==z) {
            System.out.println("Possible to achieve exact amount");
        }
        else{
            //System.out.println("Overpaid! These scammers owe me");
            int b = t-y;
            if (b==x || b==z) {
                System.out.println("Possible to achieve exact amount");
            }
            else{
                //System.out.println("Overpaid! These scammers owe me");
                int c = t-z;
                if (c==x || c==y) {
                    System.out.println("Possible to achieve exact amount");
                }
                else{
                    System.out.println("Overpaid! These scammers owe me");
                }
            }
        }

    }
}