package Competition.Hackerrank.Java;

import java.util.Scanner;
import java.util.TreeSet;

public class StringCompare {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAdLargest(s,k));

    }

    private static String getSmallestAdLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        TreeSet<String> subsets = new TreeSet<>();
        for (int i = 0; i <= s.length()-k; i++) {
             subsets.add(s.substring(i,i+k));
        }
        smallest = subsets.first();
        largest = subsets.last();
        return smallest + "\n" + largest;
    }
}