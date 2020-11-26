package GeeksForGeeks.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * RotateLinkedList
 */
public class RotateLinkedList {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("\\s+");
            int k = Integer.parseInt(br.readLine());
            for (int i = 1; i < str.length; i++) {
                addToTheLastNode();
            }
        }
    }

    private static void addToTheLastNode() {
    }
}

/**
 * Node
 */
 class Node {
    int data;
    Node next;
    Node(int d){
        data = d;
    }
    
}