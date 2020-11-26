package Graph;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Graph {

    static List<Integer>[] adjacentList;

    public Graph(int vertices) {
        adjacentList = new List[vertices+1];
        for (int i = 0; i < vertices+1; i++) {
            adjacentList[i] = new ArrayList<Integer>();
        }

    }

    public static void addEdge(int u, int v) {
        adjacentList[u].add(v);                 //--- Directed Graph
       // adjacentList[v].add(u);
    }

}