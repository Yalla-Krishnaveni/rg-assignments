import java.util.Arrays;
import java.util.List;

public class MethodReference {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Harsha","Krishnaveni","Sreya");

    
        System.out.println("Printing names using lambda expression:");
        names.forEach(name -> System.out.println(name));

        System.out.println("\nPrinting names using method reference:");
        names.forEach(System.out::println);
    }
}
