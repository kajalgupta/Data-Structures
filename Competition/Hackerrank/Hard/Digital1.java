import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Digital1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // int  m = Integer.parseInt(br.readLine());
       // LONG Input long n = Long.parseLong(br.readLine()); 

        for(int t = Integer.parseInt(br.readLine()); t>0; t--){

            String[] str = br.readLine().split("\\s+");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            int x = Integer.parseInt(str[2]);
            int y = Integer.parseInt(str[3]);
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
            Set<Integer> set = new HashSet<>();
            set.add(x);
            boolean flag = true;
            int next = (x+k >= n) ? (x+k)%n : x+k ;
            if(next == y) {System.out.println("YES");     flag = false;   }
            else{
                     while (!set.contains(next)) {
                        set.add(next);
                        next = (next+k >= n) ? (next+k)%n : next+k ;
                        if(next == y) { 
                            System.out.println("YES");
                            flag = false;
                            break; 
                         }
                    }
                }
            if(flag) System.out.println("NO");
        }
       // System.out.println(fun());


    }
}