package Competition.CodeVita9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PaperGeneration {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine()); 
        int s = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());  
        int m = Integer.parseInt(br.readLine()); 
        int z = Integer.parseInt(br.readLine()); 
        int c = Integer.parseInt(br.readLine()); 
        String[] str = br.readLine().split("\\s+");
        char n = (char) br.read();
        String s1 = "";
        for (String string : str) {
            s1 += string;
        }
        char[] charArray = s1.toCharArray();
        //char b = str[1]; 
        int totalChar = x+y+z;
        

       }
       static int factorial(int k){          
           
           if (k==0) {
               return 1;
           }
           return k*factorial(--k);

       }
    
}