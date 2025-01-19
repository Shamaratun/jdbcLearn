public class MainPostgres {
    public static void main(String[] args) {
        String[][] books = {
                {"Jao Pakhi", "Shieshendu Mukhopaddhai", "Novel","300.00","2005"},
                {"Kalbela", "Shamresh Mojumdar", "Political novel","400.50","January 1, 1983"},
                {"Breaking Dawn", "Stephenie Meyer", "vampire fiction","500.0","2008"},
                {"Sei Somoy", "Sunil Gangapaddai","Novel"," 499.90", "1952 "}
        };

        BooksPostgres postgresql = new BooksPostgres();
        postgresql.insertDummyData(books);
    }
}
