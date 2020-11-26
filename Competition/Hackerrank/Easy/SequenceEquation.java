import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SequenceEquation {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("\\s+");
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++){
        arr[i] = Integer.parseInt(str[i]);
        }
        int index = 0;
        for (int x = 1; x <= n; x++) {
            for (int i = 0; i < n; i++) {
                if (arr[i]==x) {
                    index = i+1;
                    //System.out.println("---"+index);
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                if (arr[i]==index) {
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
    
}