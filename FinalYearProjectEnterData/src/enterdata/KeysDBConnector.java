package enterdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class KeysDBConnector{
        static String sql="jdbc:sqlite:Keys.db";
        public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("org.sqlite.JDBC");
        Connection connection1 = DriverManager.getConnection(sql);
        return connection1;
    }
}
