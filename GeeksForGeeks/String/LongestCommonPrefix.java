package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
import java.util.List;

/**
 * LongestCommonPrefix
 */
public class LongestCommonPrefix {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            int n = Integer.parseInt(br.readLine()); 
            String[] arr = br.readLine().split(" ");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
            
            //Collections.sort(list, ((x,y)->x.length()>y.length()?1:-1));
            list.sort((first, second)-> Integer.compare(first.length(), second.length()));
            System.out.println(list);
            int length = list.get(0).length();
            int flag=0, last=length-1;
            if(length==1){
                String str = list.get(0);
                for (int j = 1; j < arr.length; j++){
                    if (!str.equals(list.get(j).substring(0,1))) {
                        flag = 1;
                    }
                }
                if(flag==1) System.out.println(-1);
                else System.out.println(str);
            }
            else{
                for (int i = 1; i <length; i++) {
                    String str = list.get(0).substring(0, i+1);
                    for (int j = 1; j < arr.length; j++) {
                        if(!str.equals(list.get(j).substring(0,i+1))){
                            flag = 1;
                            last = i-1;
                            System.out.println(str);
                            break;
                        }
                     }
                     if (flag==1) {
                         break;   
                    }
    
                }
                if(last==0)
                System.out.println("-1");
                else
                System.out.println(list.get(0).substring(0,last+1));
            }
            }
         
    }
}