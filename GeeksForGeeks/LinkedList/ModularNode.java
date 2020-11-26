package GeeksForGeeks.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ModularNode {
    Node head;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("\\s+");
            Node head = new Node(Integer.parseInt(str[0]));
            Node extra = head;
            System.out.println("----" +extra.data);
            System.out.println("((("+extra.next);
            ModularNode list = new ModularNode();
            list.addToTheLast(head);
            for (int i = 1; i < str.length; i++) {
                list.addToTheLast(new Node(Integer.parseInt(str[i])));
            }
            int k = Integer.parseInt(br.readLine());
            System.out.println(modularNode(head, k)); 
            Node reArrangedHead = rearrange(head);
            printList(reArrangedHead);
            System.out.println(" -----" +reArrangedHead.data);
        }
    }

    public static void printList(Node temp) {
        while (temp!=null) {
            System.out.print(temp.data+"|");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node rearrange(Node head) {
        Node odd = head;
        Node even = head.next;
        if(even==null)
        return head;
        Node temp = even.next;
        //boolean flag = false;
        Node evenHead =  even;
        while (temp!=null) {
            odd.next = temp;
            //System.out.println(temp.data);
            even.next = temp.next;
            
            odd = odd.next;
            even = even.next;
            if(temp.next != null) temp = temp.next.next;
            else temp = temp.next;
        }
       // even.next = null;
       odd.next = evenHead;
        return head;
    }

    private void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next!=null) {
                temp = temp.next;
            }
            temp.next = node;
            
        }
    }

    private static int modularNode(Node head, int k) {
        Node temp = head;
        int count=1;
        int res = 0;
        while (temp!=null) {
            if (count%k==0) {
                res = temp.data;
            }
            temp = temp.next;
            count++;
        }
        if(res==0) return -1;
        else return res;
    }
}