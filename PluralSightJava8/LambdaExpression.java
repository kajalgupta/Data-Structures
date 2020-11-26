package PluralSightJava8;

import java.io.File;
import java.io.FileFilter;
//import java.io.FileWriter;

public class LambdaExpression {
    public static void main(String[] args) {
        
        FileFilter filter = new FileFilter(){
        
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

       
        System.out.println("FileFilter interface through anonymous class");
        File dir = new File("F:/DataStructures/GeeksForGeeks/HardProblems");
        File[] files = dir.listFiles(filter);
        for (File file : files) {
            System.out.println(file);
        }
        System.out.println("FileFilter interface through LambdaExpression");
        FileFilter filterLambda = (File pathname) -> 
                 pathname.getName().endsWith(".java");
        File directory = new File("F:/DataStructures/GeeksForGeeks/HardProblems");
        File[] filesLambda = directory.listFiles(filterLambda);
        for (File file : filesLambda) {
            System.out.println(file);
        }

    
    }

}