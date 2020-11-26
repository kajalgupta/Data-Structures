package Competition.BattleOfVars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SwappingPartners {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int N = Integer.parseInt(str[0]);
        int S = Integer.parseInt(str[1]);
        String[] str1 = br.readLine().split("\\s+");
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < str1.length; i++) {
            list1.add(Integer.parseInt(str1[i]));
        }
        String[] str2 = br.readLine().split("\\s+");
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < str2.length; i++) {
            list2.add(Integer.parseInt(str2[i]));
        }
        String[] str3 = br.readLine().split("\\s+");
        List<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < str3.length; i++) {
            list3.add(Integer.parseInt(str3[i]));
        }
        int swaps = 0;
        int length1 = list1.size();
        int length2 = list2.size();
        int length3 = list3.size();
        List<Integer> smallList = new ArrayList<>();
        List<Integer> compareList = new ArrayList<>();      
        smallList = (length2<length3)?list2:list3;
        compareList = (smallList==list2) ? list3: list2;
        int decrease = 0;
        int count = 0;
        for (int i = 0; i < smallList.size(); i++) {
            if (compareList.contains(smallList.get(i))) {
                decrease++;
            } else {
                count++;
            }
        }
        if (count>0) {
            swaps += compareList.size() - decrease;
        }
        smallList.clear();
        compareList.clear();

        smallList = (length1<=length3)?list1:list3;
        compareList = (smallList==list1) ? list3: list1;
         decrease = 0;
        count = 0;
        for (int i = 0; i < smallList.size(); i++) {
            if (compareList.contains(smallList.get(i))) {
                decrease++;
            } else {
                count++;
            }
        }
        if (count>0) {
            swaps += compareList.size() - decrease;
        }
        smallList.clear();
        compareList.clear();

        smallList = (length1<=length2)?list1:list2;
        compareList = (smallList==list1) ? list2: list1;
         decrease = 0;
        count = 0;
        for (int i = 0; i < smallList.size(); i++) {
            if (compareList.contains(smallList.get(i))) {
                decrease++;
            } else {
                count++;
            }
        }
        if (count>0) {
            swaps += compareList.size() - decrease;
        }

        System.out.println(swaps);
    }

}