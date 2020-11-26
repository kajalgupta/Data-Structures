package Competition.Hackerrank.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindTheMedian {
    public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); 
    String[] str = br.readLine().split("\\s+");
    int[] arr =new int[n];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(findMedian(arr));
    }
    static PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> uppers = new PriorityQueue<>();
   

    private static int findMedian(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            addNumber(arr[i]);
            rebalance();
        }
        return getMedian();
    }

    private static int getMedian() {
        if (lowers.size()==uppers.size()) {
            return (lowers.peek()+uppers.peek())/2;  //even no. elements
        }
        else if (lowers.size()>uppers.size()) {
            return lowers.peek();
        }
        else
        return uppers.peek();
    }

    private static void rebalance() {
        if (lowers.size()- uppers.size()>=2) {
            uppers.add(lowers.poll());
        }
        else if(uppers.size()-lowers.size()>=2){
            lowers.add(uppers.poll());
        }
    }

    private static void addNumber(int num) {
        if (lowers.size()==0 || num<lowers.peek()) {
            lowers.add(num);
        } else {
            uppers.add(num);
        }

    }
    
}