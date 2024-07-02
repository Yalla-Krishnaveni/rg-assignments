class Main {
    private String brand;
    private int year;
    public Main(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void displayDetails() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }
    public static void main(String[] args) {
        Main myCar = new Main("Toyota", 2022);
        System.out.println("Initial brand: " + myCar.getBrand());
        myCar.setBrand("Honda");
        myCar.setYear(2023);
        myCar.displayDetails();
    }
}
