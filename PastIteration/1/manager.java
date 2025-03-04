class Manager extends Employee 
{
    int teamSize;
    double bonus;

    public Manager(String name, int age, String address, String employeeID, String department, double salary, int teamSize, double bonus) {
        super(name, age, address, employeeID, department, salary);
        this.teamSize = teamSize;
        this.bonus = bonus;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Manager Information:");
        System.out.println("Team Size: " + teamSize);
        System.out.println("Bonus: " + bonus);
        System.out.println("Total Compensation: " + calculateTotalCompensation());
    }

    public double calculateTotalCompensation() {
        return salary + bonus;
    }
}