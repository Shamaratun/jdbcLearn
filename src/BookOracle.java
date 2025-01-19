import java.sql.*;

public class BookOracle {
        private static final String URL = "jdbc:oracle:thin:@localhost:1521/ORCLPDB"; // Service Name
        // private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCLPDB"; // SID
        private static final String USER = "orclpdbuser";
        private static final String PASSWORD = "isdb62";

        public void insertDummyData(String[][] books) {
            String insertQuery = "INSERT INTO BOOK (name, author,genre,price,publish_date) VALUES (?,?,?, ?, ?)";

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

                for (String[] book : books) {
                    preparedStatement.setString(1, book[0]); // Name
                    preparedStatement.setString(2, book[1]);
                    preparedStatement.setString(3, book[2]);
                    preparedStatement.setDouble(4, Double.parseDouble(book[3]));
                    preparedStatement.setDate(5, Date.valueOf(book[4]));
                    preparedStatement.addBatch(); // Add to batch for batch execution
                }

                int[] rowsInserted = preparedStatement.executeBatch();
                System.out.println("Rows inserted: " + rowsInserted.length);

            } catch (SQLException e) {
                System.err.println("Error inserting data: " + e.getMessage());
            }
        }
    }


