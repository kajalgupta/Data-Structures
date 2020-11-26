package GeeksForGeeks.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Merge2SortedLinkedList {
     Node head;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String[] str = br.readLine().split("\\s+");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            String[] str1 = br.readLine().split("\\s+");
            String[] str2 = br.readLine().split("\\s+");
            System.out.println("-----");
            Merge2SortedLinkedList list1 = new Merge2SortedLinkedList();
            Node head =  new Node(Integer.parseInt(str1[0]));
          // list1.head =  new Node(Integer.parseInt(str1[0]));
           list1.addTotheLastNode(head);
           System.out.println("-----");
            for (int i = 1; i < n; i++) {
               // System.out.println("--[[[[---");
               list1.addTotheLastNode(new Node(Integer.parseInt(str1[i])));
              // System.out.println("--[[[[---");
            }
            System.out.println("-----");
          //  printlist(list1.head);
            //head2 =  addTotheLastNode(new Node(Integer.parseInt(str2[0])));
            Merge2SortedLinkedList list2 = new Merge2SortedLinkedList();
            Node head2 =  new Node(Integer.parseInt(str2[0]));
            list2.addTotheLastNode(head2);
            list2.head = head2;
             for (int i = 1; i < m; i++) {
                list2.addTotheLastNode(new Node(Integer.parseInt(str2[i])));
             }
            printlist(list1.head);
            printlist(list2.head);
            //UNION OF TWO UNSORTED LINKED LIST
            Node intersectionHead = findIntersection(list1.head, list2.head);
            printlist(intersectionHead);
            Node unionHead = findUnion(list1.head, list2.head);
            System.out.println("--------------");
            printlist(unionHead);
            System.out.println("--------");
           Node node =  addTwoLists(list1.head, list2.head);
          // System.out.println(node.data);
           printlist(node);
        //    sortedMerge(head1, head2);
        }
        
    }

    private static Node findIntersection(Node head1, Node head2) {
        Node sortedHead1 = mergeSort(head1);
        Node sortedHead2 = mergeSort(head2);
        return intersection(sortedHead1, sortedHead2);
    }

    private static Node intersection(Node sortedHead1, Node sortedHead2) {
        Node start = new Node(0);
        Node traverse = start;
        while (sortedHead1!=null && sortedHead2!=null) {
            if (sortedHead1.data<sortedHead2.data) {
                sortedHead1 = sortedHead1.next;
                continue;
            }
            else if (sortedHead1.data>sortedHead2.data) {
                sortedHead2 = sortedHead2.next;
                continue;
            }
            else{
                traverse.next = sortedHead1;
                traverse = traverse.next;
                sortedHead1=sortedHead1.next;
                sortedHead2 = sortedHead2.next;
            }
        }
        return start.next;
    }

    private static Node findUnion(Node head1, Node head2) {
        System.out.println("[][][]");
        printlist(head1);
        printlist(head2);
        Node sortedHead1 = mergeSort(head1);
        Node sortedHead2 = mergeSort(head2);
        System.out.println("~~~~`~~~~");
        printlist(sortedHead1);
        System.out.println();
        printlist(sortedHead2);
        System.out.println("~~~~~~~~~~~~~~~~");
        //union
      // return union(sortedHead1,sortedHead2);
      Node unionhead = union(sortedHead1, sortedHead2);
      return removeDuplicates(unionhead);
    }

    private static Node removeDuplicates(Node unionhead) {
        Node current = unionhead;
        while (current!= null &&current.next!=null) {
            while (current.next!=null&&current.data == current.next.data) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        return unionhead;
    }

    private static Node union(Node sortedHead1, Node sortedHead2) {
        Node extra = new Node(0);
        Node traverse = extra ;
        while (sortedHead1!=null && sortedHead2!= null) {   
            if (sortedHead1.data==sortedHead2.data) {
                traverse.next = sortedHead1;
                sortedHead1 = sortedHead1.next;
                sortedHead2 = sortedHead2.next;
                traverse = traverse.next;
                continue;
            }
            if (sortedHead1.data<sortedHead2.data) {
                if(sortedHead1.data==traverse.data){
                    sortedHead1 = sortedHead1.next;
                    continue;
                }
                traverse.next = sortedHead1;
                sortedHead1 = sortedHead1.next;
                traverse = traverse.next;
            }
            else{
                if(sortedHead2.data==traverse.data){
                    sortedHead2 = sortedHead2.next;
                    continue;
                }
                traverse.next = sortedHead2;
                sortedHead2 = sortedHead2.next;
                traverse = traverse.next;
            }
            
        }
        if (sortedHead1!=null) {
            traverse.next = sortedHead1;
        }
        if (sortedHead2!=null) {
            traverse.next = sortedHead2;
        }

        return extra.next;
    }
    private static Node mergeSort(Node head) {

        if (head==null || head.next==null) {
            return head;
        }
        Node temp = head;
        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
            
        }
        Node right = null;
        if (fast==null) {
            temp.next = null;
            right = slow;
        } else {
            right = slow.next;
            slow.next = null;
        }
        Node leftSide = mergeSort(head);
        Node rightSide = mergeSort(right);

        return merge(leftSide,rightSide);
    }

    private static Node merge(Node left, Node right) {
        Node extra = new Node(0);
        Node traverse  = extra;
        while (left!=null && right!=null) {
            if (left.data < right.data) {
                traverse.next = left;
                left = left.next;
            } else {
                traverse.next = right;
                right = right.next;
            }
            traverse = traverse.next;
        }
        if (right!=null) {
            traverse.next = right;
            right = right.next;
        }
        if (left != null) {
            traverse.next = left;
            left = left.next;
        }

        return extra.next;
    }
/*
    private static Node mergeSort(Node head) {
        if (head==null || head.next==null) {
            return head;
        }
        Node temp = null;
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        Node right = slow;
        Node leftSide =  mergeSort(head);
        Node rightSide = mergeSort(right);
        return merge(leftSide, rightSide);
        
    }

    private static Node merge(Node left, Node right) {
        Node extra = new Node(0);
        Node traverse = extra;
        while (left!=null && right != null) {
            if (left.data<right.data) {
                traverse.next = left;
                left = left.next;
                traverse = traverse.next;
            }
            else{
                traverse.next = right;
                right = right.next;
                traverse = traverse.next;
            }
        }
        if (left!=null) {
            traverse.next = left;
            left = left.next;
        }
        if (right!=null) {
            traverse.next = left;
            right = right.next;
        }
        
     return extra.next;  
    }
*/
    private static void printlist(Node head) {
        Node headNode = head;
        while (headNode != null) {
            System.out.print(headNode.data + " ");
            headNode = headNode.next;
        }
        System.out.println();
    }

    private static Node addTwoLists(Node first, Node second) {
        Node firstReverse = reverseLinkedList(first);
        Node secondReverse = reverseLinkedList(second);
       
        int sum = firstReverse.data + secondReverse.data;
        int carry = sum/10;
        int unit = sum % 10;
        Node sumHead = new Node(unit);

        Node previous = sumHead;
        //int carry = 0;
        while (firstReverse!= null && secondReverse != null) {
             sum = carry + firstReverse.data + secondReverse.data;
            carry = sum/10;     
            unit = sum % 10;
            Node current = new Node(unit);
            //temp.data = unit;
            previous.next = current;
           // System.out.println(temp.data);
            //temp = temp.next;
           // System.out.println(temp.data);
            firstReverse = firstReverse.next;
            secondReverse = secondReverse.next;
            previous = current;
            
        }
        while (firstReverse!=null) {
             sum = carry + firstReverse.data ;
            carry = sum/10;
             unit = sum % 10;
             Node current = new Node(unit);
            //temp.data = unit;
            //temp = temp.next;
            previous.next = current;
            firstReverse = firstReverse.next;
        }
        while (secondReverse!=null) {
             sum = carry + secondReverse.data ;
            carry = sum/10;
             unit = sum % 10;
             Node current = new Node(unit);
            //temp.data = unit;
            //temp = temp.next;
            previous.next = current;
            secondReverse = secondReverse.next;
        }
        
        return sumHead;


    }

    private static Node sortedMerge(Node headA, Node headB) {  //with extra space
        if(headA==null && headB != null) return headB;
        else if(headB==null && headA!= null) return headA;
        //Node head = headA.data<headB.data ? headA : headB;
        Node head = new Node(0);
        if (headA.data <= headB.data) {
            head = headA;
            head.next = sortedMerge(headA.next, headB);
        }
        else{
            head = headB;
            head.next = sortedMerge(headA, headB.next);
        
        }
        return head;
        /*
        Node prev = null;
        Node temp = null;
        while (headA!=null && headB!=null) {
            if (headA.data <= headB.data) {
                prev = headA;
                headA = headA.next;
            }
            else{
                if (prev!=null) 
                    prev.next = headB;
                temp = headB.next;
                headB.next = headA;
                prev = headB;
                headB = temp;
            }
        } 
        */
    }

    /*
     * private static Node sortedMerge(Node headA, Node headB) { Node reverseHeadA =
     * reverseLinkedList(headA); Node reverseHeadB = reverseLinkedList(headB); Node
     * temp2 = reverseHeadB; int swapValue = 0; while (temp2.next!=null){ if
     * (reverseHeadA.data > temp2.data) { swapValue = reverseHeadA.data;
     * reverseHeadA.data = temp2.data; temp2.data = swapValue; temp2 = temp2.next;
     * Node temp3 = reverseHeadA; while (temp3!=null && temp3.next.data>temp3.data)
     * { ///swap swapValue = temp3.data; temp3.data = temp3.next.data; temp3 =
     * temp3.next; } }
     * 
     * } Node newHeadA = reverseLinkedList(reverseHeadA); Node newHeadB =
     * reverseLinkedList(reverseHeadB); Node temp1 = newHeadA; while
     * (temp1.next!=null) { temp1 = temp1.next; } temp1.next = newHeadB; return
     * newHeadA;
     * 
     * }
     */
    private static Node reverseLinkedList(Node headNode) {
        Node previous = null;
        Node current = headNode;
        Node next = null;
        while (current!=null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private  void addTotheLastNode(Node node) {
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

       // return null;
    }

}