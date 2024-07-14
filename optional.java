import java.util.Optional;

public class optional {
    public static void main(String[] args) {
        Optional<String> optionalName = Optional.of("Krishnaveni");
        Optional<String> optionalEmpty = Optional.empty();

       
        if (optionalName.isPresent()) {
            System.out.println("Name is present: " + optionalName.get());
        } else {
            System.out.println("Name is absent");
        }

   
        String nameOrDefault = optionalEmpty.orElse("Default Name");
        System.out.println("Name from optionalEmpty: " + nameOrDefault);

        
        optionalName.ifPresent(name -> System.out.println("Length of name: " + name.length()));
    }
}
