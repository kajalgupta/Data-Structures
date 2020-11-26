package Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CountSimplePaths {
    static List<Integer> adjacency[];

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
        // source and destination
        String[] str2 = br.readLine().split("\\s+");
        int source = Integer.parseInt(str2[0]);

        int destination = Integer.parseInt(str2[1]);

        adjacency = Graph.adjacentList;
        // for (List<Integer> list : adjacency) {
        // System.out.println(list); // checking
        // }
        countPaths(source, destination);
    }

    private static void countPaths(int source, int destination) {
        HashSet<Integer> visited = new HashSet<>();
        List<Integer> pathList = new ArrayList<>();
        pathList.add(source);
        countAllPathsUtil(source, destination, visited, pathList); // Recursive Method through DFS

    }

    private static void countAllPathsUtil(int s, int d, HashSet<Integer> visitedSet, List<Integer> path) {
        visitedSet.add(s);

        if (s == d) {
            // print
            visitedSet.remove(s);
            System.out.println(path);
            return;
            // path.remove(s);
        }
        for (int i : adjacency[s]) {
            if (!visitedSet.contains(i)) {
                path.add(i);
                countAllPathsUtil(i, d, visitedSet, path);
                path.remove(Integer.valueOf(i));
            }

        }
        visitedSet.remove(s);

    }

}