import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class TwoStrings {
     public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for(int t = Integer.parseInt(br.readLine()); t>0; t--){

        String str1 = br.readLine();
        String str2 = br.readLine();
        System.out.println(fun(str1, str2));
        
        
    }
}

private static String fun(String str1, String str2) {
  //  List<Character> list = new ArrayList<>();
    int[] arr = new int[26];


    for (int i = 0; i < str1.length(); i++) {
        arr[str1.charAt(i)-97]++;
        //list.add(str1.charAt(i));
        //if(str2.indexOf(str1.charAt(i))>=0) return "YES";
    }
    for (int i = 0; i < str2.length(); i++) {
        // if (list.contains ( str2.charAt(i) ) ) {
        //     return "YES";
        // }
        if (arr[str2.charAt(i)-97] > 0) {
            return "YES";
        }
    }
    return "NO";
}
}
