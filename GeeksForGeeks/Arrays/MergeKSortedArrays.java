package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
            int k = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("\\s+");
            int[][] array = new int[k][k];
            int m = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = Integer.parseInt(str[m++]);
                }
            }
            System.out.println(mergeKArrays(array, k).toString().replace("[", "").replace("]", "").replace(",",""));
        }
    }

    private static ArrayList<Integer> mergeKArrays(int[][] array, int k) {
        PriorityQueue<QueueNode> pq = new PriorityQueue<>();
       // System.out.println(Arrays.deepToString(array));
        int size = 0;
        for (int i = 0; i < array.length; i++) {
            size += array[i].length;
            if (array[i].length>0) { //since there can be an empty array 
                pq.add(new QueueNode(i, 0, array[i][0]));
            }
           
        }
        ArrayList<Integer> resultList = new ArrayList<>(size);
        for (int i = 0; !pq.isEmpty(); i++) {
            QueueNode n = pq.poll();
            //System.out.println("value is"+n.value);
            resultList.add(n.value);
        int nextIndex = n.index + 1;
        if (nextIndex < array[n.array].length) {
            pq.add(new QueueNode(n.array, nextIndex, array[n.array][nextIndex]));
        }
            
        }
        return resultList;

    }

}

class QueueNode implements Comparable<QueueNode> {

    int array, index, value;

    public QueueNode(int array, int index, int value) {
        this.array = array;
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(QueueNode n) {
        if (value > n.value)
            return 1;
        if (value < n.value)
            return -1;
        else
            return 0;
    }

}