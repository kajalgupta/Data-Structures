
import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.InputStreamReader;

public class AbsolutePermutation{

    public static void main(String[] args)throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String[] str = br.readLine().split("\\s+");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            int[] arr = new int[n+1];
            for (int i = 0; i <= n ; i++){
            arr[i] = i;
            }
            System.out.println("!!!!!!!"+Arrays.toString(permutation(arr, n, k)).replace('[',' ').replace(']',' ').replace(',',' ').replaceAll(" +"," ").trim().substring(1).trim());
    
        }
    }

    private static int[] permutation(int[] arr, int n, int k) {
        if(k==0){
            return arr;
        }
        if (n%(2*k)!=0) {
            int[] arr2 = {0,-1};
                    System.out.println(Arrays.toString(arr2));
                    return arr2;
        }
        else{
            
            for (int i = 1; i < n+1; i++) {
                int diff = Math.abs(arr[i] -i);
                System.out.println("diff"+diff);
            if (diff!=k) {
                arr[i] = i+k;
                arr[i+k] = i;
                System.out.println(arr[i]);
                System.out.println(arr[i+k]);
                
            }
            }
        }
        return arr;
    }
}