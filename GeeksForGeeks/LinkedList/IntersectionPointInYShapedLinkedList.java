package GeeksForGeeks.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntersectionPointInYShapedLinkedList {
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
        while (temp1!=null) {
            temp1.data = -temp1.data;
            if (temp1.data == 0) {
                temp1.data = -100000; 
            }
            temp1 = temp1.next;
        }
        while (temp2!=null&& temp2.data>=0 ) {
            temp2 = temp2.next;
        }
        if (temp2==null) {
            return -1;
        }
        if(temp2.data == -100000) return 0;
        return -temp2.data;
    }

    
    public static void printList(Node temp) {
        while (temp!=null) {
            System.out.print(temp.data+"|");
            temp = temp.next;
        }
        System.out.println();
    }
/* WITH EXTRA SPACE
    private static int intersectPoint(Node head1, Node head2) {
        //HashSet<String> set = new HashSet<>();
        List<Node> list = new ArrayList<Node>();
        Node temp1 = head1;
        while (temp1.next!=null) {
            list.add(temp1.next);
            temp1 = temp1.next;
        }
        System.out.println(list);
        Node temp2 = head2;
        while (temp2.next!=null) {
            if (list.contains(temp2.next)) {
                return temp2.next.data;
            }
            temp2 = temp2.next;
        }
        return 0;
    }
*/
/*
without extra SPACE
*/
    Node addToTheLastNode(Node node) {
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

}