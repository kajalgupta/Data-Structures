
package DisjointSet;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class DisjointSetImplementation {
    static class Node {
        long data;
        int rank;
        Node parent;
    }
    private static HashMap<Long, Node> map = new HashMap<>();

    public static void makeSet(long data) {
        Node node = new Node();
        node.data = data;
        node.rank  = 0;
        node.parent = node;
        map.put(data, node); 
    }

    private static boolean union(Long v1, Long v2) {
        Node node1 = map.get(v1);
        Node node2 = map.get(v2);

        Node parent1 = findSet(node1);    //absoluteRoot Parent not just parent
        Node parent2 = findSet(node2);
        
        if (parent1.data == parent2.data) {
            return false;
           
        }
        if(parent1.rank == parent2.rank){
            parent1.rank += 1;
            parent2.parent = parent1;
        }
        else{
            parent2.parent = (parent1.rank > parent2.rank) ? parent1  : parent2.parent;
            parent1.parent = (parent1.rank < parent2.rank) ? parent2  : parent1.parent;
        }
        return true;
    }

    private static Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return parent;
        }
        node.parent =  findSet(node.parent);  //path compression
        return node.parent;
    }

    private static long findSet(long vertex) {              // Finds the representative of this set
        
        return findSet(map.get(vertex)).data;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int V = Integer.parseInt(str[0]);
        for (int i = 1; i <= V; i++) {
            makeSet(i);
        }
        int E = Integer.parseInt(str[1]);
        while (E>0) {
            String[] str2 = br.readLine().split("\\s+");
            Long v1 = Long.parseLong (str2[0]);
            Long v2 = Long .parseLong (str2[1]);
        
            union(v1, v2);
            
            E--;
        }

        for (int i = 1; i <= V; i++) {
            System.out.println(findSet((long)i));
        }

    }

   
}

/*
7 6
1 2
2 3
4 5
6 7
5 6
3 7

*/