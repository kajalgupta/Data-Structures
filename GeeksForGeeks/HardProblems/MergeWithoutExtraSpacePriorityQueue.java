package GeeksForGeeks.HardProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

//import javafx.scene.layout.Priority;

public class MergeWithoutExtraSpacePriorityQueue {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String[] ip = br.readLine().split("\\s+");
            int X = Integer.parseInt(ip[0]);
            int Y = Integer.parseInt(ip[1]);
            String[] str1 =  br.readLine().split("\\s+");
            String[] str2 =  br.readLine().split("\\s+");
            int[] arr1 = new int[X];
            int[] arr2 = new int[Y];
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = Integer.parseInt(str1[i]);
            }
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = Integer.parseInt(str2[i]);
            }
            merge(arr1, X, arr2, Y);
        }
    }

    private static void merge(int[] arr1, int X, int[] arr2, int Y) {

        //PriorityQueue<QueueNode> pq = new PriorityQueue<QueueNode>();
        PriorityQueue<Integer>  pq = new PriorityQueue<>();
        for (int i = 0; i < X; i++) {
            pq.add(arr1[i]);     
        }
        for (int i = 0; i < Y; i++) {
            pq.add(arr2[i]);     
        }
        for (int i = 0; i < X; i++) {
            arr1[i] = pq.poll();
        }
        for (int i = 0; i < Y; i++) {
            arr2[i] = pq.poll();
        }
        System.out.println(Arrays.toString(arr1).replace("[","").replace("]", "").replace(",","")+" "+Arrays.toString(arr2).replace("[","").replace("]", "").replace(",",""));
  
        /*
        pq.add(new QueueNode(1, 0, arr1[0]));
        pq.add(new QueueNode(2, 0, arr2[0]));
        int j =0;
        for (int i = 0; !pq.isEmpty(); i++) {
            QueueNode n = pq.poll();
            if (j<X) {
                arr1[j++] = n.value;
                int nextIndex = n.index+1;
                if (n.array==1 && nextIndex<X) {
                    pq.add(new QueueNode(1, nextIndex, arr1[nextIndex]));
                }
                else if (n.array==2 && nextIndex<Y)  {
                    pq.add(new QueueNode(2, nextIndex, arr2[nextIndex]));
                }
            }
        }
        */

    }


}
/*
class QueueNode implements Comparable<QueueNode>{
    int value, index, array;
    public QueueNode(int array, int index, int value){
        this.array = array;
        this.index = index;
        this.value = value;
    }
    public int compareTo(QueueNode n){
        if(value>n.value)  return 1;
        else if(value < n.value) return -1;
        else return 0;
    }
}
*/