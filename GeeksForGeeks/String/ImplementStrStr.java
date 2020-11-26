package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ImplementStrStr
 */
public class ImplementStrStr {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
            String[] st = br.readLine().split(" ");
            int index = st[0].indexOf(st[1]);
            System.out.println(index);
        }
    }
}