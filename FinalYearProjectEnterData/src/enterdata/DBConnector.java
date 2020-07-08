package enterdata;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    
    public static Connection getConnection() throws SQLException{
        //Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost/avs_db", "root", "root");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanced_voting_system", "root", "root");
        return connection1;
    }
    
}