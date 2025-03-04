public class ReportGenerator
{
    public void generatePersonReport(Person person)
    {
        System.out.println("Person Information:");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Address: "+ person.getAddress());
    }
    public void generateEmployeeReport(Employee employee)
    {
        generatePersonReport(employee);
        System.out.println("Employee Information:");
        System.out.println("Employee ID: " + employee.getEmployeeID());
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Salary: "+ employee.getSalary());
    }
    public void generateManagerReport(Manager manager)
    {
        generateEmployeeReport(manager);
        System.out.println("Manager Information:");
        System.out.println("Team Size: " + manager.getTeamSize());
        System.out.println("Total Compensation: " + manager.calculateTotalCompensation());
    }
}