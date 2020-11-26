import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class EmasSuperComputer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int r = Integer.parseInt(str[0]);
        int c = Integer.parseInt(str[1]);
        char[][] matrix = new char[r + 2][c + 2];
        // Arrays.fill(matrix,'O');
        for (int i = 0; i < r+2; i++) {
            for (int j = 0; j < c+2; j++) {
                matrix[i][j] = '$';
            }
        }
        for (int i = 1; i <= r; i++) {
            String ip = br.readLine();
            for (int j = 1; j <= c; j++) {
                matrix[i][j] = ip.charAt(j - 1);
            }
        }

        System.out.println(emas(matrix, r, c));
    }

    private static int emas(char[][] matrix, int row, int c) {
        //System.out.println(Arrays.deepToString(matrix));
        int result = 0; 
        // FIRST PLUS
        for (int i = 2; i <= row; i++) {
            for (int j = 2; j <= c; j++) {
                // TRACK LENGTH OF PLUS
                int r = 0;
                while ( matrix[i - r][j] == 'G' && matrix[i + r][j] == 'G'
                        && matrix[i][j - r] == 'G' && matrix[i][j + r] == 'G') {
                    //TO AVOID OVERLAP
                             matrix[i - r][j] = matrix[i + r][j] = matrix[i][j - r] = matrix[i][j + r] = 'g';
               System.out.println("first matrix r is"+r+"i is"+i+"j is"+j);
                for (int i1 = 0; i1 < row+2; i1++) {
                for (int j1= 0; j1 < c+2; j1++) 
                 System.out.print(matrix[i1][j1]);
                 System.out.println();
                }
                for (int I = 2; I <= row; I++) {
                    for (int J = 2; J <= c; J++) {
                        int R = 0;
                        while ( matrix[I - R][J] == 'G' && matrix[I + R][J] == 'G'
                        && matrix[I][J - R] == 'G' && matrix[I][J + R] == 'G') {
                                result = Math.max(result, (4*r+1)*(4*R+1));
                            //matrix[I][J] = matrix[I - R][J] = matrix[I + R][J] = matrix[I][J-R] = matrix[I][J + R] = 'g';
                                R += 1;
                        }
                        //System.out.println("result is "+result+" i is "+I+" j is "+J+" R is "+R);  
                    }
                }
                r+=1;
            }
            r = 0;
            while ( matrix[i - r][j] == 'g' && matrix[i + r][j] == 'g'
            && matrix[i][j - r] == 'g' && matrix[i][j + r] == 'g') {
        
                matrix[i - r][j] = matrix[i + r][j] = matrix[i][j - r] = matrix[i][j + r] = 'G';
                r+=1;
            }

            }
        }

        return result;
    }
}