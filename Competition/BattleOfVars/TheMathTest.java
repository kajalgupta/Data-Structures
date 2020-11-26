package Competition.BattleOfVars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TheMathTest {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i <n-1; i++) {
            list.add(i+1);
        }
        list.add(0);
        System.out.println(list.toString().replace("[", "").replace("]", "").replace(",", ""));
    }

}