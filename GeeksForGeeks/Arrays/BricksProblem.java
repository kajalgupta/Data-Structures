package GeeksForGeeks.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BricksProblem {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().trim().split("\\s+");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < str.length; i++) {
                list.add(Integer.parseInt(str[i]));
            }
            List<Integer> remainningList = new ArrayList<>();
            int maxElement = 0;
            for (int i = 0; i < n; i++) {
                int element = list.get(0);
                list.remove(0);
                if (list.isEmpty()) {
                    maxElement = 0;
                } else {
                    maxElement = Collections.max(list);
                }

                if (element < maxElement) {
                    remainningList.add(element);
                    System.out.println("Not possible");
                } else {
                    remainningList.add(element);
                    // Collections.reverse(list);
                    Collections.sort(remainningList, Collections.reverseOrder());
                    // for (Integer integer : remainningList) {
                        int k = remainningList.size();
                    for (int j = 0; j < k ; j++) {
                        int integer = remainningList.get(0);
                        if (integer > maxElement) {
                            System.out.print(integer + " ");
                            remainningList.remove((Integer) integer);
                            
                        }
                    }
                    System.out.println();
                    // System.out.println(remainningList.toString().replace("[", "").replace("]",
                    // "").replace(",", ""));
                    // remainningList.clear();
                }

            }
        }
    }

}