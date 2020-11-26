import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SeparateNumbers {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         for(int t = Integer.parseInt(br.readLine()); t>0; t--){
             String str = br.readLine();
             separateNum(str);
            

         }
         
    }

    private static void separateNum(String str) {
        int i = 0;
        for ( i = 0; i < str.length()/2; i++) {
            String first = str.substring(0, i+1);
            String start = first;
            long temp = Long.valueOf(start);
            while (first.length() < str.length()) {
                first += String.valueOf(temp + 1);
                temp += 1;
            }
            System.out.println(first);
            if (first.equals(str)) {
                System.out.println("YES "+start);
                break;
            }
        }
        if( i == str.length()/2) System.out.println("NO");
    }

}
