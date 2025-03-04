import java.util.ArrayList;
import java.util.List;

public class ObservableEmployeeList
{
    private List<Employee> employees;
    private List<Observer> observers;

    public ObservableEmployeeList()
    {
        this.employees = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addEmployee(Employee employee)
    {
        employees.add(employee);
        notifyObservers("Employee Added", employee);
    }

    public void updateEmployee(Employee employee)
    {
        // Find the employee by ID and update the information
        for (int i = 0; i < employees.size(); i++)
        {
            if (employees.get(i).getEmployeeID().equals(employee.getEmployeeID()))
            {
                employees.set(i, employee); // Update the employee information
                notifyObservers("Employee Updated", employee);
                return;
            }
        }
    }

    public List<Employee> getEmployees()
    {
        return employees;
    }

    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }

    private void notifyObservers(String event, Employee employee)
    {
        for (Observer observer : observers)
        {
            observer.update(event, employee);
        }
    }
}
