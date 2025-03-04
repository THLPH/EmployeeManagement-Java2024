import java.util.*;

public class EmployeeManagementFacade
{
    private EmployeeFactory employeeFactory;
    private ReportGenerator reportGenerator;
    private ObservableEmployeeList employeeList;

    public EmployeeManagementFacade()
    {
        this.employeeFactory = new EmployeeFactory();
        this.reportGenerator = new ReportGenerator();
        this.employeeList = new ObservableEmployeeList();
    }

    public void addEmployee(String name, int age, String address, String employeeID, Department department, Role role, double salary, BonusStrategy bonusStrategy, Location location)
    {
        // Select a default bonus strategy based on the role
        switch (role)
        {
            case MANAGER:
                bonusStrategy = new PerformanceBonusStrategy(); // Managers get a performance bonus
                break;
            case ENGINEER:
                bonusStrategy = new ProjectBonusStrategy(); // Engineers get a project bonus
                break;
            default:
                bonusStrategy = new FixedBonusStrategy(); // Default for other roles
                break;
        }

        // Create the employee with the selected bonus strategy
        Employee employee = employeeFactory.createEmployee(name, age, address, employeeID, department, salary, bonusStrategy, role, Location.REMOTE); // Assuming a default location
        employeeList.addEmployee(employee);
    }

    public void assignRoleAndDepartment(Employee employee, Role role, Department department)
    {
        employee.setRole(role);
        employee.setDepartment(department);
        employeeList.updateEmployee(employee);
    }

    public void generateReportByRole(Role role)
    {
        reportGenerator.generateReportByRole(role, employeeList.getEmployees());
    }

    public void generateReportByDepartment(Department department)
    {
        reportGenerator.generateReportByDepartment(department, employeeList.getEmployees());
    }

    public double calculateTotalCompensation(Employee employee)
    {
        return employee.calculateTotalCompensation();
    }

    public List<Employee> getEmployeeList()
    {
        return employeeList.getEmployees();
    }
}
