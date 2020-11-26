package Competition.BattleOfVars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.LinkedHashMap;

public class WhereIsTheAttack {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
            String str = br.readLine();
            int dcount = 0, ocount = 0, pcount = 0, ecount = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i)=='D') {
                    dcount++;
                }
                else if (str.charAt(i)=='O') {
                    ocount++;
                }
               else if (str.charAt(i)=='P') {
                    pcount++;
                }
                else if (str.charAt(i)=='E') {
                    ecount++;
                }
            }
            System.out.println(dcount+" "+ocount+" "+pcount+" "+ecount);
            /*
            LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }
            else{
                map.put(str.charAt(i), 1);
            }
        }
        map.forEach((K,V) -> System.out.print(V+" "));
        int size = map.size();
        
        while(size!=4) {
                System.out.print(0+" ");
                size++;
            }
        */
    }

}
    