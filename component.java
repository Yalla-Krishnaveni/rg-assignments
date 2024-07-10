import org.springframework.stereotype.Component;

@Component
public class UtilityComponent {
    public String formatMessage(String message) {
        return "Formatted: " + message;
    }
}
