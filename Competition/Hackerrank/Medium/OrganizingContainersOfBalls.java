import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OrganizingContainersOfBalls {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //int t = Integer.parseInt(br.readLine());
            for(int t = Integer.parseInt(br.readLine()); t>0; t--){
                int n = Integer.parseInt(br.readLine());
               // int[][] matrix = new int[n][n];
                int[] capacity = new int[n];
                int[] balls = new int[n];
                for (int i = 0; i < n; i++) {
                    String[] str = br.readLine().split("\\s+");
                    for (int j = 0; j < str.length; j++) {
                        int k = Integer.parseInt(str[j]);
                        capacity[i] += k;
                        balls[j] += k;
                    }
                }
                Arrays.sort(capacity);
                Arrays.sort(balls);
                boolean flag = true;
                for (int i = 0; i < balls.length; i++) {
                    if (balls[i] != capacity[i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("Possible");
                } else {
                    System.out.println("Impossible");
                }
                             ///  System.out.println(organizingContainers(matrix, n));
            }
    }

   }