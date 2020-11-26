package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction;

/**
 * SmallestWindow
 */

// 1. BRUTE FORCE SOLUTION
public class SmallestWindow {

    public static String window(char[] inputString, char[] pattern) {

        int n = inputString.length;
        int size = pattern.length;
        int smallest = size;

        while (smallest < n) {
            for (int i = 0; i <= n - smallest; i++) {
                List<Character> list = new ArrayList<Character>();
                for (int j = i; j < i + smallest; j++) {
                    list.add(inputString[j]);
                }
                int count = 0;
                for (int k = 0; k < pattern.length; k++) {
                    if (list.contains(pattern[k])) {
                        count++;
                    } else
                        break;
                }
                // System.out.println("substring is"+list);
                if (count == pattern.length) {
                    return list.toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
                }
            }
            smallest++;
        }

        return "-1";
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
            String s = br.readLine();
            String pattern = br.readLine();
            
            System.out.println(window(s.toCharArray(), pattern.toCharArray()));
            
        }
    }
}

/*
 * abstract
 * 
 * 
 * toc substring is[t, i, m] substring is[i, m, e] substring is[m, e, t]
 * substring is[e, t, o] substring is[t, o, p] substring is[o, p, r] substring
 * is[p, r, a] substring is[r, a, c] substring is[a, c, t] substring is[c, t, i]
 * substring is[t, i, c] substring is[i, c, e] substring is[t, i, m, e]
 * substring is[i, m, e, t] substring is[m, e, t, o] substring is[e, t, o, p]
 * substring is[t, o, p, r] substring is[o, p, r, a] substring is[p, r, a, c]
 * substring is[r, a, c, t] substring is[a, c, t, i] substring is[c, t, i, c]
 * substring is[t, i, c, e] substring is[t, i, m, e, t] substring is[i, m, e, t,
 * o] substring is[m, e, t, o, p] substring is[e, t, o, p, r] substring is[t, o,
 * p, r, a] substring is[o, p, r, a, c] substring is[p, r, a, c, t] substring
 * is[r, a, c, t, i] substring is[a, c, t, i, c] substring is[c, t, i, c, e]
 * substring is[t, i, m, e, t, o] substring is[i, m, e, t, o, p] substring is[m,
 * e, t, o, p, r] substring is[e, t, o, p, r, a] substring is[t, o, p, r, a, c]
 * substring is[o, p, r, a, c, t] substring is[p, r, a, c, t, i] substring is[r,
 * a, c, t, i, c] substring is[a, c, t, i, c, e] substring is[t, i, m, e, t, o,
 * p] substring is[i, m, e, t, o, p, r] substring is[m, e, t, o, p, r, a]
 * substring is[e, t, o, p, r, a, c] substring is[t, o, p, r, a, c, t] substring
 * is[o, p, r, a, c, t, i] substring is[p, r, a, c, t, i, c] substring is[r, a,
 * c, t, i, c, e] substring is[t, i, m, e, t, o, p, r] substring is[i, m, e, t,
 * o, p, r, a] substring is[m, e, t, o, p, r, a, c] substring is[e, t, o, p, r,
 * a, c, t] substring is[t, o, p, r, a, c, t, i] substring is[o, p, r, a, c, t,
 * i, c] substring is[p, r, a, c, t, i, c, e] substring is[t, i, m, e, t, o, p,
 * r, a] substring is[i, m, e, t, o, p, r, a, c] substring is[m, e, t, o, p, r,
 * a, c, t] substring is[e, t, o, p, r, a, c, t, i] substring is[t, o, p, r, a,
 * c, t, i, c] substring is[o, p, r, a, c, t, i, c, e] substring is[t, i, m, e,
 * t, o, p, r, a, c] substring is[i, m, e, t, o, p, r, a, c, t] substring is[m,
 * e, t, o, p, r, a, c, t, i] substring is[e, t, o, p, r, a, c, t, i, c]
 * substring is[t, o, p, r, a, c, t, i, c, e] substring is[t, i, m, e, t, o, p,
 * r, a, c, t] substring is[i, m, e, t, o, p, r, a, c, t, i] substring is[m, e,
 * t, o, p, r, a, c, t, i, c] substring is[e, t, o, p, r, a, c, t, i, c, e]
 * substring is[t, i, m, e, t, o, p, r, a, c, t, i] substring is[i, m, e, t, o,
 * p, r, a, c, t, i, c] substring is[m, e, t, o, p, r, a, c, t, i, c, e]
 * substring is[t, i, m, e, t, o, p, r, a, c, t, i, c] substring is[i, m, e, t,
 * o, p, r, a, c, t, i, c, e] -1 zoomlazapzo oza substring is[z, o, o] substring
 * is[o, o, m] substring is[o, m, l] substring is[m, l, a] substring is[l, a, z]
 * substring is[a, z, a] substring is[z, a, p] substring is[a, p, z] substring
 * is[p, z, o] substring is[z, o, o, m] substring is[o, o, m, l] substring is[o,
 * m, l, a] substring is[m, l, a, z] substring is[l, a, z, a] substring is[a, z,
 * a, p] substring is[z, a, p
 * 
 * 
 */