package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * RecursivelyRemoveAdjacentDuplicates
 */
public class RecursivelyRemoveAdjacentDuplicates {

    static String removeDuplicates(String str){
        if(str.equals(""))
        return "";

        int n = str.length();

        Stack<Character> st = new Stack<>();
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            st.push(str.charAt(i));
        }
        str="";
        char c = st.peek();
        st.pop();
        flag = false;
        int key = 0;
        while (!st.isEmpty()) {
            if(c==st.peek()){
                flag = true;
                key = 1;
            }
            else{
                if (flag==false) {
                    str += c;
                }
                c = st.peek();
                flag = false;
            }
            st.pop();
        }
        if (flag==false){
            str += c;
        }
        StringBuilder sb = new StringBuilder(str);
        sb = sb.reverse();
        str = sb.toString();
        if (key==1) {
            str = removeDuplicates(str);
        }
            return str;
        
    }

    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for (int t = Integer.parseInt(br.readLine()); t>0; t--) {
                String str = br.readLine();
                System.out.println(removeDuplicates(str));
            }
        }
        

    }
        


    