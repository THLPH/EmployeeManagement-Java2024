interface RoleSpecific 
{
    void performRoleSpecificTask();
}

class Manager extends Employee implements RoleSpecific 
{
    private int teamSize;
    private BonusStrategy performanceBonusStrategy;

    public Manager(String name, int age, String address, String employeeID, Department department, double salary, int teamSize, BonusStrategy bonusStrategy, Role role, Location location) 
    {
        super(name, age, address, employeeID, department, salary, role, location);
        this.teamSize = teamSize;
        this.performanceBonusStrategy = bonusStrategy;
    }

    public double calculateTotalCompensation() 
    {
        return getSalary() + performanceBonusStrategy.calculateBonus(getSalary());
    }
    
    public double calculateAnnualSalary() 
    {
        return super.calculateAnnualSalary() + 5000;
    }
    
    @Override
    public void performRoleSpecificTask() 
    {
        System.out.println("Manager is leading the team.");
    }
    
    public int getTeamSize() {return teamSize;}
    public double getBonus(double salary) {return performanceBonusStrategy.calculateBonus(salary);}

}

class Engineer extends Employee implements RoleSpecific 
{   
    private BonusStrategy projectBonusStrategy;

    public Engineer(String name, int age, String address, String employeeID, Department department, double salary, BonusStrategy bonusStrategy, Role role,  Location location) 
    {
        super(name, age, address, employeeID, department, salary, role, location);
        this.projectBonusStrategy = bonusStrategy;
    }

    @Override
    public void performRoleSpecificTask() 
    {
        System.out.println("Engineer is developing the project.");
    }
    
    public double getBonus(double salary) {return projectBonusStrategy.calculateBonus(salary);}
}