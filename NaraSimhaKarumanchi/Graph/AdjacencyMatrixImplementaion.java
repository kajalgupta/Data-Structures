package Graph;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class AdjacencyMatrixImplementaion {
    private final String NEWLINE = System.getProperty("line.separator");
        private final int V;
        private int E;
        private boolean[][] adjMatrix;
        //EMPTY GRAPH WITH V VERTICES.
        public AdjacencyMatrixImplementaion(int V){
            if (V<0) {
                throw new IllegalArgumentException("Too few Vertices");
            }
            this.V = V;
            this.E = 0;
            this.adjMatrix = new boolean[V][V];
        }

    public AdjacencyMatrixImplementaion(int V, int E) {
        this(V);
        if (E>V*(V-1)/2+V) {
            throw new IllegalArgumentException("Too many edges");
        }
        if (E < 0) {
            throw new IllegalArgumentException("Too few edges");
        }
        Random random = new Random();
        while (this.E != E) {
            int u = random.nextInt(V);
            int v = random.nextInt(V);
            addEdge(u,v);
        }

    }

    public int V() {   return V; }
    public int E() {   return E; }
    // ADD UNDIRECTED EDGE u-v
    private void addEdge(int u, int v) {
        if (!adjMatrix[u][v]) {
            E++;
        }
        adjMatrix[u][v] = true;
        adjMatrix[v][u] = true;

    }
    public boolean contains(int u, int v){
        return adjMatrix[u][v];
    }
    // RETURNS LIST OF NEIGHBOURS OF u
    public Iterable<Integer> adjMatrix(int u){
        return new AdjIterator(u);
    }
    //SUPPORT ITERATION OVER GRAPH VERTICES
    private class AdjIterator implements Iterator<Integer>, Iterable<Integer>{
        private int u;
        private int v=0;

        AdjIterator(int u){
            this.u = u;
        }
        public Iterator<Integer> iterator() {
            return this;
        }
        public boolean hasNext() {
            while (v<V) {
                if(adjMatrix[u][v]) return true;
                v++;
            }
            return false;
        }
        public Integer next(){
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return v++;
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Undirected Graph"+NEWLINE);
        s.append("Vertices:"+ V+ " and edges:" +E+NEWLINE);
        for (int u = 0; u < V; u++) {
            s.append(u+": ");
            for (int v = 0; v < V; v++) {
                s.append(String.format("%7s", adjMatrix[v][u])+" ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }


    public static void main(String[] args) {
        int V = 5;
        int E = 7;
        AdjacencyMatrixImplementaion graph = new AdjacencyMatrixImplementaion(V, E);
        System.out.println(graph.toString());
    }
    
}