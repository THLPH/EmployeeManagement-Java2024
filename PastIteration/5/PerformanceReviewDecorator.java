public class PerformanceReviewDecorator extends CompensationDecorator
{
    private double performanceScore;

    public PerformanceReviewDecorator(Employee decoratedEmployee, double performanceScore)
    {
        super(decoratedEmployee);
        this.performanceScore = performanceScore;
    }

    public double getPerformanceScore()
    {
        return performanceScore;
    }

    @Override
    public double calculateTotalCompensation()
    {
        // You can adjust how the performance score affects the total compensation here
        double baseCompensation = super.calculateTotalCompensation();
        return baseCompensation + (performanceScore * 1000); // Example: each point adds $1000
    }
}
