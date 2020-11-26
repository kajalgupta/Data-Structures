import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * BetweenTwoSets
 */
public class BetweenTwoSets {

     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        List<Integer> list1 = new ArrayList<>();
        String[] str2 = br.readLine().split("\\s+");
        for (int i = 0; i < str2.length; i++) {
            list1.add(Integer.parseInt(str2[i]));
        }
        List<Integer> list2 = new ArrayList<>();
        String[] str3 = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            list2.add(Integer.parseInt(str3[i]));
        }
        System.out.println(getAns(list1, list2));
    }

    private static int getAns(List<Integer> list1, List<Integer> list2) {
        int lcm = lcm(list1);
        int i = 1;
        int hcf = gcd(list2);
        int count = 0;
        while (i*lcm <= hcf) {
            if(hcf % (i*lcm) == 0)
                count++;
            i++;
        }
        return count;
    }
 
    private static int lcm(List<Integer> a) {
        int lc = a.get(0);
        for(int i = 1; i < a.size(); i++){
            lc = lc * a.get(i) / gcd(lc, a.get(i));
        }
        return lc;
    }

    public static int gcd(List<Integer> b) {
        int hcf = b.get(0);
        for(int i = 1; i < b.size(); i++){
            hcf = gcd(hcf, b.get(i));
            if(hcf == 1)
                return 1;
        }
        return hcf;
    }

    private static int gcd(Integer num1, Integer num2) {
        if(num1 == 0)
            return num2;
        if(num2 == 0)
            return num1;
        return gcd(num2, num1 % num2);
        
    }
}