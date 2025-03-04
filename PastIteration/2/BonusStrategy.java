interface PerformanceBonusStrategy
{
    double calculateBonus (double salary);
}

public class BonusStrategy implements PerformanceBonusStrategy
{
    public double calculateBonus(double salary)
    {
        return salary * 0.1;
    }
}