package Graph;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Stack;

//Linked List Implementation
class LinkedList<Integer> implements Iterable<Integer> {
    private ListNode<Integer> head;
    private int n;

    private static class ListNode<Integer> {
        private Integer data;
        private ListNode<Integer> next;
    }

    public LinkedList() {
        head = null;
        n = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return n;
    }

    public void add(Integer data) {
        ListNode<Integer> oldFirst = head;
        head = new ListNode<Integer>();
        head.data = data;
        head.next = oldFirst;
        n++;

    }

    public Iterator<Integer> iterator() {
        return new ListIterator(head);
    }

    private class ListIterator implements Iterator<Integer> {
        private ListNode<Integer> current;

        public ListIterator(ListNode<Integer> head) {
            current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Integer data = current.data;
            current = current.next;
            return data;
        }
    }
}

public class AdjacencyListImplementation {

}

//
class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");
	public static List<Integer>[] adjacentList;
    private  static int V;
    private static int E;
    private static LinkedList<Integer>[] adjList;

    // Intializes an empty graph with V vertices & 0 edges
    public Graph(int V) {
        if (V < 0)
            throw new IllegalArgumentException("Number of vertices must be non negative");
        this.V = V;
        this.E = 0;
        adjList = (LinkedList<Integer>[]) new LinkedList[V];
        for (int u = 0; u < V; u++) {
            adjList[u] = new LinkedList();
        }
    }

    public Graph(int V, int E) {
        this(V);
        if (E > V * (V - 1) / 2 + V)
            throw new IllegalArgumentException("Too many edges");
        if (E < 0)
            try {
                throw new IllegalAccessException("Too few edges");
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        Random random = new Random();
        while (this.E != E) {
            int u = random.nextInt(V);
            int v = random.nextInt(V);
            addEdge(u, v);
        }
    }

    public Graph(Graph G) {
        this(G.V());
        this.E = G.E();
        for (int u = 0; u < G.V(); u++) {

            Stack<Integer> reverse = new Stack();
            for (int v : G.adjList[u]) {
                reverse.push(v);
            }
            for (int v : reverse) {
                adjList[u].add(v);
            }
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    private static void validateVertex(int u) {
        if (u < 0 || u >= V) {
            throw new IllegalArgumentException("vertex " + u + " is not between 0 & " + (V - 1));
        }
    }

    static void addEdge(int u, int v) {
        validateVertex(u);
        validateVertex(v);
        E++;
        adjList[u].add(v);
        adjList[v].add(u);
        
    }
    public Iterable<Integer> adjList(int u){
        validateVertex(u);
        return adjList[u];
    }
    public int degree(int u){
        validateVertex(u);
        return adjList[u].size();
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Undirected graph"+NEWLINE);
        s.append(V+ " vertices, "+E+" edges "+NEWLINE);
        for (int u = 0; u<V; u++) {
            s.append(u+": ");
            for (int v : adjList[u]) {
                s.append(v+" ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
    public static void main(String[] args) {
        Graph G = new Graph(5,7);
        System.out.println(G.toString());
    }
}