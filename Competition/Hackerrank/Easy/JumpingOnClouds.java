package Competition.Hackerrank.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JumpingOnClouds {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("\\s+");
        int[] arr = new int[n];
            for (int i = 0; i < n ; i++){
            arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(jumpingOnClouds(arr));
        }

        private static int jumpingOnClouds(int[] arr) {
            int jumps = 0;
            for (int i = 0; i < arr.length-1; ) {
                i = (i+2==arr.length||arr[i+2]==1)?i+1:i+2;
                jumps++;
            }
            return jumps;
        }
    }
    
