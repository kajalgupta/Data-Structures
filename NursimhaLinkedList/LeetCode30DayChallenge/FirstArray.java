package NursimhaLinkedList.LeetCode30DayChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FirstArray
 */
public class FirstArray {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        List<Integer> list = new ArrayList<>();
       // System.out.println(str.length);
        for (int i = 0; i < str.length; i++) {
            list.add(Integer.parseInt(str[i]));
        }
        int i = 0;
        int count = 0;
        //for (int i = 0; i < str.length; i++) {
            while (count<=str.length) {
            int k = list.get(i);
            count++;
            list.remove(i);
            if (list.contains(k)) {
                list.remove((Integer)k); 
                count++;               
            }
            else{
                System.out.println(k);
                break;
            }
            }
            
        }
    }
