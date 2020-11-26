package Competition.BattleOfVars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LiftRequests {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String[] str = br.readLine().split("\\s+");
            int n = Integer.parseInt(str[0]); 
            int q = Integer.parseInt(str[1]);
            int[] sourceFloor = new int[q];
            int[] destinationFloor = new int[q];
            int i=0;
            while (q-->0) {
                String[] str2 = br.readLine().split("\\s+");
                int f = Integer.parseInt(str2[0]); 
                int d = Integer.parseInt(str2[1]);
                sourceFloor[i] = f;
                destinationFloor[i] = d;
                i++;
            }
            long floorsTravelled = sourceFloor[0];
            floorsTravelled += Math.abs(destinationFloor[0]-sourceFloor[0]); 
          for (int j = 0; j <= destinationFloor.length-2; j++) {
              floorsTravelled += Math.abs(destinationFloor[j] - sourceFloor[j+1]);
              floorsTravelled += Math.abs(sourceFloor[j+1] - destinationFloor[j+1]);

          }
            System.out.println(floorsTravelled);
            
        }
    }
}