package NaraSimhaKarumanchi.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * FindingMiddleElement
 */
public class FindingMiddleNode {
    Node head;
    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        }
        else{
            Node temp = head;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("\\s+");
        Node head = new Node(Integer.parseInt(str[0]));
        FindingMiddleNode linkedList = new FindingMiddleNode();
        linkedList.addToTheLast(head);
        for (int i = 1; i < n; i++) {
            linkedList.addToTheLast(new Node(Integer.parseInt(str[i])));
        }
        System.out.println(getMiddleNode(linkedList.head));
    }
    }

    private static int getMiddleNode(Node head2) {
        Node ptr1, ptr2;
        ptr1 = ptr2 = head2;
        int i=0;
        int count =1;
        while (ptr2.next != null) {
            if (i==0) {
                ptr2 = ptr2.next;
                i = 1;
                
            } else {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
                i=0;
            }
            count++;
        }
        
        return count%2==0?ptr1.next.data:ptr1.data;
    }
}
        
/**
 * int data;
 * Node next;
 * Nint dataode(){
 * }    this.data = data;
 * next = null;
 * Node
 */

 class Node {
     int data;
     Node next;
     Node(int data){
        this.data = data;
        next = null;
     }
}  
