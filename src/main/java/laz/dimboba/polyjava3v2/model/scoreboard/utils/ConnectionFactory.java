package laz.dimboba.polyjava3v2.model.scoreboard.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getNewConnection() throws SQLException{
        String url = "jdbc:postgresql://localhost:5432/polyjava3";
        String user = "postgres";
        String passwd = "qwe";
        return DriverManager.getConnection(url, user, passwd);

    }
}
