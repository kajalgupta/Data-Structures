package NaraSimhaKarumanchi.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ReversingLinkedListRecursively
 */
public class ReversingLinkedListRecursively {
    static Node head;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("\\s+");
            Node head = new Node(Integer.parseInt(str[0]));
            addToTheLast(head);
            for (int i = 1; i < str.length; i++) {
                addToTheLast(new Node(Integer.parseInt(str[i])));
            }
            reverseLinkedList(head);
            printLinkedList(head);
        }
    }

    private static void printLinkedList(Node head2) {
        while (head!= null) {
            System.out.print(head.data+" -> ");
            head= head.next;
        }
    }

    private static void reverseLinkedList(Node current) {
        if (current==null) {
           return; 
        }
        Node next = current.next;
        if (next==null) {
            head = current;
            return;
        }
        reverseLinkedList(next);
        next.next = current;
        current.next = null;
    }

    private static void addToTheLast(Node node) {
        if (head==null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next!=null) 
                temp = temp.next;
            temp.next = node;
        }
    }
}

  class Node {
      int data;
      Node next;
      Node(int data){
          this.data = data;
      }   
}