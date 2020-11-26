package GeeksForGeeks.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class nthNodefromLinkedList {
    static Node head;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String[] str = br.readLine().split("\\s+");
            int totalNumberOfNodes = Integer.parseInt(str[0]); 
            int n = Integer.parseInt(str[1]);
            String[] str2 = br.readLine().split("\\s+");
             head = null;
             addToTheLastNode(new Node(Integer.parseInt(str2[0])));
            for (int i = 1; i < str2.length; i++) {
                addToTheLastNode(new Node(Integer.parseInt(str2[i])));
            }
            
           System.out.println(getNthNodeFromLast(head, n));
           System.out.println(getNthNodeFromLastUsingExtraSpace(head, n));
           System.out.println("Most eficient approach"+getNthNodeFromLastInOneScan(head, n));
        }
    }

    private static int getNthNodeFromLastInOneScan(Node head, int n) {
        Node ptrTemp = head;
        Node ptrNthNode = null;
        int k =1;
        while (k++<n && ptrTemp != null) {
            ptrTemp = ptrTemp.next;
        }
        while (ptrTemp != null){
            if(ptrNthNode == null) ptrNthNode = head;
            else ptrNthNode = ptrNthNode.next;
            ptrTemp = ptrTemp.next;
            System.out.println("nth node data"+ptrNthNode.data);
        }
        
        if(ptrNthNode!=null) return ptrNthNode.data;
        return -1;
    }   

    private static int getNthNodeFromLastUsingExtraSpace(Node head2, int n) {
        HashMap<Integer, Node> map = new HashMap<>();
        Node temp = head;
        int k =1;
        while (temp!=null) {
            map.put(k++, temp);
            temp = temp.next;
        }
        if(n>map.size()) return -1;
        int startNode = map.size()-n+1;
        return map.get(startNode).data;
    }

    private static int getNthNodeFromLast(Node head2, int n) {
        int length = 0;
        Node temp = head;
        while (temp!=null) {
            length++;
            //System.out.println(length);
            temp = temp.next;
        }
        if (n>length) return -1;
        temp = head;
        int startNode =  length - n+1;
        while (startNode-->1) {
            temp = temp.next;
        }
        return temp.data;

    }


    private static void addToTheLastNode(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

}