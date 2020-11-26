package GeeksForGeeks.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntersectionPointInYShapedLinkedListUsingDifferenceOfNodeCounts {
    Node head, tail;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            //int n = Integer.parseInt(br.readLine()); 
            String[] str = br.readLine().split("\\s+");
            int x  = Integer.parseInt(str[0]);
            int y  = Integer.parseInt(str[1]);
            int z  = Integer.parseInt(str[2]);
             String[] strx = br.readLine().split("\\s+");
             IntersectionPointInYShapedLinkedList linkedList1 = new IntersectionPointInYShapedLinkedList();
             IntersectionPointInYShapedLinkedList linkedList2 = new IntersectionPointInYShapedLinkedList();
             IntersectionPointInYShapedLinkedList linkedList3 = new IntersectionPointInYShapedLinkedList();
             
             
             Node head1 = new Node(Integer.parseInt(strx[0]));
             Node tail1 = head1;
             tail1 = linkedList1.addToTheLastNode(head1);
             for (int i = 1; i < strx.length; i++) {
                 tail1 = linkedList1.addToTheLastNode(new Node(Integer.parseInt(strx[i])));
             }
             String[] stry = br.readLine().split("\\s+");
             Node head2 = new Node(Integer.parseInt(stry[0]));
             Node tail2 = linkedList2.addToTheLastNode(head2);
             for (int i = 1; i < stry.length; i++) {
                tail2 = linkedList2.addToTheLastNode(new Node(Integer.parseInt(stry[i])));
            }
             String[] strxy = br.readLine().split("\\s+");
             Node head3 = new Node(Integer.parseInt(strxy[0]));
             Node tail3 = linkedList3.addToTheLastNode(head3);
             tail1.next = tail3;
             tail2.next = tail3;
             for (int i = 1; i < strxy.length; i++) {
                linkedList3.addToTheLastNode(new Node(Integer.parseInt(strxy[i])));
                //linkedList2.addToTheLastNode(new Node(Integer.parseInt(strxy[i])));
            }
            printList(head1);
            printList(head2);
            
            int result = intersectPoint(head1, head2);
            System.out.println(result);
        }
    }
    
    private static int intersectPoint(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        int length1 = 0;
        int length2 = 0;
        while (temp1!=null) {
            ++length1;
            temp1 = temp1.next;
        }
        while (temp2!=null) {
            ++length2;
            temp2 = temp2.next;
        }
        int difference = Math.abs(length1-length2);
        Node tempHead1 = (length1>length2)? head1:head2;
        Node tempHead2 = (tempHead1==head1)? head2:head1;
        
        while (difference>0) {
            tempHead1 = tempHead1.next;
            difference--;
        }
        while (tempHead1!=null && tempHead1!= tempHead2) {
           tempHead1 = tempHead1.next;
           tempHead2 = tempHead2.next;
           
        }
        if (tempHead1==null) {
            return -1;
        }
        return tempHead1.data;
    }

    private static void printList(Node temp) {
        while (temp!=null) {
            System.out.print(temp.data+"|");
            temp = temp.next;
        }
        System.out.println();
    }
    /*
    private Node addToTheLastNode(Node node) {
        if (head == null) {
            head = node;
            return head;
        } else {
            Node temp = head;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = node;
            tail = node;
            return tail;
        }
    }
    */

}