
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class First3 {
    static List<Integer> list1 = new ArrayList<Integer>();
    static List<Integer> list2 = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s+");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        int m =-1;
        int n = -1;
        if (x>y) {
            m = y;
            n = x;
            
        } else {
            m=x;
            n=y;    
        }
        if (m==n) {

            System.out.println(0);
            
        } else {
                int num1 = 0;
                list1.add(m);
            while (num1!=1) {
                num1 = list1.get(list1.size()-1);
                findDivisorsList1(num1);
               
            }
           // System.out.println("list1!!!"+list1.toString());
            
            int num2 = 0;
                list2.add(n);
            while (num2!=1) {
                num2 = list2.get(list2.size()-1);
                findDivisorsList2(num2);
               
            }

        //    System.out.println("list2!!!"+list2.toString());

          //small no.
       // findDivisorsList2(n);
        int length = -1;
        int index = -1;
        //int index1 = -1; 
        //System.out.println(list1.toString());
        //System.out.println("list2"+list2.toString());
        
        for (int i=0; i < list1.size() ;  i++) {
            //System.out.println("element is  "+list1.get(i));
           // System.out.println("i is"+i);
            length++;
            int element = list1.get(i);
            if (list2.contains(element)) {
                //System.out.println("yes");
                index = list2.indexOf(element);
               // index1 = i;
                break;
            }        
        }
        //length = list1.size()-index-1;
      //  System.out.println("length"+length);
       // System.out.println("index is"+index);
        int length2 = index;
      //  System.out.println("length2 is  " + length2);
        System.out.println(length+length2);
        }
        

    }

    static void findDivisorsList1(int n) {
        for (int i = n-1; i >0; i--)
            if (n % i == 0) {
                list1.add(i);
                break;
            }
    }

    static void findDivisorsList2(int n) {
        for (int i = n-1; i >0; i--)
            if (n % i == 0) {
                list2.add(i);
                break;
            }
    } 
}