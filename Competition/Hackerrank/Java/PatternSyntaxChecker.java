package Competition.Hackerrank.Java;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PatternSyntaxChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int t = Integer.parseInt(sc.nextLine()); t>0; t--){
            String format = sc.nextLine(); 
            try {
                Pattern p = Pattern.compile(format);
                System.out.println("pattern created Valid String" + p.pattern());
            } catch (PatternSyntaxException e) {
                System.out.println("This string could not compile, Invalid String \n"+ e.getPattern()  );
                //TODO: handle exception
            }
            //Pattern p = Pattern.compile(pattern);

        }
    }
    //.close()
}