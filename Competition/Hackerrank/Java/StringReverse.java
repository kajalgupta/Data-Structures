package Competition.Hackerrank.Java;

import java.util.Scanner;

public class StringReverse {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        System.out.println(isPalindrome(A));
    }

    private static String isPalindrome(String a) {
        int n = a.length();
        for (int i = 0; i <n/2; i++) {
            if (a.charAt(i) != a.charAt(n-1-i)) {
                return "NO";
            }
        }

        return "YES";
    }
    
}