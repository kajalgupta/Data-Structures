import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class JourneyScheduling {

    static int N = 100001;
    @SuppressWarnings("unchecked")
    static Vector<Integer>[] adj = new Vector[N];
    static int[] lvl = new int[N], dist1 = new int[N], dist2 = new int[N];
    static boolean[] visited = new boolean[N];
    static long diameterDistance;

    static void AddEdge(int u, int v) {

        // Edge from U to V
        adj[u].add(v);

        // Edge from V to U
        adj[v].add(u);
    }

    static int end1, end2, maxi;

    // DFS to find the first
    // End Node of diameter
    static void findFirstEnd(int u, int p) {

        // Calculating level of nodes
        lvl[u] = 1 + lvl[p];
        if (lvl[u] > maxi) {
            maxi = lvl[u];
            end1 = u;
        }
    System.out.println("u is"+u);
        for (int i = 0; i < adj[u].size(); i++) {

            // Go in opposite
            // direction of parent
            if (adj[u].elementAt(i) != p && !visited[adj[u].elementAt(i)]) {
                visited[adj[u].elementAt(i)] = true;
                findFirstEnd(adj[u].elementAt(i), u);
            }
        }
    }

    // Function to clear the levels
    // of the nodes
    static void clear(int n) {

        // Set all value of lvl[]
        // to 0 for next dfs
        for (int i = 0; i <= n; i++) {
            lvl[i] = 0;
        }

        // Set maximum with 0
        maxi = 0;
        dist1[0] = dist2[0] = -1;
    }

    // DFS will calculate second
    // end of the diameter
    static void findSecondEnd(int u, int p) {

        // Calculating level of nodes
        lvl[u] = 1 + lvl[p];
        if (lvl[u] > maxi) {
            maxi = lvl[u];

            // Store the node with
            // maximum depth from end1
            end2 = u;
        }

        for (int i = 0; i < adj[u].size(); i++) {

            // Go in opposite
            // direction of parent
            if (adj[u].elementAt(i) != p) {
                findSecondEnd(adj[u].elementAt(i), u);
            }
        }
    }

    // Function to find the distance
    // of the farthest distant node
    static void findDistancefromFirst(int u, int p) {

        // Storing distance from
        // end1 to node u
        dist1[u] = 1 + dist1[p];
        if (dist1[u] > diameterDistance) {
            diameterDistance = dist1[u];
        }
        for (int i = 0; i < adj[u].size(); i++) {
            if (adj[u].elementAt(i) != p) {
                findDistancefromFirst(adj[u].elementAt(i), u);
            }
        }
    }

    // Function to find the distance
    // of nodes from second end of diameter
    static void findDistancefromSecond(int u, int p) {

        // Storing distance from end2 to node u
        dist2[u] = 1 + dist2[p];
        for (int i = 0; i < adj[u].size(); i++) {
            if (adj[u].elementAt(i) != p) {
                findDistancefromSecond(adj[u].elementAt(i), u);
            }
        }
    }

    static void findNodes(int n) {
        // Find the one end of
        // the diameter of tree
        findFirstEnd(1, 0);
        clear(n);
            System.out.println("hryeeyeyyy--------------");
        // Find the other end
        // of the diameter of tree
        findSecondEnd(end1, 0);

        // Find the distance
        // to each node from end1
        findDistancefromFirst(end1, 0);

        // Find the distance to
        // each node from end2
        findDistancefromSecond(end2, 0);

        // for (int i = 1; i <= n; i++) {
        // int x = dist1[i];
        // int y = dist2[i];

        // // Comparing distance between
        // // the two ends of diameter
        // if (x >= y) {
        // System.out.print(end1 + " ");
        // } else {
        // System.out.print(end2 + " ");
        // }
        // }
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("E:/DataStructures/Competition/Hackerrank/Hard/tests.txt"));

            String[] str = br.readLine().split("\\s+");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            for (int i = 0; i < n + 1; i++) {
                adj[i] = new Vector<>();
            }

            for (int i = 1; i <= n - 1; i++) {
                String[] str2 = br.readLine().split("\\s+");
                int x = Integer.parseInt(str2[0]);
                int y = Integer.parseInt(str2[1]);
                // Joining Edge between two
                // nodes of the tree
                AddEdge(x, y);
            }
            findNodes(n);
            for (int i = 1; i <= m; i++) {
                String[] str2 = br.readLine().split("\\s+");
                int V = Integer.parseInt(str2[0]);
                long K = Long.parseLong(str2[1]);
                int x = dist1[V];
                int y = dist2[V];
                int total = (x > y) ? x : y;
                // System.out.println("for vertex"+V+"total is"+total+" diameter distance is
                // "+diameterDistance);
                try (BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter("E:/DataStructures/Competition/Hackerrank/Hard/result.txt", true))) {
                    bufferedWriter.write(Long.toString(total + (K - 1) * diameterDistance));
                    bufferedWriter.write("\n");
                } catch (FileNotFoundException e) {
                    System.err.println("File not !!!!found");
                } catch (IOException e) {
                    System.err.println("Unable to read the file.");
                }
                System.out.println( Long.toString(total + (K - 1) * diameterDistance));
                // V---> max distance from end + (k-1)*maxdistance;
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found for reading");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }

    }

}
