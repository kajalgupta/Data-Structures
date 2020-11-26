package GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

import GreedyAlgorithms.WeightedGraph.Edge;
import GreedyAlgorithms.WeightedGraph.Graph;
import DisjointSet.DisjointSetImplementation;
public class KruskalMinimumSpanningTree {
    private  static Edge[] edgeList;
    private static int V;

    
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String[] str = br.readLine().split("\\s+");
            V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
            Graph graph = new Graph(V, E);
            int edges = E;
            while(edges>0){
                String[] str2 = br.readLine().split("\\s+");
                int a = Integer.parseInt(str2[0]);
                int b = Integer.parseInt(str2[1]);
                int w = Integer.parseInt(str2[2]);
                graph.addEdge(a, b, w);
                edges--;
            }
           
            for(int i=0; i<V; i++){
                DisjointSetImplementation.makeSet((long)V);
            }
             edgeList = graph.edgesList;
            kruskalMST();
        }
    }
    static void kruskalMST(){
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (int j = 0; j < V; j++) {
         result[j] = new Edge();
        }
        Arrays.sort(edgeList);
        System.out.println(edgeList);

        
    }

   
    
    
}