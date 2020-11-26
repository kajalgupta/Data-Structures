package GeeksForGeeks.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//import java.util.regex.Pattern;

/**
 * StringComparisonByLength
 */
public class StringComparisonByLength {

    public static void main(String[] args) {
        List<String> books = new ArrayList<>(Arrays.asList("Effective Java","Algorithms","Refactoring"));
        System.out.println("Sorting List of String on the basis of length in java7");
        System.out.println("The original list before sorting is:- "+books);

        Comparator<String> byLength = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                //System.out.println("s1 is "+s1+"s2 is "+s2);
                //System.out.println(s2.length() - s1.length());
                return s2.length() - s1.length();
            }
        };
        Collections.sort(books, byLength);
        System.out.println("The same list after sorting is  :- "+books);
        
        //IN JAVA8 THROUGH LAMBDA EXPRESSION
        List<String> cities = new ArrayList<>(Arrays.asList("London","Tokyo","NewYork"));
        System.out.println("Original list is: "+cities);
        cities.sort((first, second) -> Integer.compare(first.length(), second.length()));
        System.out.println("After sorting the list is "+cities);
        
    
    }
        

    }
