import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UppercaseConversion {
    public static void main(String[] args) {
       
        List<String> words = Arrays.asList("HaRsHa", "sreya", "Krishnaveni");

        System.out.println("Input words: " + words);
        List<String> uppercaseWords = words.stream()
                                          .map(String::toUpperCase)
                                          .collect(Collectors.toList());

        
        System.out.println("Uppercase words: " + uppercaseWords);
    }
}
