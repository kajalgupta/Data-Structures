package GreedyAlgorithms;

public class WeightedGraph {
    
    static class Edge implements Comparable<Edge>{
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        public Edge(){
            this.source = -1;
            this.destination = -1;
            this.weight = -1;
        }

        @Override
        public int compareTo(Edge compareEdge) {
            // TODO Auto-generated method stub
            return this.weight - compareEdge.weight;
        }

        
    }

    static class Graph{
        int vertices;
        int edges;
       static Edge[] edgesList;
        int x = 0;
        Graph(int vertices, int edges){
            this.vertices = vertices;
            this.edges = edges;
            for (int i = 0; i < edges; i++) {
                edgesList[i] = new Edge();
            }
        }
        public void addEdge(int source, int destination, int weight){
            Edge edge = new Edge(source, destination, weight);
            //adjacencyList[source].addFirst(edge);
            edgesList[x++] = edge;

        }

    }
}