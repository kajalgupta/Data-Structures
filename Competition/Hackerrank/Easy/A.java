/**
 * A
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class A {

     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        while(n-- > 0){
            String[] arr = br.readLine().split("\\s+");
            sum += Integer.parseInt(arr[0]);
            sum += Integer.parseInt(arr[1]);
            sum += Integer.parseInt(arr[2]);
            
        }
        if(sum == 0)
            System.out.println("YES");
        else
            System.out.println("N0");
    }
}