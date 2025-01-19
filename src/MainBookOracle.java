public class MainBookOracle {
    public static void main(String[] args) {
        String[][] books = {
                {"Jao Pakhi", "Shieshendu Mukhopaddhai", "Novel","320.56","2005"},
                {"Kalbela", "Shamresh Mojumdar", "Political novel","400.98","1983"},
                {"Breaking Dawn", "Stephenie Meyer", "vampire fiction","300.46","2008"},
                {"Sei Somoy", "Sunil Gangapaddai","Novel", "500.34","1952 "},
                {"Kaser Manush", "Suchitra Vottacharja","Novel", "358.99","1965 "}
        };
        BookOracle oracle = new BookOracle();
        oracle.insertDummyData(books);
    }
    }

