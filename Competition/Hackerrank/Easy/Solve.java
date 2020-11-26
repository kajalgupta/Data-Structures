import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solve {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = Integer.parseInt(br.readLine()); t>0; t--){
            String s = "hackerrank";
            String str = br.readLine();
            int k = 1;
            int index = str.indexOf('h');
            while (index >= 0 && index < str.length()-1 && k < 10) {
                index = str.indexOf(s.charAt(k++), index+1);
                //k += 1;
                System.out.println(index);
            }
            System.out.println(k);
            if(k == 10 ) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
/*abstract 

10
knarrekcah
hackerrank
hackeronek
abcdefghijklmnopqrstuvwxyz
rhackerank
ahankercka
hacakaeararanaka
hhhhaaaaackkkkerrrrrrrrank
crackerhackerknar
hhhackkerbanker
*/