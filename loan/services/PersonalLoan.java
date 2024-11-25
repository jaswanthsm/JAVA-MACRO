package loan.services;

import loan.base.Loan;

public class PersonalLoan extends Loan implements EMICalculator {
    private double monthlyInterestRate;

    public PersonalLoan(String purpose, double amount, double annualInterestRate, int totalMonths) {
        super(purpose, amount, annualInterestRate, totalMonths);
        this.monthlyInterestRate = annualInterestRate / 12 / 100;
    }

    @Override
    public double calculateEMI() {
        return (amount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalMonths)) /
               (Math.pow(1 + monthlyInterestRate, totalMonths) - 1);
    }

    @Override
    public double calculateTotalPaid(int monthsPaid) {
        return calculateEMI() * monthsPaid;
    }

    @Override
    public double calculateRemainingAmount(int monthsPaid) {
        return calculateEMI() * calculateRemainingMonths(monthsPaid);
    }

    @Override
    public int calculateRemainingMonths(int monthsPaid) {
        return totalMonths - monthsPaid;
    }

    // Method to display EMI details
    public void displayEMIDetails(int monthsPaid) {
        System.out.printf("Monthly EMI: %.2f\n", calculateEMI());
        System.out.printf("Total Paid Amount (so far): %.2f\n", calculateTotalPaid(monthsPaid));
        System.out.println("Remaining Months: " + calculateRemainingMonths(monthsPaid));
        System.out.printf("Remaining Amount to Pay: %.2f\n", calculateRemainingAmount(monthsPaid));
    }
}
