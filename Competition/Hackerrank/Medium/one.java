import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class One {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split("\\s+");
    
//    char[] arr = str
    int count = 3;
    if (str[0].equals("W")) {
        count++;
    }
    if (str[1].equals("W")) {
        count++;
    }if (str[3].equals("W")) {
        count++;
    }if (str[6].equals("W")) {
        count++;
    }
    System.out.println(count);
    }
}