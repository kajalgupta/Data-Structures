import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Encryption {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(encrypt(str));
    }

    private static String encrypt(String str) {
        String noSpaceStr = str.replaceAll("\\s", "");
        int l = noSpaceStr.length();
        int row = (int)Math.sqrt(l);
        int column = (row*row==l)?row:row+1;
        System.out.println(column+"row"+row);
        if (row*column < l) {
            int k = Math.max(row, column);
            row = k;
            column = k;
        }
        int len = str.length();
        StringBuilder result = new StringBuilder("");
        int k =0;
        System.out.println(len);
        for (int i = 0; i<column; i++) {
             k = i;
            result.append(str.charAt(k));
            while (k+column < len) {
                //
                result.append(str.charAt(k+column));
                k = k+column;
                System.out.println("k is"+k);
                
            }
            result.append(" ");
            System.out.println(result);
            if (k == len) {
               System.out.println(result+"--------");
                break;
            }
        }
        /*
        char[][] arr = new char[row][column];
        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column && k<l; j++) {
                arr[i][j] = noSpaceStr.charAt(k++);
            }
        }
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                System.out.println(arr[j][i]);
                if (Character.isWhitespace(arr[j][i]) ||arr[j][i] == ' ') {
                    System.out.println("-----");
                    break;
                }
                result.append(arr[j][i]);
            }
            result.append(" ");
           // System.out.println(result);
           // System.out.print(" ");
        }
        */
        return result.toString();
    }
    
}