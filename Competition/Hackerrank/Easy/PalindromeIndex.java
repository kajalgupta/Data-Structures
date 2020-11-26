import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
            String str = br.readLine();
            System.out.println(check(str));
        }
    }

    private static int check(String str) {
        int i = 0;
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                break;
        }
        if (i == str.length()) {
            return -1;
        }
        if (isPalindrome(str.substring(i + 1, str.length() - i))) {
            return i;
        }
        if (isPalindrome(str.substring(i , str.length() - 1 - i))) {
            return str.length() - 1 - i;
        }
        
        return -1;
    }

    private static boolean isPalindrome(String substring) {
        if (substring.length() == 2) {
            return substring.charAt(0) == substring.charAt(1);
        }
        int n = substring.length()/2;
        int k = (n % 2 == 0) ? 0 : 1;
        String first = substring.substring(0, n);
        String last = substring.substring(n+k, substring.length());
        System.out.println(first+"   "+last);
        if (new StringBuilder(last).reverse().toString().equals(first)) {
            return true;
        }
        
        return false;
    }
}
