package Competition.Hackerrank.Java;

import java.io.*;
import java.util.*;

public class StringTokens{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        if (s.length()>400000) {
            System.out.println();
        }
        else if (s.equals(" ")||s.equals("")) {
            System.out.println(0);
        }
        else{
       s = s.trim();
        String delims = "[ .,?!]+";  // delims = "\\W+"; 
        String[] tokens = s.split(delims);
        System.out.println(tokens.length);
        for(String s2: tokens){
            System.out.println(s2);
        } 
    }
        scan.close();
    }
}

