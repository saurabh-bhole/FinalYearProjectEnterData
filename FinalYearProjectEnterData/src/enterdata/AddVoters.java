package enterdata;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddVoters")
public class AddVoters extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("addvoters.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql="insert into voter_address values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PrintWriter out=response.getWriter();
		try {
			String vid=request.getParameter("vid");
			String vname=request.getParameter("vname");
			String vcons=request.getParameter("vcons");
			String vward=request.getParameter("vward");
			String vvillage=request.getParameter("vvillage");
			String vcity=request.getParameter("vcity");
			String vtaluka=request.getParameter("vtaluka");
			String vdistrict=request.getParameter("vdistrict");
			String vstate=request.getParameter("vstate");
			String vpincode=request.getParameter("vpin");
			String vaadhar=request.getParameter("vaadhar");
			String vmobile=request.getParameter("vmobile");
			//out.println(vid);
			String id=AES256.encrypt_it(vid);
			String name=AES256.encrypt_it(vname);
			String cons=AES256.encrypt_it(vcons);
			String ward=AES256.encrypt_it(vward);
			String village=AES256.encrypt_it(vvillage);
			String city=AES256.encrypt_it(vcity);
			String taluka=AES256.encrypt_it(vtaluka);
			String district=AES256.encrypt_it(vdistrict);
			String state=AES256.encrypt_it(vstate);
			String pincode=AES256.encrypt_it(vpincode);
			String aadhar=AES256.encrypt_it(vaadhar);
			String mobile=AES256.encrypt_it(vmobile);
			
			out.println(id);
			out.println(name);
			out.println(cons);
			out.println(ward);
			out.println(village);
			out.println(city);
			out.println(taluka);
			out.println(district);
			out.println(state);
			out.println(pincode);
			out.println(aadhar);
			out.println(mobile);
			
//			String sql1="insert into voter_address values('"+id+"','"+name+"','"+cons+"','"+ward+"','"+village+"','"+city+"','"+taluka+"','"+
//									district+"','"+state+"','"+pincode+"','"+aadhar+"','"+mobile+")";
			Connection con11=DBConnector.getConnection();
			PreparedStatement pst12=con11.prepareStatement(sql);
			
			pst12.setString(1,id);
			pst12.setString(2,name);
			pst12.setString(3,cons);
			pst12.setString(4,ward);
			pst12.setString(5,village);
			pst12.setString(6,city);
			pst12.setString(7,taluka);
			pst12.setString(8,district);
			pst12.setString(9,state);
			pst12.setString(10,pincode);
			pst12.setString(11,aadhar);
			pst12.setString(12,mobile);
			
			pst12.executeUpdate();
			

		}catch(Exception e) {
			
		}
	}



}
