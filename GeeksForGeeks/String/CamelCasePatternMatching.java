package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//import sun.security.util.Length;

/**
 * CamelCasePatternMatching
 */
public class CamelCasePatternMatching {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            String pattern = br.readLine();
            int patternLength = pattern.length();
            List<String> list = new ArrayList<>();
            List<String> result = new ArrayList<>();
            
            for (int i = 0; i < str.length; i++) {
                list.add(str[i]);
            }
           
            for (String string : list) {
                int i = -1;
                int k=0;
                while (k<patternLength) {
                    if(++i<string.length()){
                        if (Character.isUpperCase(string.charAt(i))){                       
                            if (pattern.charAt(k)==string.charAt(i)) {
                                k++;
                                continue;
                            } else {
                                break;
                            }
                        } 
                        

                    }
                    else{
                        break;
                    }         
                }
                if (k==patternLength) {
                   result.add(string); 
                }
            }
            if (result.isEmpty()) {
                System.out.println("No match found");
            } else {

                Collections.sort(result, new Comparator<String>() {

                    @Override
                    public int compare(String o1, String o2) {
                    StringBuilder first =new StringBuilder(),second =new StringBuilder();
                    for(int i=0;i<o1.length();i++) if(o1.charAt(i)>='A'&&o1.charAt(i)<='Z')
                    first.append(o1.charAt(i));
                    for(int i=0;i<o2.length();i++) if(o2.charAt(i)>='A'&&o2.charAt(i)<='Z')
                    second.append(o2.charAt(i));
                    return first.toString().compareTo(second.toString());
                    }
                    });

                System.out.println(result.toString().replace("[","").replace("]","").replace(",",""));
            }
            
            }
            
        }
    
}