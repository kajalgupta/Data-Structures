package GeeksForGeeks.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSortForLinkedList {
    Node head;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("\\s+");
        MergeSortForLinkedList list1 = new MergeSortForLinkedList();
        list1.head = new Node(Integer.parseInt(str[0]));
        Node previousNode = list1.head;
        for (int i = 1; i < n; i++) {
            Node newNode = new Node(Integer.parseInt(str[i]));
            previousNode.next = newNode;
            previousNode = newNode;
        }
        Node sortedHead = mergeSort(list1.head);
        printList(sortedHead);
       
    }
}

    private static Node mergeSort(Node head) {

        if (head==null || head.next==null) {
            return head;
        }
        Node temp = head;
        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
            
        }
        Node right = null;
        if (fast==null) {
            temp.next = null;
            right = slow;
        } else {
            right = slow.next;
            slow.next = null;
        }
        Node leftSide = mergeSort(head);
        Node rightSide = mergeSort(right);

        return merge(leftSide,rightSide);
    }

    private static Node merge(Node left, Node right) {
        Node extra = new Node(0);
        Node traverse  = extra;
        while (left!=null && right!=null) {
            if (left.data < right.data) {
                traverse.next = left;
                left = left.next;
            } else {
                traverse.next = right;
                right = right.next;
            }
            traverse = traverse.next;
        }
        if (right!=null) {
            traverse.next = right;
            right = right.next;
        }
        if (left != null) {
            traverse.next = left;
            left = left.next;
        }

        return extra.next;
    }
    static void printList(Node n){
        while(n != null){
            System.out.println(n.data);
            n = n.next;
        }
    }

   
    
}