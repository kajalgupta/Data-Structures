package Competition.Hackerrank.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class AcmIcpcTeam {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
         //int[][] arr = new int[n][m];
         String[] arr = new String[n];
         for (int i = 0; i < n; i++) {
             String str2 = br.readLine();
                   arr[i] =  str2;
         }
         int[] result = acmTeam(arr);
        // System.out.println(String.valueOf(result));
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    private static int[] acmTeam(String[] arr) {
        int noOfTeams = arr.length*(arr.length-1)/2;
        Integer[] freq = new Integer[noOfTeams];
        int z = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int count = 0;
                for (int k= 0; k < arr[0].length(); k++) {
                    if (arr[i].charAt(k)=='1' || arr[j].charAt(k)=='1') {
                        count++;
                    }
                }
                freq[z] = count;
                z++;
            }
        }
        Arrays.sort(freq);
        int[] result = new int[2];
       // System.out.println(freq[noOfTeams-1]);
      //  System.out.println(Collections.frequency(Arrays.asList(freq), freq[noOfTeams-1]));
      System.out.println("--------------");
      for (int i = 0; i < freq.length; i++) {
          System.out.println(freq[i]);
      }
       result[0] =  freq[noOfTeams-1];
       result[1] = Collections.frequency(Arrays.asList(freq), result[0]);
       System.out.println("ffs"+result[1]);
      return result;
    }
}