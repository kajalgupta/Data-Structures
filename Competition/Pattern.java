import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pattern(n);
    }

    private static void pattern(int n) {
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[0][i] = '#';
            matrix[n-1][i] = '#';
        }
        for (int i = 1; i < n-1; i++) {
            matrix[i][0] = '*';
            matrix[i][n-1] = '*';
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    
}