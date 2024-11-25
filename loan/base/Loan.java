package loan.base;

public class Loan {
    protected String purpose;
    protected double amount;
    protected double annualInterestRate;
    protected int totalMonths;

    // Constructor
    public Loan(String purpose, double amount, double annualInterestRate, int totalMonths) {
        this.purpose = purpose;
        this.amount = amount;
        this.annualInterestRate = annualInterestRate;
        this.totalMonths = totalMonths;
    }

    // Method to display loan details
    public void displayLoanDetails() {
        System.out.println("Loan Purpose: " + purpose);
        System.out.println("Loan Amount: " + amount);
        System.out.println("Annual Interest Rate: " + annualInterestRate + "%");
        System.out.println("Loan Tenure (Months): " + totalMonths);
    }
}
