package Competition.Hackerrank.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CutTheSticks {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        List<Integer> list = new ArrayList<>(); 
        String[] str = br.readLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(str[i]));
        }
        List<Integer> result = new ArrayList<>();
        result = cutTheSticks(list);
        System.out.println(result.toString());
        
    }

    private static List<Integer> cutTheSticks(List<Integer> list) {
        List<Integer> output = new ArrayList<>();
        output.add(list.size());
        
        while (list.size()>1) {
            Collections.sort(list);   
            System.out.println("------------------"+list.toString()+"--------"+"siz is"+list.size());
          
            int k = list.get(0);
            System.out.println("k is"+k);
            list.remove(0);
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i) - k;
            if (value==0) {
                System.out.println("list value--"+list.get(i));
                list.remove(i);
                i=-1;
            }
            else list.set(i, value);
            //System.out.println("element is "+list.get(i));
           }
 if(list.size()!=0)       output.add(list.size());
         
        }
        return output;
    }
    
}