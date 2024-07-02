import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class EmployeeCRUD {
    private List<Employee> employeeList;

    public EmployeeCRUD() {
        employeeList = new ArrayList<>();
    }

    // Create an employee
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        System.out.println("Employee added: " + employee);
    }

    // Read all employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Read an employee by ID
    public Employee getEmployeeById(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // Update an employee by ID
    public boolean updateEmployee(int id, String name, String department) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employee.setName(name);
                employee.setDepartment(department);
                System.out.println("Employee updated: " + employee);
                return true;
            }
        }
        return false;
    }

    // Delete an employee by ID
    public boolean deleteEmployee(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeList.remove(employee);
                System.out.println("Employee deleted: " + employee);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeCRUD employeeCRUD = new EmployeeCRUD();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    Employee employee = new Employee(id, name, department);
                    employeeCRUD.addEmployee(employee);
                    break;

                case 2:
                    System.out.println("All employees: " + employeeCRUD.getAllEmployees());
                    break;

                case 3:
                    System.out.print("Enter ID to Update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Department: ");
                    String newDepartment = scanner.nextLine();
                    employeeCRUD.updateEmployee(updateId, newName, newDepartment);
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int deleteId = scanner.nextInt();
                    employeeCRUD.deleteEmployee(deleteId);
                    break;

                case 5:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}