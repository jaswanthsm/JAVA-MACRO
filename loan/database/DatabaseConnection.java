package loan.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/loan_db"; // Replace with your DB URL
    private static final String USER = "root"; // Replace with your DB user
    private static final String PASSWORD = ""; // Replace with your DB password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void saveLoanDetails(String purpose, double amount, double annualInterestRate, int totalMonths,
                                double monthlyEMI, int monthsPaid, double totalPaid, int remainingMonths, double remainingAmount) {
        String insertSQL = "INSERT INTO LoanDetails (purpose, amount, annualInterestRate, totalMonths, monthlyEMI, monthsPaid, totalPaid, remainingMonths, remainingAmount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
            stmt.setString(1, purpose);
            stmt.setDouble(2, amount);
            stmt.setDouble(3, annualInterestRate);
            stmt.setInt(4, totalMonths);
            stmt.setDouble(5, monthlyEMI);
            stmt.setInt(6, monthsPaid);
            stmt.setDouble(7, totalPaid);
            stmt.setInt(8, remainingMonths);
            stmt.setDouble(9, remainingAmount);
            
            stmt.executeUpdate();
            System.out.println("Loan details saved to the database.");
        } catch (SQLException e) {
            System.out.println("Error saving loan details to the database: " + e.getMessage());
        }
    }
}
