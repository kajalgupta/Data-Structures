package GeeksForGeeks.HardProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class SumOfSubsetRecursive {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("\\s+");
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(str[i]));
            }
            String result = canPartition(list)?"YES":"NO";
            System.out.println(result);
        }
    }

    private static boolean canPartition(ArrayList<Integer>list) {
        int total = 0;
        for (Integer integer : list) {
            total += integer;
        }
        if (total % 2!= 0) {
            return false;
        }
        return canPartition(list,0,0,total);
    }

    private static boolean canPartition(ArrayList<Integer> nums, int index, int sum, int total) {
        if (sum*2==total) {
            return true;
        }
        if (index>=nums.size() || sum>total/2) {
            return false;
        }
        return canPartition(nums, index+1, sum, total) || canPartition(nums, index+1, sum + nums.get(index), total);

    }

}