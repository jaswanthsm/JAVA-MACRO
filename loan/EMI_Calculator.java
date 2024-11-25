package loan;

import loan.services.PersonalLoan;
import loan.database.DatabaseConnection;
import java.util.Scanner;

public class EMI_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the loan purpose: ");
        String purpose = sc.nextLine();

        System.out.println("Enter the loan amount: ");
        double amount = sc.nextDouble();

        System.out.println("Enter the annual interest rate (in %): ");
        double annualInterestRate = sc.nextDouble();

        System.out.println("Enter the loan tenure in months: ");
        int totalMonths = sc.nextInt();

        System.out.println("Enter the number of months already paid: ");
        int monthsPaid = sc.nextInt();

        // Create PersonalLoan object
        PersonalLoan personalLoan = new PersonalLoan(purpose, amount, annualInterestRate, totalMonths);

        // Calculate EMI details
        double emi = personalLoan.calculateEMI();
        double totalPaid = personalLoan.calculateTotalPaid(monthsPaid);
        double remainingAmount = personalLoan.calculateRemainingAmount(monthsPaid);
        int remainingMonths = personalLoan.calculateRemainingMonths(monthsPaid);

        // Display Loan and EMI details
        System.out.println("\nLoan Details:");
        personalLoan.displayLoanDetails();

        System.out.println("\nEMI Details:");
        personalLoan.displayEMIDetails(monthsPaid);

        // Save to database
        DatabaseConnection dbConnection = new DatabaseConnection();
        dbConnection.saveLoanDetails(purpose, amount, annualInterestRate, totalMonths, emi, monthsPaid, totalPaid, remainingMonths, remainingAmount);
    }
}
