public class Service {
    private final Repository repository;

    // Dependency is injected via constructor
    public Service(Repository repository) {
        this.repository = repository;
    }
}
