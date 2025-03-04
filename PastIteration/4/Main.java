import java.util.*;

enum Role
{
    MANAGER,
    ENGINEER,
    HR_REPRESENTATIVE,
    SALESPERSON
}

enum Department
{
    IT,
    ENGINEERING,
    HR,
    SALES,
    MARKETING
}

enum Location
{
    NEW_YORK,
    SAN_FRANCISCO,
    LOS_ANGELES,
    ATLANTA,
    REMOTE
}

public class Main
{
    public static void main(String[] args)
    {
        // Observer Pattern
        ObservableEmployeeList employeeList = new ObservableEmployeeList();
        employeeList.addObserver(new HRDepartmentObserver());
        employeeList.addObserver(new ManagerObserver());

        Employee newEmployee = new Employee("Jane Doe", 28, "9876 Maple St", "E003", Department.IT, 70000, Role.ENGINEER, Location.ATLANTA);
        employeeList.addEmployee(newEmployee);

        // Adapter Pattern
        ExternalSalaryCalculator externalCalculator = new ExternalSalaryCalculator();
        ExternalSalaryAdapter salaryAdapter = new ExternalSalaryAdapter(externalCalculator, 80000, 12000);
        System.out.println("Total Compensation: " + salaryAdapter.calculateTotalCompensation());
    }
}

