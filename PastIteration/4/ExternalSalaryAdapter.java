public class ExternalSalaryAdapter implements Compensable
{
    private ExternalSalaryCalculator externalCalculator;
    private double baseSalary;
    private double bonus;

    public ExternalSalaryAdapter(ExternalSalaryCalculator externalCalculator, double baseSalary, double bonus)
    {
        this.externalCalculator = externalCalculator;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateTotalCompensation()
    {
        return externalCalculator.calculateExternalSalary(baseSalary, bonus);
    }
}
