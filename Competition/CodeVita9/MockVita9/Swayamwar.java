package CodeVita9.MockVita9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Swayamwar {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String str2 = br.readLine();
        //.split("\\s+");
        System.out.println(swayamwar(str, str2, n));
    }
    
    private static int swayamwar(String str, String str2, int n) {

        //Queue<Character> bride = new LinkedList<>();
        char[] bride = str.toCharArray();
    
        Queue<Character> groom = new LinkedList<>();
         for(int i=0; i<n; i++){
            groom.add(str2.charAt(i));
         }
       //System.out.println(bride.peek());
       int count = 0;
      // while (bride.peek()!=null) {
          for (int i = 0; i < n; ) {
              
          
           char dulhan =  bride[i]; // bride.peek();
           if (groom.peek()==dulhan) {
               groom.remove();
               //bride.remove();
               i++;
               count = 0;
           } else {
               groom.add(groom.remove());
                count++;
                if (count==groom.size()) {
                    return groom.size();
                }
           }
       }



        return 0;
    }

    // private static int swayamwar(String[] str, int n) {

    //     Queue<Character> bride = new LinkedList<>();
    //     Queue<Character> groom = new LinkedList<>();
        
    //     for(int i=0; i<n; i++){
    //         bride.add(str[0].charAt(i));
    //      }
    //      for(int i=0; i<n; i++){
    //         groom.add(str[1].charAt(i));
    //      }
    //    //System.out.println(bride.peek());
    //    int count = 0;
    //    while (bride.peek()!=null) {
    //        char dulhan = bride.peek();
    //        if (groom.peek()==dulhan) {
    //            groom.remove();
    //            bride.remove();
    //            count = 0;
    //        } else {
    //            groom.add(groom.remove());
    //             count++;
    //             if (count==bride.size()) {
    //                 return bride.size();
    //             }
    //        }
    //    }



    //     return 0;
    // }
    
}
/*abstract

4
rrmm mrmr

*/