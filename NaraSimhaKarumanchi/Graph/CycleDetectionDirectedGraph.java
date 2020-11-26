package Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class CycleDetectionDirectedGraph {
    private static List<Integer>[] adjacency;
    private static HashSet<Integer> whiteSet = new HashSet<>();
    private static HashSet<Integer> blackSet = new HashSet<>(); // destination
    private static HashSet<Integer> greySet = new HashSet<>();

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
        adjacency = Graph.adjacentList;
        System.out.println(isCyclic(adjacency, n));
    }

    private static boolean isCyclic(List<Integer>[] adjacencyGraph, int n) {
        for (int i = 0; i < n; i++) {
            whiteSet.add(i);
        }
        // for (Integer integer : whiteSet) {
        while (whiteSet.size() > 0) {
            int integer = whiteSet.iterator().next();
            if (dfs(integer, adjacencyGraph))
                return true;
        }
        return false;
    }

    private static boolean dfs(Integer node, List<Integer>[] adjacencyGraph) {
        moveVertex(whiteSet, greySet, node);
        for (int integer : adjacencyGraph[node]) {
            if (blackSet.contains(integer))
                continue;
            if (greySet.contains(integer)) {
                return true;
            }
            if (dfs(integer, adjacencyGraph))
                return true;
        }
        moveVertex(greySet, blackSet, node);
        return false;

    }

    private static void moveVertex(HashSet<Integer> source, HashSet<Integer> destination, Integer vertex) {
        source.remove(vertex);
        destination.add(vertex);
    }
}