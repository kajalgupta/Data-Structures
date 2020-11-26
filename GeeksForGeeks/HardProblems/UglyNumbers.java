package GeeksForGeeks.HardProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class UglyNumbers {
    public static void main(String[] args) throws IOException {
        // code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Long> ugly = new ArrayList<>();
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        boolean flag = true;
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
            int nth = Integer.parseInt(br.readLine().trim());
            if (flag) {
                flag = false;
                ugly.add(Long.parseLong("1"));
                set.add(Long.parseLong("1"));
                int n = 10001;
                // ugly[0] = 1;
                int ptr5 = 0, ptr2 = 0, ptr3 = 0;
                long num2, num3, num5, minNumber;
                for (int i = 1; i < n; i++) {
                    num2 = ugly.get(ptr2) * 2;
                    num3 = ugly.get(ptr3) * 3;
                    num5 = ugly.get(ptr5) * 5;
                    if (set.add(num2)) {
                        priorityQueue.add(num2);
                    }
                    if (set.add(num3)) {
                        priorityQueue.add(num3);
                        // System.out.println("This num belongs to 3group"+num3);
                    }
                    if (set.add(num5)) {
                        priorityQueue.add(num5);
                        // System.out.println("This num belongs to 5group"+num5);
                    }
                    minNumber = priorityQueue.poll();
                    // System.out.println("min number is"+minNumber);
                    ugly.add(minNumber);
                    if (minNumber == num2)
                        ptr2++;
                    if (minNumber == num3)
                        ptr3++;
                    if (minNumber == num5)
                        ptr5++;
                    // System.out.println("ptr values ptr2 " + ptr2 + " ptr3 is " + ptr3 + " ptr5 is
                    // " + ptr5);
                }
                // System.out.println("priority queue is"+priorityQueue);
            }
            // System.out.println(ugly+" ugly is");
            System.out.println(ugly.get(nth - 1));
        }

    }

}