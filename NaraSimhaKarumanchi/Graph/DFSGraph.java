package NaraSimhaKarumanchi.Graph;

import java.util.Random;
import java.util.Stack;

public class DFSGraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int V;
    private int E;
    private boolean[][] adjMatrix;
    boolean[] visited;

    public DFSGraph(int V){
        if (V<0) {
            throw new IllegalArgumentException("Too few vertices");
        }
        this.V = V;
        this.E = 0;
        this.adjMatrix = new boolean[V][V];
        visited = new boolean[V];
    }
    public DFSGraph(int V, int E){
        this(V);
        if (E>(long)V*(V-1)/2+V) {
            throw new IllegalArgumentException("Too many edges");
        }
        if (E<0) {
            throw new IllegalArgumentException("Too few edges");
        }
        Random random = new Random();
        while (this.E != E) {
            int u = random.nextInt(V);
            int v = random.nextInt(V);
            addEdge(u,v);
            
        }
        visited = new boolean[V];
    }

    private void addEdge(int u, int v) {
        if (!adjMatrix[u][v]) {
            E++;
        }
        adjMatrix[u][v] = true;
        adjMatrix[v][u] = true;
    }

    public void DFS() {
        Stack<Integer> s = new Stack<>();
        clearVisited();
        s.push(0);
        while ( !s.isEmpty()) {
            int nextNode;
            int i;
            nextNode = s.pop();
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                System.out.println("nextNode = "+nextNode);
                for ( i = 0; i<V; i++) {
                    if ((adjMatrix[nextNode][i]==true)&& !visited[i]) {
                        s.push(i);
                    }
                }
            }

        }
    }
        
    private void clearVisited() {
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
            int V = 5;
            int E = 7;
            DFSGraph G = new DFSGraph(V, E);
            System.out.println(G.toString());
            G.DFS();
        }
    
}