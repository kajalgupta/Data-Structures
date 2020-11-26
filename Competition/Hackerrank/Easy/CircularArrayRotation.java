import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CircularArrayRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int n  = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int t = Integer.parseInt(str[2]);
        String[] str2 = br.readLine().split("\\s+");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
        arr[i] = Integer.parseInt(str2[i]);
        }
        int rotations = k%n;
        for(; t>0; t--){
            int index = Integer.parseInt(br.readLine());
            if (index-rotations>=0) {
                System.out.println(arr[index-rotations]);
            } else {
                System.out.println(arr[index-rotations+n]);
            }


        }
    }
    
}