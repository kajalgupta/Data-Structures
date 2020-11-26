package GeeksForGeeks.HardProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianInAStream {
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

    private static int[] getMedian(int[] arr) {
        /*
         * PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>()
         * {
         * 
         * @Override public int compare(Integer a, Integer b) { // TODO Auto-generated
         * method stub return -1*a.compareTo(b); } });
         */
        PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> highers = new PriorityQueue<>();
        int[] median = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            // add this number to the heap
            addNumber(number, lowers, highers);
            rebalance(lowers, highers);
            median[i] = getMedianFromHeaps(lowers, highers);
        }
        return median;
    }

    private static int getMedianFromHeaps(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        if (biggerHeap.size() == smallerHeap.size()) {
            int num = (biggerHeap.peek() + smallerHeap.peek()) / 2;
            return num;
        } else {
            return biggerHeap.peek();
        }
    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.size() == 0 || number < lowers.peek()) {
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }

}

/*  //BRUTE FORCE APPROACH - N^2
 * 
 * int n = Integer.parseInt(br.readLine()); int[] arr = new int[n]; int i = 0;
 * arr[0] = Integer.parseInt(br.readLine()); int elements = 1;
 * System.out.println(arr[0]); while (--n > 0) { int num =
 * Integer.parseInt(br.readLine()); //element to be inserted //insertion at
 * start if(num<arr[0]){ for (int j = elements-1; j >=0; j--) { arr[j+1] =
 * arr[j]; } arr[0] = num; } // insertion at end else if(num>arr[i]){ arr[i+1] =
 * num; } // insertion at middle else{
 * 
 * int k = 0; while (k<n && num>arr[k]) { k++; } int j=0; for ( j =
 * elements+1-2; j >=k; j--) { arr[j+1] = arr[j]; } arr[++j] = num;
 * 
 * } ++elements; if (elements % 2 == 0) { int median = (arr[elements / 2] +
 * arr[elements / 2 - 1]) / 2; System.out.println("median is"+median);
 * 
 * } else {
 * 
 * System.out.println("median"+arr[elements / 2]); } i++;
 * System.out.println("arr"+Arrays.toString(arr)); }
 * 
 * 
 */