class Manager extends Employee 
{
    private int teamSize;
    private BonusStrategy bonusStrategy;

    public Manager(String name, int age, String address, String employeeID, String department, double salary, int teamSize, BonusStrategy bonusStrategy) 
    {
        super(name, age, address, employeeID, department, salary);
        this.teamSize = teamSize;
        this.bonusStrategy = bonusStrategy;
    }

    public double calculateTotalCompensation() 
    {
        return getSalary() + bonusStrategy.calculateBonus(getSalary());
    }
    
    public double calculateAnnualSalary() 
    {
        return super.calculateAnnualSalary() + 5000;
    }
    
    public int getTeamSize() {return teamSize;}
    public double getBonus(double salary) {return bonusStrategy.calculateBonus(salary);}
    
}