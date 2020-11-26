import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Queue;

public class RustandMurderer {

    public static void main(String[] args) throws NumberFormatException, IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            BufferedReader br = new BufferedReader(
                new FileReader(new File("E:DataStructures/Competition/Hackerrank/Medium/test2.txt")));

            for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {

                String[] str = br.readLine().split("\\s+");
                int n = Integer.parseInt(str[0]);
                int m = Integer.parseInt(str[1]);

                ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
                for (int i = 0; i < n + 1; i++)
                    adj.add(new ArrayList<Integer>());

                while (m > 0) {
                    String[] str2 = br.readLine().split("\\s+");
                    int x = Integer.parseInt(str2[0]);
                    int y = Integer.parseInt(str2[1]);
                    addEdge(adj, x, y);
                    m--;
                }

                int source = Integer.parseInt(br.readLine());
                Queue<Integer> freeNodesFromSource = new ArrayDeque<>();
                freeNodesFromSource.add(source);
                int[] distance = new int[n + 1];
                // int nextSource = source;
                int count = 1;
                while (count < n) {
                    int x = freeNodesFromSource.remove();
                    for (int i = 1; i <= n; i++) {

                        if (i != source && i != x) {
                            if (distance[i] == 0 && !adj.get(x).contains(i)) {
                                freeNodesFromSource.add(i);
                                distance[i] = distance[x] + 1;
                                count++;
                            }

                        }
                    }

                }
                // System.out.println(
                try (BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter("E:/DataStructures/Competition/Hackerrank/Medium/result.txt", true))) {

                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < distance.length; i++) {
                        if (distance[i] != 0) {
                            sb.append(distance[i]);
                            sb.append(" ");
                        }
                    }
                    bufferedWriter.write(sb.toString());

                    bufferedWriter.write("\n");
                    // bufferedWriter.write("!!!!!!!!!!!!!!!!!!"+t);

                    // System.out.println();

                } catch (FileNotFoundException e) {
                    System.err.println("File not -----found");
                } catch (IOException e) {
                    System.err.println("Unable to write the file.");
                }

            }

            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not !!!!found to  read");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }

    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

}
