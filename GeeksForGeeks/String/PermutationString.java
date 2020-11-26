package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PermutationString
 */
public class PermutationString {
    static void permutation(String str, int l, int r){
        if (l==r) {
            System.out.println(str);
        }
        else{
            for (int i = l; i <= r; i++) {
               str = swap(str, l, i);
               permutation(str, l+1, r);
               str = swap(str, l, i);
            }
        }
    }
    public static String swap(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            String str = br.readLine();
            permutation(str,0,str.length()-1);
        }
    }
    
}