@Component
public class Service {
    @Autowired
    private Dependency dependency;

    @Autowired
    public Service(Dependency dependency) {
        this.dependency = dependency;
    }

    @Autowired
    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }
}
