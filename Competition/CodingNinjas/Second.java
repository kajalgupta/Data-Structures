package CodingNinjas;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Second {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            for (int i = 1; i < n+1; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            int[] sum = new int[n+1];
            sum[0] = Integer.MIN_VALUE;
            sum[1] = arr[1];
            for (int i = 2; i < sum.length; i++) {
                sum[i] = arr[1]+arr[i];
            }
           // System.out.println("+++++---"+Arrays.toString(arr));
            //System.out.println("+++++"+Arrays.toString(sum));
            //boolean[] flag = new boolean[n+1];
            
            //System.out.println(arr[2]);
            for (int p = 2; p*p<=n; p++) {
               // if(flag[p]==false){
                    for (int i = p*2; i <=n ; i+=p) {
                        //flag[i] = true;
                        sum[i]+=arr[p];
                    }
              //  }
                    
            }
            for (int i = 1; i < sum.length; i++) {
                System.out.print(sum[i]+" ");
            }
            //System.out.println(Arrays.toString(sum));

        }
    }
}