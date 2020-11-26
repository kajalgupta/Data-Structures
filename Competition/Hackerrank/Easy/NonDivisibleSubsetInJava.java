import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * NonDivisibleSubsetInJava
 */
public class NonDivisibleSubsetInJava {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        String[] str2 = br.readLine().split("\\s+");
        int[] input = new int[n];
      for (int i = 0; i < n; i++){
      input[i] = Integer.parseInt(str2[i]);
      }
      int[] arr = new int[k];
      for (int i = 0; i < n; i++) {
          arr[input[i]%k]++;
      }
      boolean[] flag = new boolean[k];
      System.out.println(Arrays.toString(arr)+"[[[[[");
      int countElements = 0;
      for (int i = 1;  i < k&&!flag[i]; i++) {
          int index = k-i;
          flag[i] = true;
          flag[index] = true;
          countElements+=(arr[i]>arr[index]?arr[i]:arr[index]);
      }
      countElements+=(arr[0]!=0)?1:0;
     countElements-= ((k%2==0)&&arr[k/2]>1)?arr[k/2]-1:0;
     System.out.println(countElements);
    }
}