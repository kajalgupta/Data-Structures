package Competition.Hackerrank.Easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BeautifulTriplets {

    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {
        int n = arr.length;
        int count = 0;
    List<Integer> list = new ArrayList();
        for(int i=0; i<n; i++){
            list.add(arr[i]);
        }
        for (int i = 0; i <n-2; i++) {
            if (list.contains(arr[i]+d)) {
                if (list.contains(arr[i]+d+d)) {
                    count++;
                }
            }
        }
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

