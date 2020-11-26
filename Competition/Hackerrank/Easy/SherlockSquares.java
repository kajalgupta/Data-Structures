import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SherlockSquares {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String[] str = br.readLine().split("\\s+");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int i = (int)Math.ceil(Math.sqrt(a));
            int count = 0;
            while (i*i <=b) {
                count++;
                i++;
            }
            System.out.println(count);
        }
    }
    
}