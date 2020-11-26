package GeeksForGeeks.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * CheckIfStringRotations
 */
public class CheckIfStringRotations {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t >0 ; t--) {
            String s1 = br.readLine();
            String s2 = br.readLine();
            String s3 = s2+s2;
            if(s1.length()!=s2.length()){
                System.out.println(0);
            }
            else{
                if(s3.contains(s1)){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
          
            
        }
    }
}