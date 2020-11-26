package GeeksForGeeks.HardProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;


public class SumOfSubsetDynamic {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("\\s+");
            //List<Integer> list = new ArrayList<>();
            int[] nums = new int[n];
            for (int i = 0; i < str.length; i++) {
                //list.add(Integer.parseInt(str[i]));
                nums[i] = Integer.parseInt(str[i]);
            }
            String result = canPartition(nums) ? "YES" : "NO";
            System.out.println(result);
               
        
        }
    }

    private static boolean canPartition(int[] list) {
        int total = 0;
        for (Integer integer : list) {
            total += integer;
        }
        if (total%2!=0) {
            return false;
        }
        return canPartition(list,0,0,total, new HashMap<String,Boolean>());
    }

    private static boolean canPartition(int[] list, int index, int sum, int total, HashMap<String,Boolean>state) {
        String current = index+""+sum;
        if (state.containsKey(current)) {
            return state.get(current);
        }
        if (sum*2 == total) {
            return true;
        }
        if (index>=list.length || sum>total/2) {
            return false;
        }
        
        boolean foundPartition = canPartition(list, index+1, sum, total, state) || canPartition(list, index+1, sum+list[index], total, state);
        state.put(current, foundPartition);
        return foundPartition;
    }
    

}