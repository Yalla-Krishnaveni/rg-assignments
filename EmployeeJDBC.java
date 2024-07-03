import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJDBC {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Krish@3004";

    // JDBC variables for opening and managing connection
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    // CRUD Operations

    // Create an employee
    public void addEmployee(Employee employee) {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            String query = "INSERT INTO employee (id, name, department) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getDepartment());
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee added successfully: " + employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    // Read all employees
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            String query = "SELECT * FROM employee";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                Employee employee = new Employee(id, name, department);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return employees;
    }

    // Read an employee by ID
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            String query = "SELECT * FROM employee WHERE id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                employee = new Employee(id, name, department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return employee;
    }

    // Update an employee by ID
    public boolean updateEmployee(int id, String newName, String newDepartment) {
        boolean updated = false;
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            String query = "UPDATE employee SET name=?, department=? WHERE id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newDepartment);
            preparedStatement.setInt(3, id);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                updated = true;
                System.out.println("Employee updated successfully. ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return updated;
    }

    // Delete an employee by ID
    public boolean deleteEmployee(int id) {
        boolean deleted = false;
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            String query = "DELETE FROM employee WHERE id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                deleted = true;
                System.out.println("Employee deleted successfully. ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return deleted;
    }

    // Close JDBC resources
    private void closeResources() {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EmployeeJDBC employeeJDBC = new EmployeeJDBC();

        // Example usage:
        // Add an employee
        Employee emp1 = new Employee(1, "John Doe", "Engineering");
        employeeJDBC.addEmployee(emp1);

        // Get all employees
        List<Employee> allEmployees = employeeJDBC.getAllEmployees();
        System.out.println("All Employees: " + allEmployees);

        // Update an employee
        employeeJDBC.updateEmployee(1, "John Smith", "IT");

        // Get an employee by ID
        Employee empById = employeeJDBC.getEmployeeById(1);
        System.out.println("Employee with ID 1: " + empById);

        // Delete an employee
        employeeJDBC.deleteEmployee(1);
    }
}
