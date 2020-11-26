package GeeksForGeeks.HardProblems;

import java.util.*;
import java.io.*;

public class FindMedianInStream {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] median = new int[n];
        median = getMedian(arr);
        for (int d : median) {
            System.out.println(d);
        }
    }

    private static final PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());
    private static final PriorityQueue<Integer> highers = new PriorityQueue<>();

    private static int[] getMedian(int[] arr) {
        int[] median = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            // add this number to the heap
            addNumber(number);
            rebalance();
            median[i] = getMedianFromHeaps();
        }
        return median;
    }

    private static int getMedianFromHeaps() {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        if (biggerHeap.size() == smallerHeap.size()) {
            int num = (biggerHeap.peek() + smallerHeap.peek()) / 2;
            return num;
        } else {
            return biggerHeap.peek();
        }
    }

    private static void rebalance() {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static void addNumber(int number) {
        if (lowers.size() == 0 || number < lowers.peek()) {
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }

}
