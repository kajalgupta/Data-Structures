package LeetCodeHard;

import java.util.ArrayList;
import java.util.List;

public class SkyLineProblem {
   static public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        temp.add(buildings[0][0]);
        temp.add(buildings[0][2]);
        list.add(temp);
        System.out.println("1st sublist is "+list);
        int i=1;
        for( i=1; i<buildings.length; i++){
            temp.clear();
            if (buildings[i][0] < buildings[i-1][1]) {
                temp.add(buildings[i][0]);
                temp.add(buildings[i][2]);  
                list.add(temp);
                System.out.println("list for i"+i+" is "+list);
                temp.clear();             
            }
            if (buildings[i][0]>buildings[i-1][1]) {
                temp.add(buildings[i-1][1]);
                temp.add(0);
                list.add(temp);
                temp.clear();
                temp.add(buildings[i][0]);
                temp.add(buildings[i][2]);
                list.add(temp);
                temp.clear();
            }
        }
        temp.add(buildings[buildings.length-1][1]);
        temp.add(0);
        list.add(temp);
        return list;
    }

    public static void main(String[] args) {
        int[][] arr = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        System.out.println(getSkyline(arr));
    }

}