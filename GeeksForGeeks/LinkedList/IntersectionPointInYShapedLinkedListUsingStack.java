package GeeksForGeeks.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class IntersectionPointInYShapedLinkedListUsingStack {
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
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();
        while (head1!=null) {
            stack1.push(head1);
            head1 =head1.next;
        }
       // System.out.println("peek"+stack1.peek());
       
        
        while (head2!=null) {
            stack2.push(head2);
            head2 =head2.next;
        }
        //System.out.println(stack2.peek());
        //System.out.println("peek next"+stack1.peek().next);
        //System.out.println("peek next"+stack2.peek().next);
        
        Node equalNode = null;
        while (!stack1.isEmpty() && (stack1.peek()==stack2.peek())) {
            //System.out.println("node"+stack1.peek().next);
            equalNode = stack1.peek();
            stack1.pop();
            stack2.pop();
        }
        if (stack1.isEmpty()) {
            return -1;
        }

        return equalNode.data;
    }

    private static void printList(Node temp) {
        while (temp!=null) {
            System.out.print(temp.data+"|");
            temp = temp.next;
        }
        System.out.println();
    }
    

}