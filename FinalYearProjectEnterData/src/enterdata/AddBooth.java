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

@WebServlet("/AddBooth")
public class AddBooth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid1,bvillage1,bcons1,bcity1,btaluka1,bdistrict1,bstate1,bpin1;
		PrintWriter out=response.getWriter();
		String SQL_QUERY="insert into booth_address values(?,?,?,?,?,?,?,?)";
		bid1=request.getParameter("bid");
		bcons1=request.getParameter("bcons");
		bvillage1=request.getParameter("bvillage");
		bcity1=request.getParameter("bcity");
		btaluka1=request.getParameter("btaluka");
		bdistrict1=request.getParameter("bdistrict");
		bstate1=request.getParameter("bstate");
		bpin1=request.getParameter("bpin");
		String id=AES256.encrypt_it(bid1);
		String cons=AES256.encrypt_it(bcons1);
		String village=AES256.encrypt_it(bvillage1);
		String city=AES256.encrypt_it(bcity1);
		String taluka=AES256.encrypt_it(btaluka1);
		String district=AES256.encrypt_it(bdistrict1);
		String state=AES256.encrypt_it(bstate1);
		String pin=AES256.encrypt_it(bpin1);
		try {
			Connection con=DBConnector.getConnection();
			PreparedStatement pst=con.prepareStatement(SQL_QUERY);
			pst.setString(1, id );
			pst.setString(2, cons);
			pst.setString(3, village);
			pst.setString(4, city);
			pst.setString(5, taluka );
			pst.setString(6, district);
			pst.setString(7, state);
			pst.setString(8, pin);
			int c=pst.executeUpdate();
			if(c==1) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Booth Registered Successfully!');");
				out.println("location='./menu.jsp'");
				out.println("</script>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
