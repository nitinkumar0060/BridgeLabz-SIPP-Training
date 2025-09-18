import java.util.*;
import java.util.stream.*;

class Employee {
    String name, department;
    double salary;
    Employee(String name, String department, double salary) {
        this.name = name; this.department = department; this.salary = salary;
    }
    String getDepartment() { return department; }
    double getSalary() { return salary; }
}

public class SalaryCategorization {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Amit", "IT", 60000),
            new Employee("Ravi", "IT", 55000),
            new Employee("Neha", "HR", 45000),
            new Employee("Sneha", "HR", 47000),
            new Employee("Raj", "Finance", 70000)
        );

        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment,
                     Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(avgSalaryByDept);
    }
}
