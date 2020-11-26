import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DFS_BFSIterative {
    // static List<Integer>[] adjacentList;// = new List[100];
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(
                    new FileReader("E:/DataStructures/NaraSimhaKarumanchi/Graph/input.txt"));
        String[] str = br.readLine().split("\\s+");
        int n = Integer.parseInt(str[0]);
        int E = Integer.parseInt(str[1]);
        Graph g = new Graph(n);

        while (E > 0) {
            String[] str2 = br.readLine().split("\\s+");
            int x = Integer.parseInt(str2[0]);

            int y = Integer.parseInt(str2[1]);
            Graph.addEdge(x, y);
            E--;
        }
        List<Integer> a[] = Graph.adjacentList;
        for (List<Integer> list : a) {
            System.out.println(list); // checking
        }
        System.out.println("DFS Impementation!");
        dfs(a);
        System.out.println("BFS Impementation!");
        bfs(a);

    }

    private static void dfs(List<Integer>[] adjList) {

        HashSet<Integer> visited = new HashSet<>();
        int source = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            int element = stack.pop();
            if (!visited.contains(element)) {
                visited.add(element);
                System.out.println(element);
                for (Integer node : adjList[element]) {
                    stack.push(node);
                }
            }

        }

    }

    private static void bfs(List<Integer>[] adj) {
        HashSet<Integer> visited = new HashSet<>();
        int source = 1;
        Queue<Integer> nodesQueue = new LinkedList<>();
        nodesQueue.add(source);
        while (!nodesQueue.isEmpty()) {
            int element = nodesQueue.remove();
            if (!visited.contains(element)) {
                visited.add(element);
                System.out.println(element);
                for (Integer node : adj[element]) {
                    nodesQueue.add(node);
                }

            }
        }
    }

}
