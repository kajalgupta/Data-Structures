import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gold {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] city = new String[n];
        for (int i = 0; i < city.length; i++) {
            city[i] =  br.readLine();
        }
        int m = Integer.parseInt(br.readLine());
        int[] x = new int[m];
        for (int i = 0; i < m; i++) {
            x[i] =  Integer.parseInt(br.readLine());
        }
        int r = Integer.parseInt(br.readLine());
        int[] y = new int[r];
        for (int i = 0; i < r; i++) {
            y[i] =  Integer.parseInt(br.readLine());
        }
        int q = Integer.parseInt(br.readLine());
        String[] queries = new String[q];
        for (int i = 0; i < queries.length; i++) {
            queries[i] = br.readLine();
        }
        String[] result = new String[q];
        for (int i = 0; i < result.length; i++) {
            
        }

    }
}