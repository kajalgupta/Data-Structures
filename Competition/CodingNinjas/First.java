package CodingNinjas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class First {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            char[] input = br.readLine().toCharArray();
            int length = input.length;
            int[] count = new int[26];
            for (char c : input) {
                count[c-97]++;
            }
            int maxOccurence = 0;
            int maxPosition = 0;
            int i = 0;
            int visit = 0;
            for (; i < count.length; i++) {
                if (count[i]>maxOccurence) {
                    maxPosition = i;
                    maxOccurence = count[i];
                }
                visit += count[i];
                if (visit==length) {
                    break;
                }
            }
            maxPosition+=97;
           // System.out.println(maxPosition);
           // System.out.println(maxPosition+"----");
            //System.out.println(maxOccurence+";;;;");
            StringBuilder sb = new StringBuilder("");
            char ch = (char)maxPosition;
            //char ch4 = (char)97;
           // System.out.println(ch4);
            // System.out.println("f"+ch2);
            // char ch =  (char)(i+'0');   //Character.toChars(97+i);
            //System.out.println("===="+ch);
            //char ch3 = Integer.toString(i).charAt(0);
            //System.out.println(ch3+"-------------------");
            for (int k = 0; k < maxOccurence; k++) {
                sb.append(ch);
            }
            System.out.println(sb.toString());
        }
        
    }
}