package GeeksForGeeks.LinkedList;

import java.util.Scanner;

/**
 * FindingMiddleElement
 */
public class FindingMiddleElement {

    Node head;
    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        }
        else{
            Node temp = head;
            while (temp.next!=null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t>0) {
            int n = sc.nextInt();
            FindingMiddleElement linkedList = new FindingMiddleElement();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            linkedList.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                linkedList.addToTheLast(new Node(a));
            }
            
            System.out.println(getMiddle(linkedList.head));
            --t;
        }
        sc.close();
    }

    private static int getMiddle(Node head2) {
        Node temp = head2;
        int count = 1;
        while (temp.next!=null) {
            temp=temp.next;
            count++;
        }
        //System.out.println(count);
        int midPosition = count/2+1;
        int i=1;
        temp = head2;
        while (i!=midPosition) {
            temp = temp.next;
            i++;
        }


        return temp.data;
    }
}

 class Node {
    int data;
    Node next;
    Node(int d){
        data = d;
        next = null;
    }
    
}