public class HRDepartmentObserver implements Observer
{
    @Override
    public void update(String event, Employee employee)
    {
        System.out.println("HR Department notified of event: " + event + " for Employee: " + employee.getName());
    }
}
