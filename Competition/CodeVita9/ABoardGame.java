package Competition.CodeVita9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ABoardGame {
    static List<Integer> dp = new ArrayList<>();
    static HashMap<List<Integer>, Integer> multiList = new HashMap<>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            String[] str = br.readLine().split("\\s+");
            for (int j = 0; j < str.length; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        //int k = 
        path(0,0,0, arr, n);
        Collections.sort(dp);
        System.out.println(dp.get(0));
    }

    private static void path(int i, int j, int s, int[][] arr, int n) {
        int k = s;
        s = (int)Math.floor(s/2)+arr[i][j];
        List<Integer> li = new ArrayList<>();
        li.add(k);
        li.add(i);
        li.add(j);
        multiList.put(li, s);
            
        
        if (i==n-1 && j==n-1) {
            dp.add(s);
           // return 0;
        }
        if (j<n-1) {
          //int sumr = 
          li.add(s);
          li.add(i);
          li.add(j+1);
          if (!multiList.containsKey(li))
            //int q= multiList.get(li);
                path(i, j+1, s, arr, n); 
                else System.out.println("new s is "+s +" with i "+i+"& j"+(j+1));
            li.clear();
        }
        if (i<n-1) {
           // int sumd = 
            li.add(s);
          li.add(i+1);
          li.add(j);
          if (!multiList.containsKey(li))
           path(i+1, j, s, arr, n);
           else System.out.println("new s is "+s +" with i "+(i+1)+"& j"+j);
           li.clear();
        }


       // return 0;
    }
    
}