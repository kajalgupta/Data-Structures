import java.util.List;

public class MaxConsecutive1s {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(findNumbers(arr));
    }

    private static int findNumbers(int[] nums){
        int evenCount = 0;
        for (int i : nums) {
            int digits = 0;
            while (i>0) {
                i=i/10;
                digits++;
            }
            if(digits % 2 == 0) evenCount++;
        }
        return evenCount;
    }
    
}