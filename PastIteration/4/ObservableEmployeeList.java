import java.util.ArrayList;
import java.util.List;

public class ObservableEmployeeList
{
    private List<Employee> employees;
    private List<Observer> observers;

    public ObservableEmployeeList()
    {
        employees = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }

    public void addEmployee(Employee employee)
    {
        employees.add(employee);
        notifyObservers("Employee Added", employee);
    }

    public void updateEmployeeRole(Employee employee, Role newRole)
    {
        employee.setRole(newRole);
        notifyObservers("Employee Role Updated", employee);
    }

    public void updateEmployeeDepartment(Employee employee, Department newDepartment)
    {
        employee.setDepartment(newDepartment);
        notifyObservers("Employee Department Updated", employee);
    }

    private void notifyObservers(String event, Employee employee)
    {
        for (Observer observer : observers)
        {
            observer.update(event, employee);
        }
    }
}
