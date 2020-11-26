import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Anagram {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {

            String str = br.readLine();
            System.out.println(anagram(str));

        }
    }

    private static int anagram(String str) {

        if (str.length() % 2 != 0) {
            return -1;
        }
        int count = 0;
        List<Character> list = new ArrayList<Character>();
        int n = str.length()/2;
        String str1 = str.substring(0, n);
        String str2 = str.substring(n, str.length());
        for (int i = 0; i < str1.length() ; i++) {
            list.add(str1.charAt(i));
        }
        for (int i = 0; i < str2.length() ; i++) {
            list.remove(Character.valueOf(str2.charAt(i)));
        }
        

        return list.size();
    }
}
