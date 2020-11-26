package Competition.Hackerrank.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ChocolateFeast {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String[] str = br.readLine().split("\\s+");
            int n = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int m = Integer.parseInt(str[2]);
            int wrappers = n/c;
            System.out.println("first wrappers"+wrappers);
            int w = wrappers;
            while (w>=m) {
                wrappers += w/m;
                System.out.println("next"+w/m);
                w = (w-m*(w/m))+w/m;
            }
            System.out.println(wrappers);
        } 
    }
    
}