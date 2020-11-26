
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Digital2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  p1 = Integer.parseInt(br.readLine());
       // int p1 = Long.parseLong(br.readLine()); 

        int  p2 = Integer.parseInt(br.readLine());
        int  p3 = Integer.parseInt(br.readLine());
        int  q = Integer.parseInt(br.readLine());
        int  e = Integer.parseInt(br.readLine());
        int  r = Integer.parseInt(br.readLine());
        int ans2 = e-r-p1-p2+q-p3+q;
        int a = ans2/3;
        int ans1 =  a+ p1 + p3 -q;
       // LONG Input long n = Long.parseLong(br.readLine()); 
        //System.out.println(m);
        System.out.println(ans1);
        
        System.out.println(ans2);

}
}
