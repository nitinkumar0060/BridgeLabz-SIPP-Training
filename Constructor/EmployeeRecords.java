class Employee {
    public int employeeID;         // Public: accessible anywhere
    protected String department;   // Protected: accessible in subclasses and same package
    private double salary;         // Private: accessible only within Employee class

    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to set salary
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary amount.");
        }
    }

    // Public method to get salary
    public double getSalary() {
        return salary;
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: ₹" + salary);
    }
}

class Manager extends Employee {
    private String teamName;

    // Constructor
    public Manager(int employeeID, String department, double salary, String teamName) {
        super(employeeID, department, salary);
        this.teamName = teamName;
    }

    public void displayManagerInfo() {
        System.out.println("Manager Info:");
        System.out.println("Employee ID (Public): " + employeeID);     // Accessing public
        System.out.println("Department (Protected): " + department);   // Accessing protected
        System.out.println("Team: " + teamName);
        System.out.println("Salary (via Getter): ₹" + getSalary());    // Accessing private via method
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Employee emp = new Employee(101, "HR", 50000);
        emp.displayEmployeeInfo();
        emp.setSalary(55000); // Modifying salary
        System.out.println("Updated Salary: ₹" + emp.getSalary());

        System.out.println();

        Manager mgr = new Manager(201, "IT", 85000, "Tech Team A");
        mgr.displayManagerInfo();
    }
}
