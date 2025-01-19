import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class InsertStudentData {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres"; // Replace with your DB URL
    private static final String USER = "postgres"; // Replace with your DB username
    private static final String PASSWORD = "isdb62"; // Replace with your DB password

    public void insertDummyData(String[][] students) {
        String insertQuery = "INSERT INTO student (name, age, email) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            for (String[] student : students) {
                preparedStatement.setString(1, student[0]); // Name
                preparedStatement.setInt(2, Integer.parseInt(student[1])); // Age
                preparedStatement.setString(3, student[2]); // Email

                preparedStatement.addBatch(); // Add to batch for batch execution
            }

            int[] rowsInserted = preparedStatement.executeBatch();
            System.out.println("Rows inserted: " + rowsInserted.length);

        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
        }
    }
}

