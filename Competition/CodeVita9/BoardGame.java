package Competition.CodeVita9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BoardGame
 */
public class BoardGame {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            String str[] = br.readLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        int i = 0;
        int s = 0;
        int j = 0;
        int k = 0;
        while (i != n && j != n) {
            if (i==n-1 && j!=n-1) {
                k = arr[i][j + 1];
                j = j + 1;
                System.out.println("1");
            }
            else if (j==n-1 && i!= n-1) {
                k = arr[i + 1][j];
                i = i + 1; 
                System.out.println("2");
            }
            else if (i!=n-1 && j!=n-1 && arr[i][j + 1] < arr[i + 1][j]) {
                k = arr[i][j + 1];
                j = j + 1;
                System.out.println("3");
            } 
            else if (i==n-1 && j==n-1) {
               // s = (int) Math.floor(s / 2) + k;
                break;
            }
            else {
                k = arr[i + 1][j];
                i = i + 1;
                System.out.println("4");
            }
            System.out.println("k is"+k);
            s = (int) Math.floor(s / 2) + k;
            System.out.println("s is"+s);
        }
        System.out.println(s);

    }
}


/*abstract*



4
0 3 9 6
1 4 4 5
8 2 5 4
1 8 5 9

Output

12


5
0 82 2 6 7
4 3 1 5 21
6 4 20 2 8
6 6 64 1 8
1 65 1 6 4

*/