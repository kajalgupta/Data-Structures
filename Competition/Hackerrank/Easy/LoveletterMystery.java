import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class LoveletterMystery {
     public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for( int t = Integer.parseInt(br.readLine()); t>0; t-- ) {
        String str = br.readLine();
        int length = str.length();
        int k = ( length % 2 == 0 ) ? 0 : 1 ;
        String start = str.substring( 0, length/2 );
        String end = new StringBuilder( str.substring( length/2 + k ) ).reverse().toString() ;
        int operations = 0;
        for (int i = 0; i < start.length(); i++) {
            operations += Math.abs( start.charAt(i) - end.charAt(i) );
        }
        System.out.println(operations);
    }
    }
}
