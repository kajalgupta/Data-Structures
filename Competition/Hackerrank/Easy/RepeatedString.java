import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepeatedString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        long n = Long.parseLong(br.readLine());
        if (str.length()==1 && str.equals("a")) {
            System.out.println(n);
        }
        else{
        StringBuilder sb = new StringBuilder(str);
        long count1 = 0;
        int count2 = 0;
        for (int i = 0; i < sb.length(); i++) {
            count1+=(sb.charAt(i)=='a')?1:0;
        }
        long countStr = 0;
        long length = sb.length();
        int actualLength = sb.length();
        System.out.println(count1);
       // while (length<n) {
            
            countStr = n/actualLength;
           // System.out.println((float)n/actualLength+"----------------------------");
            //length=countStr * actualLength;
           // System.out.println("hey");
        //}
        //long remaining = length-(countStr-1)*actualLength;
        System.out.println("hey");
        long remaining = n%length;
        count1  = countStr*count1;
        System.out.println(remaining+"----"+countStr);
        for (int i = 0; i < remaining; i++) {
            count1+=(sb.charAt(i)=='a')?1:0;
        }
       System.out.println(count1);
       System.out.println("hey");
    }
}
    
}