package GeeksForGeeks.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSortedLinkedList {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int N = Integer.parseInt(br.readLine()); 
            Node[] a = new Node[N];
            for (int i = 0; i < N; i++) {
                int n = sc.nextInt();
                int p = sc.nextInt();
                Node start = null, current = null;
                Node head = new Node(p);
                start = head;
                current = head;
                for (int j = 1; j < n; j++) {
                    int a1 = sc.nextInt();
                    Node ptr = new Node(a1);
                    current.next = ptr;
                    current = ptr;
                }
                a[i]=start;
            }
            Node start = a[0];
            MergeKSortedLinkedList linkedList = new MergeKSortedLinkedList();
            Node res = linkedList.mergeKList(a,N);
            if (res!=null) {
                printList(res);
                System.out.println();
            }
            
        }
    }

    private static void printList(Node node) {
        if (node==null) return;
        while (node != null) {
            System.out.print(node.data+" ");
            node = node.next; 
        }
            
        
    }

    private Node mergeKList(Node[] a, int N) {
        Node kHead = new Node(0);
        Node traverse = kHead;
        PriorityQueue<Node> listElementsPQ = new PriorityQueue<Node>(new Comparator<Node>(){
         public int compare(Node a, Node b){
             return a.data-b.data;

         }
        });
        for (int i = 0; i < N; i++) {
            listElementsPQ.add(a[i]);
        } 
        while (!listElementsPQ.isEmpty()) {
            Node temp = listElementsPQ.poll();
            if (temp.next!=null) {
                listElementsPQ.add(temp.next);
            }
            traverse.next = temp;
            traverse = traverse.next;
        }

        return kHead.next;
    }
}

class QueueNode implements Comparable<QueueNode> {

    int array, index, value;
    Node node;
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