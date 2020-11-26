package Competition.Hackerrank.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
//import java.util.stream.Collector;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;

public class FullCountingSort {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<List<String>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("\\s+");
            ArrayList<String> li = new ArrayList<>();
            li.add(str[0]);
            li.add(str[1]);
            arr.add(li);
        }
        long[] check = new long[1000000000];
        System.out.println(check.toString());
        /*
         * IntStream.range(0, n).forEach(i -> { try { arr.add(
         * Stream.of(br.readLine().replaceAll("\\s+$", " ").split(" "))
         * .collect(toList()) ); } catch (IOException e) { // 
         * throw new RuntimeException(e); } });
         */
        countSort(arr);
        br.close();

    }

    private static void countSort(List<List<String>> arr) {
       // System.out.println(arr.toString() + "-----");
        StringBuilder[] result = new StringBuilder[100];
        for (int i = 0; i < result.length; i++) {
            result[i] = new StringBuilder("");
        }
        for (int i = 0; i < arr.size() / 2; i++) {
            // System.out.println(Integer.parseInt(arr.get(i).get(0)));
            result[Integer.parseInt(arr.get(i).get(0))].append("-");
            result[Integer.parseInt(arr.get(i).get(0))].append(" ");
        }
        for (int i = arr.size() / 2; i < arr.size(); i++) {
            result[Integer.parseInt(arr.get(i).get(0))].append(arr.get(i).get(1));
            result[Integer.parseInt(arr.get(i).get(0))].append(" ");

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }
        System.out.println(sb);
      //  Arrays.asList(result).forEach(System.out::print);
    }

}