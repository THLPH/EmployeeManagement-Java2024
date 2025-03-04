public interface BonusStrategy 
{
    double calculateBonus(double salary);
}

class PerformanceBonusStrategy implements BonusStrategy 
{
    @Override
    public double calculateBonus(double salary) 
    {
        return salary * 0.20; // Managers get a 20% performance-based bonus
    }
}

class ProjectBonusStrategy implements BonusStrategy 
{
    @Override
    public double calculateBonus(double salary) 
    {
        return salary * 0.15; // Engineers get a 15% project-based bonus
    }
}

class FixedBonusStrategy implements BonusStrategy 
{
    @Override
    public double calculateBonus(double salary) 
    {
        return 500; // Fixed bonus for other roles
    }
}
