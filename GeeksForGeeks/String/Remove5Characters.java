package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Remove5Characters
 */
public class Remove5Characters {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            removeChar(br.readLine(), br.readLine());
        }
    }

    private static void removeChar(String readLine, String readLine2) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < readLine.length(); i++) {
            list.add(readLine.charAt(i));
        }
          List<Character> list2 = new ArrayList<>();
        for (int i = 0; i < readLine2.length(); i++) {
            list2.add(readLine2.charAt(i));
        }
        
        for (int i = 0; i < readLine2.length(); i++) {
            if (list.contains(readLine2.charAt(i))) {
                list.remove((Character)readLine2.charAt(i));
                while (list.contains(readLine2.charAt(i))) {
                    list.remove((Character)readLine2.charAt(i));
                }
                while (list2.contains(readLine2.charAt(i))) {
                    list2.remove((Character)readLine2.charAt(i));
                }

            }
        }
        if (list.isEmpty() && list2.isEmpty()) {
            System.out.println(-1);
        }
        else{
            StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        for (int i = 0; i < list2.size(); i++) {
            sb.append(list2.get(i));
        }
        System.out.println(sb.toString());
        }
        
       //sb.append(list.toString().replaceAll("[", "").replaceAll("]", "").replaceAll(",", "").replaceAll(" ", ""));
       //sb.append(list2.toString().replaceAll("[", "").replaceAll("]", "").replaceAll(",", "").replaceAll(" ", ""));
       
       //( + list2.toString().replaceAll("[", "").replaceAll("]", "").replaceAll(",", "").replaceAll(" ", ""));
        //String s = (list.toString() + list2.toString()).replaceAll("[", "").replaceAll("]", "").replaceAll(",", "").replaceAll(" ", "");
        
    }
}