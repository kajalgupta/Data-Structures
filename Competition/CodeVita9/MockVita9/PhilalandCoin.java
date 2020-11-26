package Competition.CodeVita9.MockVita9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PhilalandCoin {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
             int n = Integer.parseInt(br.readLine()); 
             System.out.println(coinsRequired(n));
        }
        
    }

    private static int coinsRequired(int n) {
        if (n==1) {
            return 1;
        }
        if (n==2) {
            return 2;
        }
        if (n==3) {
            return 2;
        }
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(2);
        int maxSum = 1+2;
        //int maxKey = 2;
        for (int i = 4; i <= n; ) {
           // if (i>maxSum) {
                //for (int j = result.size()-1; j>=0; j--) {
                    int addKey = i-result.get(0);
                   // if (!result.contains(addKey)) {
                        result.add(addKey);
                        maxSum += addKey;
                        //break;
                  //  }
                //}
               i = maxSum+1;
           // }
            // if (i<maxSum) {
            //     if (result.contains(maxSum-i)) {
            //         //not needed;
            //     }
            // }

        }
        return result.size();
    }
    
}