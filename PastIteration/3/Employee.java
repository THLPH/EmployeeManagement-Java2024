class Employee extends Person {
    private String employeeID;
    private Department department;
    private double salary;
    private Role role;
    private Location location;
    
    public Employee(String name, int age, String address, String employeeID, Department department, double salary, Role role, Location location) 
    {
        super(name, age, address);
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
        this.role = role;
        this.location = location;
    }
    
    public double calculateAnnualSalary() 
    {
        return salary*12;
    }
        
    public String getEmployeeID() {return employeeID;}
    public Department getDepartment() {return department;}
    public double getSalary() {return salary;}
    public Role getRole() { return role; }
    public Location getLocation() { return location; }
}
    
    