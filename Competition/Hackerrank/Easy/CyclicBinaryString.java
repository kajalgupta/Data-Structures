/**
 * CyclicBinaryString
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class CyclicBinaryString {

     public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //int n = Integer.parseInt(br.readLine());
  //  String[] str = br.readLine().split( "\s+");
    //for(int t = Integer.parseInt(br.readLine()); t>0; t--){}
   //int a = Integer.parseInt(str[0]);
    String str = br.readLine();
    System.out.println(binary(str));
    }

    private static int binary(String str) {
        //System.out.println("[[[");
        if (str.indexOf('0') < 0 ) {
            return 0;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        int index = sb.toString().indexOf('0');
        //System.out.println(index+"[[[");
        int realIndex = str.length() - 1 - index;
        String next = str.substring(realIndex + 1) + str.substring(0, realIndex + 1);
        int len = next.length();
        long num = 0;
        int i = 0;
        //System.out.println(next+"--");
        int k = 1;
        while(k < len){
            //System.out.println(next.charAt(i));
          //  System.out.println("ans"+ Integer.valueOf(String.valueOf(next.charAt(i))) );
            num += (long)Math.pow(2, len-k) * Integer.valueOf(String.valueOf(next.charAt(i++)) );
            k++;
            //System.out.println(num);
        }
        //System.out.println("res"+num);
         i = 1;
         int ans = 0;
         long val = 2;
         while(val < num){
            val = (long)Math.pow(2, i);
            if(num % val == 0 ) ans = i;
            i++;
         }
        return ans;
    }
}