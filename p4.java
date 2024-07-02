public class Singleton {
    // Private static instance of the Singleton class
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside
    private Singleton() {
        // Initialization code, if needed
    }

    // Public static method to get the singleton instance
    public static Singleton getInstance() {
        // Lazy initialization: create instance if not already instantiated
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Example method of the Singleton class
    public void showMessage() {
        System.out.println("Hello, I am a singleton instance!");
    }

    // Example main method to demonstrate usage
    public static void main(String[] args) {
        // Get the singleton instance
        Singleton singletonInstance = Singleton.getInstance();

        // Call a method on the singleton instance
        singletonInstance.showMessage();
    }
}
