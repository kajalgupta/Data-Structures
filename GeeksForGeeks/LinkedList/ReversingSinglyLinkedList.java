package GeeksForGeeks.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * ReversingSinglyLinkedList
 */
public class ReversingSinglyLinkedList {
    static Node head;

    public static void main(final String[] args) throws NumberFormatException, IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
            final int n = Integer.parseInt(br.readLine());
            final String[] str = br.readLine().split("\\s+");
            final Node head = new Node(Integer.parseInt(str[0]));
            addToTheLastNode(head);
            for (int i = 1; i < n; i++) {
                addToTheLastNode(new Node(Integer.parseInt(str[i])));
            }
            printList(head);
            System.out.println("Check if linked list is palindrome---------");
            boolean ans = isPalindrome(head);
            System.out.println("list is" + ans);
            System.out.println("----pairwise swap");
            Node newHead = pairwiseSwap(head);

            printList(newHead);
            System.out.println("--------------------");
            System.out.println("segregate 0's 1's 2's linked list---------");
            Node newNode = segregate(head);
            printList(newNode);
            System.out.println("--------------------");

            // printList(newNode);
            final Node headNode = reverselinkedList(head);
            printList(headNode);
            int k = detectLoop(headNode);
            System.out.println(detectLoopUsingFloyd(headNode));
        }
    }

    private static boolean isPalindrome(Node head) {
        if(head.next==null)
        return true;
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        temp = head;
        System.out.println("length is " + length);
        Node list2head = null;
        int mid = length / 2;
        System.out.println("mid is " + mid);
        int count = 1;
        Node midNode = null;
        while (count < mid) {
            temp = temp.next;
            count++;
        }
        midNode = (length % 2 == 0) ? temp : temp.next;
        list2head = midNode.next;
        temp.next = null;

        System.out.println("list2head---" + list2head.data);
        // reverse last half
        Node head2 = reverselinkedList(list2head);
        System.out.println("------------reversed part");
        printList(head2);
        while (head != null && head2 != null) {
            if (head.data != head2.data) {
                break;
            }
            head = head.next;
            head2 = head2.next;
        }
        if (head == null && head2 == null) {
            return true;
        } else {
            return false;
        }
        // }

        // return false;
    }

    private static Node segregate(Node head) {
        if (head.next == null) {
            return head;
        }
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        Node temp = head;
        while (temp != null) {
            if (temp.data == 0)
                count0++;
            else if (temp.data == 1)
                count1++;
            else {
                count2++;
            }
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (count0 > 0) {
                temp.data = 0;
                count0--;
            } else {
                if (count1 > 0) {
                    temp.data = 1;
                    count1--;
                } else {
                    temp.data = 2;
                    count2--;
                }
            }
            temp = temp.next;
        }

        return head;
    }

    private static Node pairwiseSwap(Node head) {

        if (head.next == null) {
            return head;
        }
        System.out.println("hey" + head.next.next.data);
        // Node swappedHead = head.next;
        Node temp1 = head;
        Node temp2 = head.next;
        while (temp2 != null) {
            int swap = temp1.data;
            temp1.data = temp2.data;
            temp2.data = swap;
            // Node temp3 = temp1;
            temp1 = temp2.next;
            temp2 = (temp1 != null) ? temp1.next : null;
            // System.out.println(head.data);
            // head = head.next.next;
        }

        return head;
    }

    private static boolean detectLoopUsingFloyd(Node headNode) {
        Node slowPtr = head;
        Node fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                return true;
            }

        }
        return false;
    }

    private static int detectLoop(Node headNode) {
        HashSet<Node> addressSet = new HashSet<>();
        Node temp = headNode;
        while (temp != null) {
            if (addressSet.add(temp)) {
                temp = temp.next;
            } else {
                return 1;
            }
        }
        return 0;
    }

    private static void printList(Node headNode) {
        while (headNode != null) {
            System.out.print(headNode.data + " ");
            headNode = headNode.next;
        }
    }

    private static Node reverselinkedList(Node head2) {
        Node previous = null;
        Node current = head2;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private static void addToTheLastNode(final Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
}

/**
 * Node
 */
/*
 * class Node { int data; Node next;
 * 
 * Node(final int data) { this.data = data; next = null; }
 * 
 * }
 */