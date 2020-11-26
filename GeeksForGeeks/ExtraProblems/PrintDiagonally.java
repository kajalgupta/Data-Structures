package GeeksForGeeks.ExtraProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintDiagonally {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("\\s+");
            int l = 0;
            int[][] matrix = new int[n][n];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = Integer.parseInt(str[l++]);
                }
            }
            System.out.println(matrix[n - 1][n - 1]);
            boolean[][] mat = new boolean[n][n];
            StringBuilder output = new StringBuilder("");
           // output.append(matrix[0][0]);
            for (int i = 0; i < mat.length; i++) {

                for (int j = 1; j < mat.length; j++) {
                    int k = i;
                    if (!mat[k][j]) {
                        output.append(" ");
                        output.append(matrix[k][j]);
                        mat[k][j] = true;
                        // j = k
                        int z = j - 1;
                        k++;
                        while (z >= 0 && k < n && !mat[k][z]) {
                            output.append(" ");
                            output.append(matrix[k][z]);
                            mat[k][z] = true;
                            k++;
                            z--;
                        }
                    }
                    // System.out.println(output);
                }
            }
            System.out.println(output);

        }
    }

}