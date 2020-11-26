import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class FunnyString {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         for(int t = Integer.parseInt(br.readLine()); t>0; t--){
             String str = br.readLine();
             System.out.println(funnyString(str));
         }
         
         
    }

    private static String funnyString(String str) {
        int[] arr = new int[str.length()];
        int[] revarr = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
            revarr[revarr.length - 1 - i] = arr[i];
            
        }
        for (int i = 0; i < revarr.length-1; i++) {
            if( Math.abs( revarr[i] - revarr[i+1]) != Math.abs( arr[i] - arr[i+1]) ) return "Not Funny";
        }
        
        return "Funny";
    }
}
