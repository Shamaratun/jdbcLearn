import java.sql.*;

public class BooksPostgres {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres"; // Replace with your DB URL
    private static final String USER = "postgres"; // Replace with your DB username
    private static final String PASSWORD = "isdb62"; // Replace with your DB password

    public void insertDummyData(String[][] books) {
        String insertQuery = "INSERT INTO book (name, author,genre,price,publish_date ) VALUES (?, ?, ?,?,?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            for (String[] book : books) {
                preparedStatement.setString(1, book[0]); // Name
                preparedStatement.setString(2, book[1]); // author
                preparedStatement.setString(3, book[2]); // genre
                preparedStatement.setDouble(4, Double.parseDouble(book[3]));
                preparedStatement.setDate(5, Date.valueOf(book[4]));

                preparedStatement.addBatch(); // Add to batch for batch execution
            }

            int[] rowsInserted = preparedStatement.executeBatch();
            System.out.println("Rows inserted: " + rowsInserted.length);

        } catch (SQLException e) {
            // Handle SQL exceptions in a single block
            System.err.println("SQL Error: " + e.getSQLState() + ", Code: " + e.getErrorCode());
            System.err.println("Error message: " + e.getMessage());
            e.printStackTrace();
        }
    }

}



