import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MakingAnagram {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {

            String str1 = br.readLine();
            String str2 = br.readLine();
            
            System.out.println(anagram(str1, str2));
        }
    }

    private static int anagram(String str1, String str2) {
        
        int[] arr = new int[26];
        for (char c : str1.toCharArray()) {
            arr[c-97]++;
        }
        for (char c : str2.toCharArray()) {
            arr[c-97]--;
        }
        int count = 0;
        for (int c : arr) {
            count += Math.abs(c);
        }
        return count;
    }
    
}
