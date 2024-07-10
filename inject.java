public class Service {
    @Inject
    private Dependency dependency;

    @Inject
    public Service(Dependency dependency) {
        this.dependency = dependency;
    }

    @Inject
    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }
}
