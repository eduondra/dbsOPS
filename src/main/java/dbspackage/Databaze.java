package dbspackage;

import java.sql.*;

public class Databaze {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/c3zoo", "root", "cd."
        );

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
                "SELECT zvirata.jmeno, druhy.nazev, zvirata.id FROM zvirata JOIN druhy ON (zvirata.druh = druhy.id) WHERE druhy.nazev LIKE 'osel' LIMIT 10"
        );

        while(result.next()) {

            String jmeno = result.getString("jmeno");
            String druh = result.getString("nazev");
            int id = result.getInt("id");

            System.out.println(druh + ";" + jmeno + ";" + id);
            System.out.println("---------------------------");

        }

        connection.close();

    }
}
