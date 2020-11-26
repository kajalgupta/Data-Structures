import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BomberManGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
       
        int r = Integer.parseInt(str[0]);
        int c = Integer.parseInt(str[1]);
        int n = Integer.parseInt(str[2]);
      
        char[][] input = new char[r+2][c+2];
        //int[][] input = new int[r+2][c+2];
        
        for(int i = 1; i <= r; i++) {
            String row  = br.readLine();
            for (int j = 1; j <= c; j++) {
                input[i][j] = row.charAt(j-1);
            }
        }
        System.out.println(Arrays.deepToString(input)+"yay");

   if (n==1) {
       for (int i = 1; i <= r; i++) {
       for (int j = 1; j <= c; j++) 
        System.out.print(input[i][j]);
        System.out.println();
       }
       return;
    //System.out.println(Arrays.deepToString(matrix));
       
   }
   else if(n%2==0){
       for (int i = 1; i <= r; i++) {
       for (int j = 1; j <= c; j++) 
        System.out.print('O');
        System.out.println();
       }
       return;
   }
         int[][] A = new int[r+2][c+2];
       for (int i = 1; i <= r; i++) {
           for (int j = 1; j <= c; j++) {
               System.out.println(input[i][j]);
               if (input[i][j] == 'O') {
                   //A[i-1][j]=A[i][j-1]=A[i][j+1]=A[i+1][j]=A[i][j]=1;
                   A[i][j] = A[i + 1][j] = A[i][j + 1] = A[i - 1][j] = A[i][j - 1] = 1;
                    System.out.println("hey"+i+j);
               }
           }
       }
       System.out.println(Arrays.deepToString(A)+"AAA");
       if (n%4==3) {
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (A[i][j]==1) {
                    System.out.print('.');
                }
                else{
                    System.out.print('O');
                }
                
            }
            //System.out.println("heyyy");
            System.out.println();
        }
        return;
   }
       int[][] B = new int[r+2][c+2];
       for (int i = 1; i <= r; i++) {
        for (int j = 1; j <= c; j++) {
            if (A[i][j]=='O') {
                B[i-1][j]=B[i][j-1]=B[i][j+1]=B[i+1][j]=B[i][j]='1';

            }
        }
    }
    
   if (n%4==1) {
       System.out.println("!!!!!!");
    for (int i = 1; i <= r; i++) {
        for (int j = 1; j <= c; j++) {
            if (B[i][j]==1) {
                System.out.print('.');
            }
            else{
                System.out.print('O');
            }
            
        }
        System.out.println();
    }
    return;
       
   }
   

   }
    
}
