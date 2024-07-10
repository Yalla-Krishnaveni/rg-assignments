import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class AppNamePrinter {
    @Value("${app.name}")
    private String appName;

    public void printAppName() {
        System.out.println("Application Name: " + appName);
    }
}
