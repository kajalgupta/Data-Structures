import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GOT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        System.out.println(check(str));
        
    }

    private static String check(String str) {
        List<Character> list = new ArrayList<>();
        for (char character : str.toCharArray()) {
            if (list.contains(character)) {
                list.remove(Character.valueOf(character));
            }
            else list.add(character);
        }
        return (list.size()==0 || list.size()==1) ? "YES" : "NO";
    }
}
