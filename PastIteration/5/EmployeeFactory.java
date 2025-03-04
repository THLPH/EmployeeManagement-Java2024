public class EmployeeFactory
{
    public static Employee createEmployee(String name, int age, String address, String employeeID,
                                              Department department, double salary,
                                              BonusStrategy bonusStrategy, Role role, Location location)
    {
        switch (role)
        {
            case MANAGER:
                // Use default team size for the manager in this example
                return new Manager(name, age, address, employeeID, department, salary, 5, bonusStrategy, role, location);
            case ENGINEER:
                return new Engineer(name, age, address, employeeID, department, salary, bonusStrategy, role, location);
            default:
                return new Employee(name, age, address, employeeID, department, salary, role, location);
        }
    }
}
