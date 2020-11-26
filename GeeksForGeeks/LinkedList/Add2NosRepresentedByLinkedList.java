package GeeksForGeeks.LinkedList;

import java.util.Scanner;

public class Add2NosRepresentedByLinkedList {
    Node head;
    void printList(Node head){
        while (head != null) {
            System.out.println(head.data+" ");
            head = head.next;
        }
    }
    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while (t>0) {
            int n1 = sc.nextInt();
            Add2NosRepresentedByLinkedList list1 = new Add2NosRepresentedByLinkedList();
            for (int i = 1; i <= n1; i++) {
                int a = sc.nextInt();
                list1.push(a);
            }
            int n2 = sc.nextInt();
            Add2NosRepresentedByLinkedList list2 = new Add2NosRepresentedByLinkedList();
            for (int i = 0; i < n2; i++) {
                int a = sc.nextInt();
                list2.push(a);
            }
            list1.printList(head);
            // Add2NosRepresentedByLinkedList list3 = new Add2NosRepresentedByLinkedList();
            // Node resultHead = addTwoLists(list1.head,list2.head);
            // list2.printList(resultHead);
            System.out.println();
            t--;
        }
    }
    
    // private static Node addTwoLists(Node first, Node second) {
    //     Node firstReverse = reverseLinkedList(first);
    //     Node secondReverse = reverseLinkedList(second);
       
    //     int sum = firstReverse.data + secondReverse.data;
    //     int carry = sum/10;
    //     int unit = sum % 10;
    //     Node sumHead = new Node(unit);

    //     Node previous = sumHead;
    //     //int carry = 0;
    //     while (firstReverse!= null && secondReverse != null) {
    //          sum = carry + firstReverse.data + secondReverse.data;
    //         carry = sum/10;     
    //         unit = sum % 10;
    //         Node current = new Node(unit);
    //         //temp.data = unit;
    //         previous.next = current;
    //        // System.out.println(temp.data);
    //         //temp = temp.next;
    //        // System.out.println(temp.data);
    //         firstReverse = firstReverse.next;
    //         secondReverse = secondReverse.next;
    //         previous = current;
            
    //     }
    //     while (firstReverse!=null) {
    //          sum = carry + firstReverse.data ;
    //         carry = sum/10;
    //          unit = sum % 10;
    //          Node current = new Node(unit);
    //         //temp.data = unit;
    //         //temp = temp.next;
    //         previous.next = current;
    //         firstReverse = firstReverse.next;
    //     }
    //     while (secondReverse!=null) {
    //          sum = carry + secondReverse.data ;
    //         carry = sum/10;
    //          unit = sum % 10;
    //          Node current = new Node(unit);
    //         //temp.data = unit;
    //         //temp = temp.next;
    //         previous.next = current;
    //         secondReverse = secondReverse.next;
    //     }
        
    //     return sumHead;


    // }

}