package GeeksForGeeks.HardProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Return2PrimeNumbers {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
            int n = Integer.parseInt(br.readLine());
            boolean[] arr = new boolean[n + 1];
            for (int p = 2; p * p <= n; p++) {
                if (arr[p] == false) {
                    for (int i = p * 2; i <= n; i += p) {
                        arr[i] = true;
                    }
                }

            }
            StringBuilder output = new StringBuilder();
            for (int i = 3; i < n; i++) {
                if (arr[i]==false) {
                    int a = n-i;
                    if(arr[a]==false){
                        output.append(i);
                        output.append(" ");
                        output.append(a);
                        break;
                        
                    }
                }
            }
            System.out.println(output);
        }
    }

}