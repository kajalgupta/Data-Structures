import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class AB {
     public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
		int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        System.out.println(turns(s, a, b));
    }

    private static int turns(String s, int a, int b) {
        //StringBuilder sb = new StringBuilder(s);
        String temp = s;
        int turn = 1;
        int len = s.length();
        s = s.substring(len - a, len)+s.substring(0, len - a);
        while (!s.equals(temp)) {
            if(turn % 2 == 0)
                s = s.substring(len - a, len)+s.substring(0, len - a);
            else 
                s = s.substring(len - b, len)+s.substring(0, len - b);
            turn++;
        }
        return turn;
    }
}
