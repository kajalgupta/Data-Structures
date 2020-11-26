import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class DFS_Recursive {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:/DataStructures/NaraSimhaKarumanchi/Graph/input.txt"));
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
        List<Integer> adjacency[] = Graph.adjacentList;
        for (List<Integer> list : adjacency) {
            System.out.println(list); // checking
        }
        HashSet<Integer> visited = new HashSet<>();
        dfs(adjacency, visited, 1);
        Queue<Integer> nodesQueue = new ArrayDeque<>();
        nodesQueue.add(1);
        visited.clear();
        System.out.println("BFS Recursive");
        bfs(adjacency, visited, 1, nodesQueue);

    }

    private static void bfs(List<Integer>[] adjacency, HashSet<Integer> visited, int v, Queue<Integer> queue) {
        System.out.println(v + " ");
        visited.add(v);
        for (int i : adjacency[v]) {
            if (!visited.contains(i)) {
                queue.add(i);
            }
        }
        queue.poll();
        if (!queue.isEmpty()) {
            bfs(adjacency, visited, queue.peek(), queue);
        }
    }

    private static void dfs(List<Integer>[] adjacency, HashSet<Integer> visited, int v) {
        visited.add(v);
        System.out.println(v + " ");
        for (int i : adjacency[v]) {
            if (!visited.contains(i)) {
                dfs(adjacency, visited, i);
            }
        }

    }

}