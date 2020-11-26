package GeeksForGeeks.String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
//import java.util.HashSet;
import java.util.Map;
//import java.util.Set;
//import java.util.SortedMap;
//import java.util.TreeMap;

class CamelCase { 
    static Map<String, Integer> mapGlobal = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine()), k = 0;
        while (k++ < testCases) {
            int arrSize = Integer.parseInt(br.readLine());
            String arrS1[] = br.readLine().split("\\s+");
            String camel = br.readLine();
            int count =0;
            StringBuilder sb = new StringBuilder();
            ArrayList<String> list = new ArrayList<>();
            Map<String,Integer> map = new HashMap<>();
            for (int i = 0; i < arrSize; i++) {
                if (checkCamel(arrS1[i], camel)) {
                    list.add(arrS1[i]);
                    map.put(arrS1[i], i);
                    count++;
                }
            }
            //Collections.sort(list);
            mapGlobal.putAll(map);
            
            //Collections.sort(list,((x,y)->(upperCaseCheck(x, y))?1:-1));

            Collections.sort(list, new Comparator<String>() {
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

            if(count!=0){
                for(String s : list){
                    sb.append(s+" ");
                }
                System.out.println(sb);
            }else{
                System.out.println("No match found");
            }
            
        }
    }

    static boolean checkCamel(String str, String camel) {
        int i = 0, j = 0;
        int sizeStr = str.length(), sizeCamel = camel.length();
        int state = 0;
        while(i<sizeStr && j<sizeCamel){
            if(state == 0){
                if(Character.isUpperCase(str.charAt(i)) && str.charAt(i) == camel.charAt(j)){
                    i++;j++;
                    state = 1;
                }else if(Character.isUpperCase(str.charAt(i))){
                    i++;
                    state = 1;
                }else{
                    return false;
                }
            }else if(state == 1){
                if(!Character.isUpperCase(str.charAt(i))){
                    i++;
                    state = 2;
                }else{
                    return false;
                }
            }else if(state == 2){
                if(Character.isUpperCase(str.charAt(i))  &&  str.charAt(i) == camel.charAt(j)){
                    i++; j++;
                    state = 1;
                }else if(Character.isUpperCase(str.charAt(i))){
                    i++;
                    state = 1;
                }else{
                    i++;
                }
            }
        }
        if(j == camel.length()){
            return true;
        }else{
            return false;
        }
    }

    static boolean upperCaseCheck(String x, String y){
        if(x.compareTo(y) > 0){
            return false;
        }else{
            return true;
        }
    }
}