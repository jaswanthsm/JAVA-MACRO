package loan.services;

public interface EMICalculator {
    double calculateEMI();
    double calculateTotalPaid(int monthsPaid);
    double calculateRemainingAmount(int monthsPaid);
    int calculateRemainingMonths(int monthsPaid);
}
