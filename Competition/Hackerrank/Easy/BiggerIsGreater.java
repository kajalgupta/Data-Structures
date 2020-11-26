package Competition.Hackerrank.Easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BiggerIsGreater {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String sb) {

        if (sb.length() == 1) {
            return "no answer";
        }
        if (sb.length() == 2) {
            if (sb.charAt(0) < sb.charAt(1)) {
                StringBuilder sbr = new StringBuilder(sb);
                return sbr.reverse().toString();
            } else {
                return "no answer";
            }
        }

        StringBuilder w = new StringBuilder(sb);
        int n = w.length();
        int k = w.length() - 2;
        // int i = 0;
        while (k >= 0 && w.charAt(k) >= w.charAt(k + 1)) {
            k--;
        }
        if (k < 0) {
            return "no answer";
        }
        // k-->> pivot
        int pivot = k;
        System.out.println("pivot is"+pivot);
        k = w.length() - 1;
        while (k > pivot && w.charAt(k) <= w.charAt(pivot)) {
            k--;
        }
        int rightSuccessorOfPivot = k;
        // swap
        char ch = w.charAt(rightSuccessorOfPivot);
        w.setCharAt(rightSuccessorOfPivot, w.charAt(pivot));
        w.setCharAt(pivot, ch);
        StringBuilder st = new StringBuilder(w.substring(pivot + 1));
        st.reverse();
        w.replace(pivot + 1, n, st.toString());
        return w.toString();
    }

    private static boolean check(String sb, String result) {
        for (int i = 0; i < result.length(); i++) {
            if (sb.charAt(i) > result.charAt(i))
                return true;
            else if (sb.charAt(i) < result.charAt(i))
                break;
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();
            String result = biggerIsGreater(w);
            if (w.equals(result)) {
                System.out.println("--------");
                System.out.println("no answer");
            } else if (check(w, result)){
                System.out.println("re"+result);
                System.out.println("++++++++++++");
                System.out.println("no answer");
  
            }
                         else
                System.out.println(result);
        }
        scanner.close();
    }
}
