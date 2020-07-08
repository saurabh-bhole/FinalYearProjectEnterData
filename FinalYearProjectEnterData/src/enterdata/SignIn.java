package enterdata;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enterdata.DBConnector;

@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String sql="insert into voter_info values(?,'576283761753','1',?)";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String i=request.getParameter("voter_id");
		String j=request.getParameter("mobile_no");
//		try {
//			//Class.forName("com.mysql.jdbc.Driver");
//	        //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/avs_db", "root", "root");
//			Connection con=DBConnector.getConnection();
//			PreparedStatement pst=con.prepareStatement(sql);
//			pst.setString(1,i);
//			pst.setString(2,j);
//			pst.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
response.sendRedirect("menu.jsp");
	}

}
