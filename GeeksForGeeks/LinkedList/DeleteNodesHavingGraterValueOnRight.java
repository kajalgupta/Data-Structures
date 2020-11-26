package GeeksForGeeks.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class DeleteNodesHavingGraterValueOnRight {
    Node head;
    public void addToTheLastNode(Node node) {
        if (head == null){
            head = node;
        }
        else{
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = node;
    }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("\\s+");
            Node head = new Node(Integer.parseInt(str[0]));
            DeleteNodesHavingGraterValueOnRight linkedList = new DeleteNodesHavingGraterValueOnRight();
            linkedList.addToTheLastNode(head);
            for (int i = 1; i < n; i++) {
                linkedList.addToTheLastNode(new Node(Integer.parseInt(str[i])));
            }
           // deleteNode(linkedList); --> UNOPTIMISED APPROACH
           compute(linkedList);
           System.out.println("linked list is");
           linkedList.printList();
        }
    }
    /*
    private static void deleteNode(DeleteNodesHavingGraterValueOnRight linkedList) {
        
            
         if (linkedList.head.next!=null){
             
        Node current = linkedList.head;
        Node next = current.next;
        while (next.data > current.data) {
            linkedList.head = next;
            next = current.next;
        }
        Node previous = current;
        current = next;
        next = next.next;
        while (next!=null) {  
            if (next.data > current.data) {
                previous.next = next;
            }
            else{
                previous = previous.next;
            }
            current = next;
                next = current.next;
        }
    }
        linkedList.printList();
    }
    */

    private static void compute(DeleteNodesHavingGraterValueOnRight linkedList) {
        Stack<Node> stack = new Stack<Node>();
        Node head = linkedList.head;
        stack.add(head);
        Node temp = head.next;
        while (temp!=null) {
            if (temp.data<stack.peek().data) {
                stack.push(temp);   
            } else {
                while (stack.size()>0 && stack.peek().data<temp.data) 
                    stack.pop();
                stack.push(temp);   
            }
            temp = temp.next;
        }   
            temp = head;
            //int stackSize = stack.size();
            while (stack.size()>1) {
                Node node = stack.remove(0);
                temp.data = node.data;
                temp = temp.next;
               // System.out.println(temp.data);
            }
            temp.data = stack.pop().data;
            temp.next = null;
       // System.out.println(stack.remove(0).data);

    }

    private void printList() {
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+"|");
            temp = temp.next;
        }
    }

}