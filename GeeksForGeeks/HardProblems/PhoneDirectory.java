package GeeksForGeeks.HardProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneDirectory {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            //int n  = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("\\s+");
            /*
            HashSet<String> set = new HashSet<>();
            for (String string : str) {
                set.add(string);
            }
            */
            String pattern = br.readLine();
           // String[] arr = new String[set.size()];
            //matchPhoneDirectory(set.toArray(arr), pattern);
            matchPhoneDirectory(str, pattern);
            
        }
    }

    private static void matchPhoneDirectory(String[] str, String pattern) {
        int i=0;
        for ( i = 0; i < pattern.length(); i++) {
            List<String> list = new ArrayList<String>();
            for (int j = 0; j < str.length; j++) {
                if((str[j].length()>i)&& (str[j].substring(0, i+1).equals(pattern.substring(0, i+1)))){
                    list.add(str[j]);
                }
            }
            if (list.isEmpty()) {
                break;
            }
            
            else{
                   Collections.sort(list);
                List<String> listUnique = list.stream().distinct().collect(Collectors.toList());
            System.out.println(listUnique.toString().replace(",","").replace("[","").replace("]",""));
          
             
                //System.out.println(list.toString().replace(",","").replace("[","").replace("]",""));
            }         
        }
        while (i<pattern.length()) {
            System.out.println(0);
            i++;
        }
    }

}