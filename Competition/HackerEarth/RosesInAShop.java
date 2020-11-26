package Competition.HackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RosesInAShop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        String[] str = br.readLine().split("\\s+");
        List<Integer> list = new ArrayList<Integer>();
        int[] arr = new int[n]; 
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int count = 1;
        boolean flag = false;
        int store = 0;
        for (int i = 1; i < n; i++) {
            if(arr[i]==arr[i-1]){
                list.add(count);
                count =1;
            }
            
            if (arr[i]>arr[i-1]) {
                count++;
            }
            else{
                if (!flag && arr[i-1]<arr[i+1]) {
                    store = i;
                    System.out.println("storing index"+store);
                    flag = true;
                    continue;
                }
                else{
                    list.add(count);
                    //count=i-store;
                    System.out.println("already visited length"+count);
                    count = 2;
                   // System.out.println("already visited length"+count);
                    //int value=i;
                   // store = i;
                    i=store;
                    System.out.println("i is"+i);
                    flag=false;
                }
            }
        }
        if (flag) {
            list.add(count);
        }
        System.out.println("list is"+list);
        if (list.size()>1) {
            Collections.sort(list);
            System.out.println(list.get(list.size()-1));
        }
        else System.out.println(count);
    }
    
}
/*abstract
50
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 13 17 18 19 20 21 22 23 24 22 26 27 28 29 30 31 32 33 34 35 36 37 38 39 37 41 42 43 44 45 46 47 48 49 50
*/