package enterdata;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/ConResult")
public class ConResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s=request.getParameter("rcons");
		request.setAttribute("cons9", s);
		String es=AES256.encrypt_it(s);
		String sql="select vote_count,candidates.c_id,c_name,c_party from votes,candidates where c_constituency=? and votes.c_id=candidates.c_id";
		try {
			Connection con=DBConnector.getConnection();
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, es); 
			ResultSet rs123=pst.executeQuery();
			int i=1;
			while(rs123.next()) {
				//session.setAttribute("canId", rs123.getString("c_id"));
					String id=AES256.decrypt_it(rs123.getString("c_id"));
					String name=AES256.decrypt_it(rs123.getString("c_name"));
					String party=AES256.decrypt_it(rs123.getString("c_party"));
					int count1=rs123.getInt("vote_count");
					request.setAttribute("cid"+i, id);
					request.setAttribute("cname"+i, name);
					request.setAttribute("cparty"+i, party);
					request.setAttribute("vcount"+i, count1);
					i++;
			}
			int count=i-1;
			request.setAttribute("numberOfCandidates", count);
		RequestDispatcher rd= request.getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
	}catch(Exception e){
		Logger.getLogger(ConResult.class.getName()).log(Level.SEVERE, null, e);
	}
	}
}
