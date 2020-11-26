package GoogleHardProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ParentingPartneringReturns {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            int n = Integer.parseInt(br.readLine());
            //int[] startActivityTime = new int[n];
            List<Integer> startActivityTime = new ArrayList<>();
            List<Integer> endActivityTime = new ArrayList<>();
            //int[] endActivityTime = new int[n];
           
            for (int i = 0; i < n; i++) {
                String[] str = new String[2];
                str = br.readLine().split("\\s+");  
                startActivityTime.add(Integer.parseInt(str[0]));
                endActivityTime.add(Integer.parseInt(str[1]));
                
            }
            // C=0 & J=1
           // StringBuilder output = new StringBuilder("0");
           boolean[] output = new boolean[n];
           //output[0] = false - C
           int[] limit = new int[2];
           //0 - false ; 1- true;
           limit[0] = endActivityTime.get(0);
            for (int i = 1; i < n; i++) {
                if (startActivityTime.get(i)<endActivityTime.get(i-1) && ) {
                    output[i] = !output[i-1];
                    if (output[i]){
                        limit[1] = endActivityTime.get(i);
                    }
                }
                else{
                    output[i] = output[i-1];
                }
            }
        }
    }
}