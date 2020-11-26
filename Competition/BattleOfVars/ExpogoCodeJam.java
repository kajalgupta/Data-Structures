package Competition.BattleOfVars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExpogoCodeJam {
    static int dx = 0;
    static int dy = 0;
    static StringBuilder result;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String[] str = br.readLine().split("\\s+");
             dx = Integer.parseInt(str[0]);
             dy = Integer.parseInt(str[1]);
             
             StringBuilder value1 = calculate(0, 0, 'N', 1);
             StringBuilder value2 = calculate(0, 0, 'W', 1);
             StringBuilder value3 = calculate(0, 0, 'E', 1);
             StringBuilder value4 = calculate(0, 0, 'S', 1);
             List<String> strResList = new ArrayList<>();
             
             if(value1!= null) strResList.add(value1.toString());
             if(value2!= null) strResList.add(value2.toString());
             if(value3!= null) strResList.add(value3.toString());
             if(value4!= null) strResList.add(value4.toString());
             Comparator<String> byLength = new Comparator<String>(){
                @Override
                public int compare(String s1, String s2) {
                    //System.out.println("s1 is "+s1+"s2 is "+s2);
                    //System.out.println(s2.length() - s1.length());
                    return s2.length() - s1.length();
                }
            };
            if (strResList.isEmpty()) {
                System.out.println("Case #"+4+": IMPOSSIBLE");
            }
            else{
                Collections.sort(strResList, byLength);
                System.out.println(strResList.get(0));
            }
            
             
            
        }
    }

    private static StringBuilder calculate(int x, int y, char d, int i) {
        int steps = (int) Math.pow(2, i-1);
        if (d=='N') {
            y += steps;
            result.append("N", i-1, i);
           //result.insert(i-1, d);
           //result = result.substring(0, i)+ d+ result.substring(i);
        }
        if (d=='S') {
            y -= steps;
            result.append("S", i-1, i);
        }
        if (d=='W') {
            x -= steps;
            result.append("W", i-1, i);
        }
        if (d=='E') {
            x += steps;
            result.append("E", i-1, i);
        }
        if (x>dx || y>dy) {
            return null;
        }
        else if (x==dx || y==dy) {
            return result;
        }
        else{
            calculate(x, y, 'N', ++i);
            calculate(x, y, 'S', ++i);
            calculate(x, y, 'E', ++i);
            calculate(x, y, 'W', ++i);
            
        }
        return null;
    }

}