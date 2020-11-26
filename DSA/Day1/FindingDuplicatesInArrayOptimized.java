package DSA.Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindingDuplicatesInArrayOptimized {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(findDuplicateNumber(arr));

    }

    private static int findDuplicateNumber(int[] arr) {
        int tortoise = arr[0];
        int hare = arr[0];
        //Finding Intersection point.
        do {
            tortoise = arr[tortoise];
            hare = arr[arr[hare]];
        } while (hare!=tortoise);

        //Finding entrance to the cycle
        tortoise = arr[0];
        while (tortoise!=hare) {
            tortoise = arr[tortoise];
            hare = arr[hare];
        }

        return tortoise;
    }
    
}