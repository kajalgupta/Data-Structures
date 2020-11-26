package GeeksForGeeks.HardProblems;

import java.util.Scanner;
import java.util.Stack;

public class ReorderList {
    Node head;
    Node last;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t>0) {
            int n = sc.nextInt();
            ReorderList linkList =  new ReorderList();
            int a = sc.nextInt();
            Node head = new Node(a);
            linkList.addToTheLastNode(head);
            for (int i = 1; i < n; i++) {
                a = sc.nextInt();
                linkList.addToTheLastNode(new Node(a));
            }
            linkList.head = reorderList(linkList.head);
            linkList.printList();
            t--;
        }
    }

    private void printList() {
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    private static Node reorderList(Node head) {

        Node slowPointer = head;
        Node fastPointer = head.next;

        while (fastPointer!=null && fastPointer.next!=null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        Node head2 = slowPointer.next;
        slowPointer.next = null;
        Stack<Node> stack = new Stack<>();
        while (head2!=null) {
            stack.push(head2);
            head2 = head2.next;
        }
        Node temp = head; //1
        while (!stack.isEmpty()) {
            Node temp2 = stack.pop();
            temp2.next = temp.next;
            temp.next = temp2;
            temp = temp2.next;
        }
        if(temp!=null)
        temp.next = null;
        return head;

       // return null;
    }

    public void addToTheLastNode(Node node) {
        if (head==null) {
            head = node;
            last = head;
         } else {
        //     Node temp = head;
        //     while (temp.next!=null) {
        //         temp=temp.next;
        //     }
            last.next = node;
            last = last.next;
        }

    }

    
}