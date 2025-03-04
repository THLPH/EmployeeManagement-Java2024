class Employee extends Person {
    private String employeeID;
    private String department;
    private double salary; 
    
    public Employee(String name, int age, String address, String employeeID, String department, double salary) 
    {
        super(name, age, address);
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
    
    public double calculateAnnualSalary() 
    {
        return salary*12;
    }
        
    public String getEmployeeID() {return employeeID;}
    public String getDepartment() {return department;}
    public double getSalary() {return salary;} 
}
    
    