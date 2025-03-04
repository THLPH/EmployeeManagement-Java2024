class Employee extends Person {
    String employeeID;
    String department;
    double salary; 
    
    public Employee(String name, int age, String address, String employeeID, String department, double salary) 
    {
        super(name, age, address);
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
        
    public void printInfo()
    {
        super.printInfo();
        System.out.println("Employee Information:");
        System.out.println("Employee ID: " + this.employeeID);
        System.out.println("Department: " + this.department);
        System.out.println("Salary: "+ this.salary);
    }        
}
    
    