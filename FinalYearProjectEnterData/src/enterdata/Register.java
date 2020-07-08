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


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String bid,bname,buser,bpass,bpass1;
    private int a=0;
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	String SQL="insert into booth_login values(?,?,?,?,?)";
	bid=request.getParameter("bid");
	bname=request.getParameter("bname");
	buser=request.getParameter("buser");
	bpass=request.getParameter("bpass");
	bpass1=request.getParameter("bpass1");
	if(!bpass.equals(bpass1)) {
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Passwords Doesn't Match!');");
		out.println("location='./register.jsp'");
		out.println("</script>");
	}
	String id=AES256.encrypt_it(bid);
	String name=AES256.encrypt_it(bname);
	String user=AES256.encrypt_it(buser);
	String password=BCryptHash.genHash(bpass);
	String pass=AES256.encrypt_it(password);
	try {
		Connection con=DBConnector.getConnection();
		PreparedStatement pst=con.prepareStatement(SQL);
		pst.setString(1, id );
		pst.setString(2, name);
		pst.setString(3, user );
		pst.setString(4, pass);
		pst.setInt(5, a);
		int c=pst.executeUpdate();
		if(c==1) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registered Successfully!');");
			out.println("location='./index.jsp'");
			out.println("</script>");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

}
