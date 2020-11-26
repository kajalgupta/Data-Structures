

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class JourneySchedule {

    static int N = 100001;
    
   
  // static Vector<Integer>[] adj = new Vector[N];
  static List<Integer>[] adj;
  static int[] farDown;
  static int[] farDown2;
  static int[] far;
  static long diameter = -1;

    static void AddEdge(int u, int v) {

        // Edge from U to V
        adj[u].add(v);

        // Edge from V to U
        adj[v].add(u);
    }

    

    // DFS to find the first
    // End Node of diameter
    

    // Function to clear the levels
    // of the nodes
    

    // DFS will calculate second
    // end of the diameter
    
    // Function to find the distance
    // of the farthest distant node
    

    // Function to find the distance
    // of nodes from second end of diameter
    

    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] str = br.readLine().split("\\s+");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
           // @SuppressWarnings("unchecked")
            adj =  new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
            
             farDown = new int[n];
           farDown2 = new int[n];
             far = new int[n];
            
            for (int i = 0; i < n - 1; i++) {
                String[] str2 = br.readLine().split("\\s+");
                int x = Integer.parseInt(str2[0])-1;
                int y = Integer.parseInt(str2[1])-1;
                // Joining Edge between two
                // nodes of the tree
                AddEdge(x, y);
            }
            Arrays.fill(farDown2, -1);
            dfs(0, -1);
            
            dfs2(0, -1, 0);
            for (int x : far) {
                diameter = Math.max(diameter, x);
            }
            for (int i = 1; i <= m; i++) {
                String[] str2 = br.readLine().split("\\s+");
                int V = Integer.parseInt(str2[0])-1;
                long K = Long.parseLong(str2[1]);
                
               
                System.out.println("for vertex"+V+"total is diameter distance is "+diameter);
               // System.out.println(Arrays.toString(far));
                System.out.println( Long.toString(far[V] + (K - 1) * diameter));
                // V---> max distance from end + (k-1)*maxdistance;
            }
            br.close();
        

    }

    private static void dfs2(int vertex, int parent, int upFar) {

        far[vertex] = Math.max(upFar, farDown[vertex]);
        for (int child : adj[vertex]) {
            if (child != parent) {
                int newUpFar = upFar + 1;
                if (farDown[vertex] == farDown[child]+1) {
                    if (farDown2[vertex] != -1) {
                        newUpFar = Math.max(newUpFar, farDown2[vertex]+1);
                    }
                } else {
                    newUpFar = Math.max(newUpFar, farDown[vertex]+1);
                }
                dfs2(child, vertex, newUpFar);
            }
        }
    }

    private static void dfs(int vertex, int parent) {
        for (int child : adj[vertex]) {
            if (child != parent) {
                dfs(child, vertex);
                if (farDown[child]+1 > farDown[vertex]) {
                    farDown2[vertex] = farDown[vertex];
                    farDown[vertex] = farDown[child]+1;
                }
                else if (farDown[child]+1>farDown2[vertex]) {
                    farDown2[vertex] = farDown[child]+1 ;
                }
            }
        }
    }



}
