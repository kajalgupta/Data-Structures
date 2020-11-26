import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.HashSet;

public class Gemstones {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int n = Integer.parseInt(br.readLine());
          String[] arr = new String[n];
          for (int i = 0; i < arr.length; i++) {
              arr[i] = br.readLine();
          }
          System.out.println(gemstones(n, arr));
          System.out.println(gemstones(arr));
    }

    private static int gemstones(int n, String[] arr) {
        if (n == 1) {
            return 0;
        }
        int[] count = new int[27];
        for(int i = 0; i < arr.length; i++){
            Set<Character> set = new HashSet<>();
            for(int j = 0; j < arr[i].length(); j++ ){
                if( !set.contains( arr[i].charAt(j) ) )  count[arr[i].charAt(j) - 96 ]++;
                set.add(arr[i].charAt(j));
            }
        }
        int ans = 0;
        for(int i : count){
            if(i == n)
                ans++;
        }

        return ans;
    }
    private static int gemstones(String[] arr) {
        Set<Character> set = new HashSet<>();
        set = convertToSet( arr[0] );
        for(int i = 1; i< arr.length; i++){
            set.retainAll(convertToSet(arr[i]));
        }
        return set.size();
    }

    private static Set<Character> convertToSet(String string) {
        Set<Character> set = new HashSet<>();
        for( char c : string.toCharArray() ){
            set.add(c);
        }
        return set;
    }
}
