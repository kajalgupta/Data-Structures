package Competition.Hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class GridSearch {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().trim().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);
            System.out.println(result);
           // bufferedWriter.write(result);
            //bufferedWriter.newLine();
        }

       // bufferedWriter.close();

        scanner.close();
    }

	private static String gridSearch(String[] g, String[] p) {
        int gridColumns = g[0].length();
        int patternColumns = p[0].length();
        int row = 0;
       // p[0].indexOf(str, fromIndex)
        int column = 0;
        boolean flag = false;
        boolean flag2 = false;
        
        int fromIndex = 0;
        int count = 0;
        //System.out.println("grid"+gridColumns);
        //System.out.println(" pattern" +patternColumns);
        int start = 0;
        int k=0;
        int storei = -1;
        boolean occurenceFlag = false;
        boolean decreaseOccurence = false;
        int totalOccurence = 0;
        List<Integer> list = new ArrayList<Integer>();
        //i <= g.length-p.length;
        for (int i = 0; i < g.length; i++)  {
            // System.out.println(i);
            // System.out.println("substring string is"+g[i].substring(start, start+patternColumns));
            // System.out.println(p[k]);
           // Pattern.compile(p[k]).matcher(g[i]).matches();  
           
           // if (flag && !g[i].substring(start, start+patternColumns).equals(p[k])) {
           /*
            if (flag && !Pattern.compile(p[k]).matcher(g[i].substring(start, start+patternColumns)).matches()) {
                k=0;
                flag = false;
                i = storei;
                System.out.println("i is"+i);
                
            }
            */
           // if (!list.isEmpty()) {
               if (flag2 && !list.isEmpty()) {
                int storedIndex = list.get(0);
                if (Pattern.compile(p[k]).matcher(g[i].substring(storedIndex, storedIndex+patternColumns)).matches()) {
                    k++;
                    System.out.println("--------"+k);
                }
                 else{
                     list.remove(0);
                     i = (list.isEmpty())?storei+1:storei;
                     flag = false;
                 }  
               }
                while (k<p.length && flag && !flag2 && !list.isEmpty()) {
                    int storedIndex = list.get(0);
                    System.out.println("stored index"+storedIndex);
                    System.out.println("stored index pattern col"+storedIndex+patternColumns);

                    System.out.println("k is"+k);
                    if (Pattern.compile(p[k]).matcher(g[i].substring(storedIndex, storedIndex+patternColumns)).matches()) {
                        k++;
                        flag2 = true;
                        break;
                    }
                    else list.remove(0);
                }
                if (flag==true && list.isEmpty()) {
                    i = storei+1;
                    k=0;
                    System.out.println("new i"+i);
                    flag = false;
                }
               
                    /*    
                    k=k-1;
                        while (k>=0) {
                            if (g[i].contains(p[k])) {
                                flag2 = true;
                                break;
                            }
                            else{
                                k--;
                            }
                        }
                }
                */
                
           
            /*
            if (flag &&  Pattern.compile(p[k]).matcher(g[i].substring(start, start+patternColumns)).matches()) {
                //System.out.println("string is"+g[i].substring(start, start+patternColumns));
                k++;
               // System.out.println(k);
            }
           
            if (occurenceFlag && !flag) {
                totalOccurence--;
                if(totalOccurence>0){
                start = g[i].indexOf(p[k], start+1);
                System.out.println("occurences = "+totalOccurence+"of"+p[k]+"starts from"+start);
                //System.out.println("");
                flag = true;
                k++;
                }
                else{
                    i = storei + 1;
                    flag = false;
                    k=0;
                }
            } 
            */  
            //k=0;
            if (flag==false && g[i].contains(p[k])) {   
               
                start = g[i].indexOf(p[k]);
                 fromIndex = start;
                 //list.add(fromIndex);
                 // totalOccurence = (g[i].split(p[k],-1).length)-1; 
                 count=0;

                  while ((fromIndex = g[i].indexOf(p[k], fromIndex)) != -1 ){
 
                    System.out.println("Found at index: " + fromIndex);
                    list.add(fromIndex);
                    count++;
                    fromIndex++;
                    
                }
              System.out.println("list is"+list);
                totalOccurence = count;
                  System.out.println("occurences = "+totalOccurence+"of"+p[k]+"pattern row"+k +"with grid row"+i+"at"+start);
                 occurenceFlag = (totalOccurence>1)?true:false;
                 //storei = (occurenceFlag)?i:i+1;
                 storei = i;
                 //System.out.println("start"+start);
                 //System.out.println(p[k]);
                 k++;
                flag = true;
            }
            
            if(k==p.length){
                return "YES";
            }
            
            if (i>=g.length-p.length && !flag) {
                return "NO";
            }
            

        }
            return "NO";
                  
	}
}
       // for (int i = 0; i < g.length-p.length; i++) {   
         //   for (int j = 0; j < gridColumns-patternColumns; j++) {
                // if (g[i].charAt(j)==p[row].charAt(column)) {
                //     column++;
                //     if(column==patternColumns-1 && row<p.length && column<p[0].length()){
                //         //System.out.println("term matched---"+p[row].charAt(column));
                //         flag = true;
                //         j =  j-patternColumns;
                //         row++;
                //         column = 0;
                //         System.out.println("term matched "+p[row].charAt(column));//+g[i].charAt(j));
                //     break;
                //     }
                // }
            /*
                I had a similar experience. My code passed all test cases. But, it failed on the following input:

4 6
123412
561212
123612
781234
2 2
12
34
1
5 15
111111111111111
111111111111111
111111011111111
111111111111111
111111111111111
3 5
11111
11111
11110

*/