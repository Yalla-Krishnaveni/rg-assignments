public class Service {
    private Repository repository;

    // Dependency is injected via setter method
    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}
