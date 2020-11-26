import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppendAndDelete {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String strTarget = br.readLine();
        int k = Integer.parseInt(br.readLine());
        System.out.println(check(str, strTarget, k));
    }

    private static String check(String str, String strTarget, int k) {
        if (k>=str.length()+strTarget.length()) {
            return "Yes";
        }
        if (str.equals(strTarget)) {
            if (k%2==0) {
                return "Yes";
            }
            return "No";
        }
        int i = 0;
        int length = (str.length()<strTarget.length())?str.length():strTarget.length();
        while (i<length && str.charAt(i)==strTarget.charAt(i)) {
            i++;
        }
        System.out.println(i+"[[[");
        if (i<str.length()-1 || i<strTarget.length()-1) {
            int remain = str.length()-i;
            int remainTarget = strTarget.length()-i;
            System.out.println(remain+"remain "+remainTarget);
            if (remain+remainTarget == k) {
                return "Yes";
            }
            if (k<remain+remainTarget ) {
                return "No";
            }
            if ((k-remain+remainTarget ) %2==0) {
                return "Yes";
            }
            
            
        }
        
        return "No";
    }
    
}