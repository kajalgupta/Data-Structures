//For pRINTING fIRST noN Repeating Character

package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * QueueBasedApproach
 */
public class QueueBasedApproach {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            int n = Integer.parseInt(br.readLine());
            char[] str = br.readLine().toCharArray();
            int[] count = new int[27];
           // int flag =0;
            Queue<Character> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.add(str[i]);
                count[str[i]-'a']++;

                while (!queue.isEmpty()) {
                    if (count[queue.peek()-'a']>1) {
                        queue.remove();
                    }
                    else{
                        break;
                    }
                }
                /*if (queue.isEmpty()) {
                    flag =1;
                    //System.out.println(-1);
                }*/
            }
           
           if (queue.peek()==null) {
               System.out.println(-1);
           }
           else{
               System.out.println(queue.peek());
           }
        }
    }
}