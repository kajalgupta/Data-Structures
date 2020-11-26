package Competition.Hackerrank.Medium;

import java.util.Scanner;

public class TimeInWords {
    public static void main(String[] args) {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner (System.in);
        int  h = sc.nextInt();
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int m = sc.nextInt();
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        timeInWords(h, m);
        sc.close();
    }

    private static void timeInWords(int h, int m) {
        String[] arr = {"zero", 
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten",
        "eleven",
        "twelve",
        "thirteen",
        "fourteen",
        "fifteen",
        "sixteen",
        "seventeen",
        "eighteen",
        "nineteen",
        "twenty",
        "twenty one",
        "twenty two",
        "twenty three",
        "twenty four",
        "twenty five",
        "twenty six",
        "twenty seven",
        "twenty eight",
        "twenty nine"
 };
        System.out.println(String.valueOf(h));
        if(m==0){
            System.out.println(h +" o' clock");
        }
        
        else if (m<30) {
            if(m==15) System.out.println("quarter past "+arr[h]);
            else
            System.out.println(arr[m]+(m==1?" minute":" minutes")+" past "+arr[h]);
        }   
        else{
            if(m==45) System.out.println("quarter to "+arr[h]);
            else{
            int restMin = 60-m;
            if(restMin == 30) 
            System.out.println("quarter to " +arr[h+1]);
            System.out.println(arr[restMin]+" minutes"+" to "+arr[h]);
            }
        }     
    }
    
}