public class ManagerObserver implements Observer
{
    @Override
    public void update(String event, Employee employee)
    {
        System.out.println("Manager notified of event: " + event + " for Employee: " + employee.getName());
    }
}
