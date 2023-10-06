public class Loan {
    private double loanAmount;
    private double annualInterestRate;
    private int numberOfYears;

    public Loan(double loanAmount, double annualInterestRate, int numberOfYears) {
        this.loanAmount = loanAmount;
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
    }

    public double calculateMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 12 / 100;
        int numberOfPayments = numberOfYears * 12;
        return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
    }

    public double calculateTotalPayment() {
        return calculateMonthlyPayment() * numberOfYears * 12;
    }
}
