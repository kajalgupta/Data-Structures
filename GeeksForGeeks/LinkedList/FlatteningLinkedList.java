package GeeksForGeeks.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlatteningLinkedList {
    //private static int totalElements;
     Node2 head;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FlatteningLinkedList linkedList = new FlatteningLinkedList();
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
            int numberOfBottomNodes = Integer.parseInt(br.readLine());
            String[] strHead = br.readLine().split("\\s+");
            int[] arr = new int[numberOfBottomNodes];
            int totalElements = 0;
            for (int i = 0; i < numberOfBottomNodes; i++) {
                arr[i] = Integer.parseInt(strHead[i]);
                totalElements += arr[i];
            }
            String[] str = br.readLine().split("\\s+");
            int[] arr2 = new int[totalElements];
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = Integer.parseInt(str[i]);
            }
            Node2 temp = null;
            Node2 tempB = null;
            Node2 pre = null;
            Node2 preB = null;
            //Node2 extra = head;

            int flag = 1;
            int flag1 = 1;
            int strSize = 0;
            for (int i = 0; i < arr.length; i++) {
                int k = arr[i];
                k--;
                temp = new Node2(arr2[strSize++]);
                if (flag == 1) {
                    linkedList.head = temp;
                    pre = temp;
                    flag = 0;
                    flag1 = 1;
                } else {
                    pre.next = temp;
                    pre = temp;
                    flag1 = 1;
                }
                for (int j = 0; j < k; j++) {
                    int a = arr2[strSize++];
                    tempB = new Node2(a);
                    if (flag1 == 1) {
                        temp.bottom = tempB;
                        preB = tempB;
                        flag1 = 0;

                    } else {
                        preB.bottom = tempB;
                        preB = tempB;
                    }

                }
            }
            Node2 root = flatten(linkedList.head);
            linkedList.printList(root);

        }
    }

    private void printList(Node2 node) {
        while (node != null) {
            System.out.print("node data is"+node.data);
            node = node.bottom;
        }
        System.out.println();

    }

    private static Node2 flatten(Node2 head2) {
        List<Integer> list = new ArrayList<>();
        Node2 temp = head2;
        Node2 temp2 = null;
        while (temp != null) {
            list.add(temp.data);
             temp2 = temp.bottom;
            while (temp2 != null) {
                list.add(temp2.data);
                temp2 = temp2.bottom;
            }
            temp = temp.next;
        }
        
        Node2 tempHead = head2;
        Collections.sort(list);
        System.out.println("list is "+list);
        int i = 0;
        temp = head2;
        while (temp != null ) {
            System.out.println("i is"+i);
            //if (i<list.size()) {
                temp.data = list.get(i++);
           // }
            
            System.out.println("temp data"+temp.data);
            System.out.println("index"+i);
            temp = temp.bottom;
            System.out.println("bottom is"+temp.data);

            if (temp.bottom == null && i<list.size()) {
                System.out.println("i is"+i);
                temp.data = list.get(i++);
                System.out.println("temp data of lastHeadlist"+temp.data);
                temp.bottom = tempHead.next;
             //   System.out.println("temp bottom 's next is"+temp.bottom.data);
                //temp = tempHead.next;
                temp = temp.bottom;
                tempHead = tempHead.next;
                //System.out.println("tempheads are"+temp.data);
            }
            // if(i<list.size()){
            //     temp.data = list.get(i++);
            //     System.out.println("temp.data i is"+temp.data+ i);
            // }
            
        }

        return head2;
    }

}

class Node2 {
    int data;
    Node2 next;
    Node2 bottom;

    Node2(int data) {
        this.data = data;
        next = null;
        bottom = null;
    }
}