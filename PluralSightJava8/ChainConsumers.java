package PluralSightJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumers {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("one", "two", "three", "four");
        List<String> result = new ArrayList<>();
        List<String> result2 = new ArrayList<>();
        
       // Consumer<String> c1 = s->System.out.println(s); 
       Consumer<String> c1 = System.out::println;//Using METHOD REFERENCES INSTEAD OF ABOVE LAMBDA EXPRESSION   
       //Consumer<String> c2 = s -> result.add(s);
       Consumer<String> c2 = result::add;
        input.forEach(c1);
        input.forEach(c1.andThen(c2));
        //Consumer interface there is a method "andThen()" use to chain consumers.
        System.out.println("result list size"+result.size());
        input.forEach(result2::add);
        System.out.println(result2);
    }

}