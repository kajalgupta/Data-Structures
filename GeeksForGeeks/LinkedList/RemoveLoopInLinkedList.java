package GeeksForGeeks.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import javax.xml.transform.Templates;

public class RemoveLoopInLinkedList {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("\\s+");
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Node head = null;
            for (int i = 0; i < n; i++) {
                head = insert(head, arr[i]);
            }
            int x = Integer.parseInt(br.readLine());
            makeLoop(head, x);
            //int length = detectLoop(head) == 1 ? length(head, true) :length(head, false);
            //printList(head);
            removeTheLoop(head);
            printList(head);

        }
    }
    private static void printList(Node headNode) {
        while (headNode != null) {
            System.out.print(headNode.data + " ");
            headNode = headNode.next;
        }
    }

    private static void removeTheLoop(Node head) {
        Node tortoise = head;
        Node hare = head;
        int flag= 0;
        while (hare!=null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (hare == tortoise) {
                flag = 1;
                break;      
        }
    }
    if (flag==1) {
        tortoise = head;
        Node LastNodeLoop = null;
        while (tortoise!=hare) {
            LastNodeLoop = hare;
            hare = hare.next;
            tortoise = tortoise.next;
        }
        LastNodeLoop.next = null;
        
    }
        
    }
/*
    private static int length(Node head, boolean hasLoop) {
        int len = 0;
        if (hasLoop == false) {
            Node temp = head;
            while (temp!=null) {
                len++;
            temp = temp.next;
          }
          return len;
        } else {
            Node hare = head.next;
            Node tortoise = head;
            while (hare != tortoise) {
                hare = hare.next;
                tortoise = tortoise.next;
                hare = hare.next;
                if(hare == tortoise)
                    break;
            }
            int looplen = 0;
            while (hare.next != tortoise) {
                
            }
        }
        return 0;
    }

    private static int detectLoop(Node head) {
        Node hare = head.next;
        Node tortoise = head;
        while (hare != tortoise && hare != null && tortoise != null) {
            hare = hare.next;
            tortoise = tortoise.next;
            if (hare != null && hare.next != null)
                hare = hare.next;
            if (hare == tortoise)
                return 1;
        }
        if (hare == tortoise)
            return 1;
        return 0;
    }
*/
    private static void makeLoop(Node head, int x) {
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;
        int counter = 0;
        while (counter < x) {
            curr = curr.next;
            counter++;
        }
        while (last.next != null)
            last = last.next;
        last.next = curr;

    }

    private static Node insert(Node head, int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            head.next = insert(head.next, data);
        }
        return head;
    }
}