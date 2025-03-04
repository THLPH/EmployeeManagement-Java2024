public class CertificationDecorator extends CompensationDecorator
{
    private String certification;

    public CertificationDecorator(Employee decoratedEmployee, String certification)
    {
        super(decoratedEmployee);
        this.certification = certification;
    }

    public String getCertification()
    {
        return certification;
    }

    @Override
    public double calculateTotalCompensation()
    {
        double baseCompensation = super.calculateTotalCompensation();
        // Adjust how the certification affects total compensation
        return baseCompensation + 2000; // Example: each certification adds $2000
    }
}
