package Competition.CodeVita9.MockVita9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CollisionCourse {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); 
        int[][] arr = new int[t][3];
        int i=0;
        int cars = t;
        while (cars>0) {
            String[] str = br.readLine().split("\\s+");
            arr[i][0] =  Integer.parseInt(str[0]);
            arr[i][1] =  Integer.parseInt(str[1]);
            arr[i][2] =  Integer.parseInt(str[2]);
            i++;
            --cars;
        }
        cars = 0;
        HashMap<Double, Integer> sameTimeCountMap = new HashMap<>();
        while (cars<t) {
            
           double distance = Math.sqrt(arr[cars][0]*arr[cars][0]+arr[cars][1]*arr[cars][1]);
           double time = distance/arr[cars][2];
           if (sameTimeCountMap.containsKey(time)) {
              sameTimeCountMap.put(time, sameTimeCountMap.get(time)+1);
           }
           else{
               sameTimeCountMap.put(time, 1);
           }
            cars++;
        }
        Double collisions = 0d;
        for(Map.Entry<Double, Integer> entry : sameTimeCountMap.entrySet()){
            if(entry.getValue()==2){
                collisions+=1;
            }
            else if(entry.getValue()>2){
                int n = entry.getValue();
                collisions += n*(n-1)/2;
            }
        }
        System.out.println(collisions.longValue());
    }
}