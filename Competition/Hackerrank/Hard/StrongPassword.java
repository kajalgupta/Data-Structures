import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrongPassword {
     public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.println(check(n, str));
        System.out.println(check2(n, str));
                

    }

    private static int check2(int n, String str) {

        String numbers = ".*[0-9]+.*";
        String lower_case = ".*[a-z]+.*";
        String upper_case = ".*[A-Z]+.*";
        String special_characters = ".*[-!@#$%^&*()+]+.*";
       
        int count = 0;
        
        if (!str.matches(numbers)) {
            count++;
        }
        if (!str.matches(lower_case)) {
            count++;
        }
        if (!str.matches(upper_case)) {
            count++;
        }
        if (!str.matches(special_characters)) {
            count++;
        }
        if (str.length() + count < 6) {
            return count +=  (6 - str.length()  - count);
        }
        return count;
    }

    private static int check(int n, String str) {
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";
       
        int count = 0;
        boolean flag = false;
        for (char c : numbers.toCharArray()) {
            if( str.contains(String.valueOf(c) )  ) {
                flag = true;
                break;
            } 
            else{
                flag = false;
            }
        }
        if ( !flag ) {
            count += 1;
        }
        flag = false;
        for (char c : lower_case.toCharArray()) {
            if( str.contains(String.valueOf(c) )  ) {
                flag = true;
                break;
            } 
            else{
                flag = false;
            }
        }
        if ( !flag ) {
            count += 1;
        }
        flag = false;
        for (char c : upper_case.toCharArray()) {
            if( str.contains(String.valueOf(c) )  ) {
                flag = true;
                break;
            } 
            else{
                flag = false;
            }
        }
        if ( !flag ) {
            count += 1;
        }
        
        flag = false;
        for (char c : special_characters.toCharArray()) {
            if( str.contains(String.valueOf(c) )  ) {
                flag = true;
                break;
            } 
            else{
                flag = false;
            }
        }
        if ( !flag ) {
            count += 1;
        }
        flag = false;
        if (str.length()+count <6) {
            count += 6 - (str.length()+count);
        }
        return count;
    }
}
