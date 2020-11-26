import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HappyLadyBugs {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
           System.out.println(happyString(str,n));
        }
    }

    private static String happyString(String str, int n) {
        boolean flag = false;
        if (str.length()==1 && str.charAt(0)!='_') {
            return "NO";
        }
        if (!str.matches(".*[A-Z].*")) {
            return "YES";
        }
        if (str.contains("_")) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
            if (arr[0]!=arr[1]) {
                return "NO";
            }
            for (int i = 1; i < n; i++) {
                if (arr[i]=='_') {
                    return "YES";
                }
                if (arr[i]!=arr[i-1] && arr[i]!=arr[i+1]) {
                    return "NO";
                }
            }
        } 
        else {
            for (int i = 1; i < n; i++) {
                if (i==n-1) {
                    if (str.charAt(i)!=str.charAt(i-1)){
                        return "NO";
                    }          
                    return "YES";
                }
                if (str.charAt(i)!=str.charAt(i+1) && str.charAt(i)!=str.charAt(i-1)) {
                    return "NO";
                }
            }
        }


        return "NULL";
    }

    private static String happy(String sb, int n) {
        StringBuilder str = new StringBuilder(sb);
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }
            else map.put(str.charAt(i), 1);
        }
        
        for (Map.Entry<Character, Integer> iterable_element : map.entrySet()) {
            if (map.get(iterable_element)==1) {
                return "NO";
            }
        }


        //char x = sb.charAt(0);
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if ((i<n-1 && sb.charAt(i)==sb.charAt(i+1)) || (i>0 && sb.charAt(i-1)==sb.charAt(i))) {
                    flag = true;
                continue;
            }
            else break;
        }
        if (flag) {
            return "YES";
        }
        if (n==1 || !sb.contains("_")) {
            return "NO";
        }

        for (int i = 0; i < n-1; ) {
            System.out.println("i is"+i);
            System.out.println("stringgg"+str);
            int end = n-1;
            while (str.charAt(i)=='_') {
                if (!str.substring(i+1).matches(".*[A-Z].*")) {
                    break;
                }
                str.setCharAt(i, str.charAt(end));
                str.setCharAt(end, '_');
                end--;
            }
            if (str.charAt(i)==str.charAt(i+1)   ) {
                i+=2;
            }
            else if (i>0 &&str.charAt(i)==str.charAt(i-1)) {
                i+=1;
            }
            else{
             if (str.charAt(i+1)!='_') {
                int index = str.indexOf("_");
                if(index==-1) return "NO";
                 str.setCharAt(index,str.charAt(i+1));
                 str.setCharAt(i+1, '_');
             }
               System.out.println("||||||||"+str);
               System.out.println("subbbbbbb"+str.substring(i+1, n));
               int index2 = str.substring(i+1, n).indexOf(str.charAt(i));

               
               System.out.println("______"+index2);
               if (index2==-1 ) {
                System.out.println("_____!!"+str);
                   return "NO";
               }
               else{
                index2+=i+1;
                str.setCharAt(i+1, str.charAt(index2));
                System.out.println("++++++++++"+str);
                 str.setCharAt(index2, '_');
                System.out.println("**********"+str);
                i+=2;
               }
            }
        }
        System.out.println("_____"+str);
        if (str.charAt(n-1)!='_' && str.charAt(n-1)!=str.charAt(n-2)) {
            return "NO";
        }
        
        return "YES";
    }
    
}