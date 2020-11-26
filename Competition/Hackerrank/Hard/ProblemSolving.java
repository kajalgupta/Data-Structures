//package Competition.Hackerrank.Hard;

//import.java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

//import java.io.IOExcepti"on;

public class ProblemSolving {
    static int[] match = new int[300];
    static int n;
    static int k;

    static int[] arr = new int[300];
    static boolean[] visit = new boolean[300];

    public static void main(String[] args) throws NumberFormatException, IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("E:/DataStructures/Competition/Hackerrank/Hard/test.txt"));
            for (int t = Integer.parseInt(br.readLine().trim()); t > 0; t--) {
                String[] str = br.readLine().split("\\s+");
                n = Integer.parseInt(str[0]);
                k = Integer.parseInt(str[1]);
                String[] str2 = br.readLine().split("\\s+");

                // List<Integer> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(str2[i]);

                }
                // Collections.sort(list);
                // System.out.println("result" + problemSolving(n, k, arr));
                int result = n;

                Arrays.fill(match, -1);
                for (int i = 0; i < n - 1; i++) {
                    Arrays.fill(visit, false);
                    if (dfs(i)) {
                        result -= 1;
                    }
                }
                System.out.println("Finallyyyyyy" + result);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not !!!!found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }

    }

    private static boolean dfs(int source) {
        if (visit[source]) {
            return false;
        }
        visit[source] = true;
        for (int i = source + 1; i < n; i++) {
            if (Math.abs(arr[i] - arr[source]) >= k) {
                if (match[i] == -1 || dfs(match[i])) {
                    match[i] = source;
                    return true;
                }
            }
        }

        return false;
    }

    // CODE FOR FILE
    // IO---------------------------------------------------------------------------------------------------------
   
   
   
   
    private static int problemSolving(int n, int k, int[] arr) {
        // Arrays.sort(arr);
        boolean[] flag = new boolean[n];

        boolean first = false;
        int day = 0;
        int count = 0;
        Stack<Integer> problems = new Stack<>();
        if (n == 1) {
            count = 1;
            day = 1;
        }
        while (count < n) {
            System.out.println(flag[0]);
            System.out.println(flag[1]);
            System.out.println(flag[2]);
            for (int i = 0; i < arr.length; i++) {
                if (!flag[i]) {
                    // if (arr[i] + k <= list.get(list.size() - 1) && !first) {
                    if (!first) {
                        first = true;
                        flag[i] = true;
                        problems.push(arr[i]);
                        if (count == n) {
                            break;
                        }
                        System.out.println(arr[i]);
                        continue;
                    }
                    if (Math.abs(problems.peek() - arr[i]) >= k) {
                        problems.push(arr[i]);
                        System.out.println("elements" + arr[i]);
                        flag[i] = true;
                    }
                    // System.out.println("hey");
                }
            }
            day++;
            count += problems.size();
            System.out.println("stack size" + problems.size() + " day " + day);

            problems.clear();
            // System.out.println("stack peek"+problems.peek());
            System.out.println(count + "counttt");
            first = false;
            // z++;
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("E:/DataStructures/Competition/Hackerrank/Hard/result.txt", true))) {
            bufferedWriter.write(Integer.toString(day));
            bufferedWriter.write("\n");
        } catch (FileNotFoundException e) {
            System.err.println("File not !!!!found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        return day;
    }

}
