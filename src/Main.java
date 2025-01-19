public class Main {
            public static void main(String[] args) {

                String[][] students = {
                        {"John Doe", "20", "john.doe@gmail.com"},
                        {"Jane Smith", "22", "jane.smith@gmail.com"},
                        {"Alice Johnson", "19", "alice.johnson@gmail.com"},
                        {"Bob Brown", "21", "bob.brown@gmail.com"}
                };

        InsertStudentData postgresql = new InsertStudentData();
        postgresql.insertDummyData(students);

//                InsertStudentOracle oracle = new InsertStudentOracle();
//                oracle.insertDummyData(students);
            }
        }
