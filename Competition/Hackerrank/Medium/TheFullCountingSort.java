package Competition.Hackerrank.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheFullCountingSort {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        StringBuilder[] result = new StringBuilder[100];
        for (int i = 0; i < 100; i++) {
            result[i] = new StringBuilder("");
        }
        for (int i = 0; i < n/2; i++) {
            String[] str = br.readLine().split("\\s+");
            int k = Integer.parseInt(str[0]);
            result[k].append("-"+" ");
        }
        for (int i = 0; i < n/2; i++) {
            
            String[] str = br.readLine().split("\\s+");
            int k = Integer.parseInt(str[0]);
            result[k].append(str[1]+" ");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }
        System.out.println(sb);
    }
    
}