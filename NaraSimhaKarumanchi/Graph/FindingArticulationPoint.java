import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindingArticulationPoint {
    private static List<Integer>[] adjacency;
    private static int time;


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
        HashSet<Integer> articulationPoints = findArticulationPoints(adjacency);
        articulationPoints.forEach(point -> System.out.println(point));
        
    }

    private static HashSet<Integer> findArticulationPoints(List<Integer>[] adjacency) {
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> articulationPoints = new HashSet<>();
        time = 0;
        HashMap<Integer, Integer> parentMap = new HashMap<>();
        HashMap<Integer, Integer> visitedTimeMap = new HashMap<>();
        HashMap<Integer, Integer> localTimeMap = new HashMap<>();
        int startVertex = 1;
        parentMap.put(1, null);
        DFS(visited, articulationPoints, parentMap, visitedTimeMap, localTimeMap, startVertex);
        return articulationPoints;
    }

    private static void DFS(HashSet<Integer> visited, HashSet<Integer> articulationPoints,
            HashMap<Integer, Integer> parentMap, HashMap<Integer, Integer> visitedTimeMap,
            HashMap<Integer, Integer> localTimeMap, int startVertex) {

                visited.add(startVertex);
                visitedTimeMap.put(startVertex, time);
                localTimeMap.put(startVertex, time);
                time++;
                int childCount = 0;
                boolean isArticulation = false;

                for(Integer adjacentNode : adjacency[startVertex]){
                   // System.out.println("start"+startVertex);
                    if (adjacentNode == parentMap.get(startVertex)) {
                        continue;
                    }
                    if (!visited.contains(adjacentNode)) {
                        //visited.add(adjacentNode);
                        parentMap.put(adjacentNode, startVertex);
                        childCount++;
                        DFS(visited, articulationPoints, parentMap, visitedTimeMap, localTimeMap, adjacentNode);

                        if (visitedTimeMap.get(startVertex)<= localTimeMap.get(adjacentNode)) {
                            isArticulation = true;
                        }
                        else{
                            localTimeMap.put(startVertex, Math.min(localTimeMap.get(adjacentNode), localTimeMap.get(startVertex)));
                        }
                        
                    }
                    else{
                       localTimeMap.put(startVertex, Math.min(visitedTimeMap.get(adjacentNode), localTimeMap.get(startVertex)));
                    }

                }

                //Check 2 conditions
                if (parentMap.get(startVertex)== null && childCount == 2 || parentMap.get(startVertex) != null && isArticulation ) {
                    articulationPoints.add(startVertex);
                }

    }
    
}