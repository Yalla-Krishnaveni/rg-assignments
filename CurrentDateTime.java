import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateTime {
    public static void main(String[] args) {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Create a formatter to format the date-time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format the current date-time using the formatter
        String formattedDateTime = currentDateTime.format(formatter);

        // Print the formatted date-time
        System.out.println("Current Date and Time: " + formattedDateTime);
    }
}
