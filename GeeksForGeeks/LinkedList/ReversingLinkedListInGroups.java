package GeeksForGeeks.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ReversingLinkedListInGroups
 

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }

}
*/
public class ReversingLinkedListInGroups {
    static Node head;
    static Node nextNode;
    private static void addToTheLastNode(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("\\s+");
            int k = Integer.parseInt(br.readLine());
            Node head = new Node(Integer.parseInt(str[0]));
            addToTheLastNode(head);
            for (int i = 1; i < n; i++) {
                addToTheLastNode(new Node(Integer.parseInt(str[i])));
            }
            // System.out.println(head);
            // printList(head);

            int division = (int) Math.ceil((int) n / k);
            // System.out.println(division);
            int z = 1;
            nextNode = head;
            while (z <= division) {
                ReversingLinkedListGroups(nextNode, k);
            }
            printList(head);

        }
    }

    private static void printList(Node head2) {
        while (head2 != null) {
            System.out.print(head2.data + " head data is");
            head2 = head2.next;
        }
    }

    private static Node ReversingLinkedListGroups(Node head, int k) {
        /*
         * if (current==null) { return null; } Node next = current.next; if (next==null)
         * { head = current; return null; } ReversingLinkedListGroups(next, --k);
         * next.next = current; current.next = null; return head;
         */
      Node current = head;
      Node previous = null;
      Node next = null;
      int count = k;
      while (current!=null && count>0) {
         next =  current.next;
         current.next = previous;
         previous = current;
         current = next;
         count--;
        }
        if (next!=null) {
           head.next =  ReversingLinkedListGroups(next, k);       
        }
      return previous;

    }


}

/**
 * Node int data; Node next; Node(int d){ data = d; next = null;}
 */
