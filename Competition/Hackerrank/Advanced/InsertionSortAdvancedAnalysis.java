import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InsertionSortAdvancedAnalysis {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine().trim()); t>0; t--){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] str = br.readLine().split("\\s+");
            for (int i = 0; i < n ; i++){
            arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(countInsertionSortMoves(arr,n));
        }
    }

    private static int countInsertionSortMoves(int[] arr, int n) {
               if (n==1) return 0;
        if (n==2) {
            if (arr[0]<arr[1]) {
                return 0;
            }
            else return 1;
        }
        int[] copy = Arrays.copyOf(arr, n);
        Arrays.sort(copy);
        for (int i = 0; i < n; i++) {
            if (arr[i]==copy[i]) {
                if (i==n-1) {
                    return 0;
                }
                continue;
            } else {
                break;
            }
           
        }
        int moves = 0;
        boolean flag = false;
        
       
        for (int i = 1; i < n; i++) {
            int j = i-1;
            int v = arr[i];
            while (j>=0 && v<arr[j]) {
                arr[j+1] = arr[j];
                moves++;
                j--;
            }
            arr[j+1] = v;
            System.out.println(arr[j+1]);
            System.out.println(Arrays.toString(arr));
        }
            System.out.println(Arrays.toString(arr));
        
        return moves;
    }
}