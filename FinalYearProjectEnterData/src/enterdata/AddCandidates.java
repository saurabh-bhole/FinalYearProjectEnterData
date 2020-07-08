package enterdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddCandidates")
public class AddCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;


	byte[] enc;
	byte[] encrypted;
	//AES256 a=new AES256();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid=null;
		FileInputStream fis=null;
		PrintWriter out=response.getWriter();
		try {
	        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	        keyGenerator.init(128);
	        SecretKey key = keyGenerator.generateKey();
	        String keyString=Base64.getEncoder().encodeToString(key.getEncoded());
	        String id=request.getParameter("c_id");
	        String name=request.getParameter("c_name");
	        String cons=request.getParameter("c_cons");
	        String party=request.getParameter("c_party");
			String symbol1=request.getParameter("symbol");
			cid=AES256.encrypt_it(id);
			String cname=AES256.encrypt_it(name);
			String ccons=AES256.encrypt_it(cons);
			String cparty=AES256.encrypt_it(party);
			String ckey=AES256.encrypt_it(keyString);
			File image=new File(symbol1);
            fis=new FileInputStream(image);
			enc=ImageEnc.getFile((InputStream)fis);
			Connection con1=DBConnector.getConnection();
            String sql1="insert into keys_db values(?,?)";
            //ResultSet res1=stmt2.executeQuery("Select name from sqlite_master where type='table' and name='keys_db'");
           // if(!res1.next()){
                PreparedStatement pst=con1.prepareStatement(sql1);
                pst.setString(1, cid);
                pst.setString(2, ckey);
                pst.executeUpdate();
            //}
            encrypted=ImageEnc.encryptPdfFile(key, enc);
            Connection con=DBConnector.getConnection();
            String sql2="insert into votes values(?,0)";
            String sql="insert into candidates values(?,?,?,?,?)";
            PreparedStatement pst1=con.prepareStatement(sql);
            PreparedStatement pst2=con.prepareStatement(sql2);
            pst2.setString(1, cid);
            pst1.setString(1, cid);
            pst1.setString(2, cname );
            pst1.setString(3, ccons );
            pst1.setString(4, cparty );
            pst1.setBytes(5, encrypted);
            pst1.executeUpdate();
            pst2.executeUpdate();
            
            
            
            con1.close();
            //res1.close();
            
            
		}catch(Exception e){
			Logger.getLogger(AddCandidates.class.getName()).log(Level.SEVERE, null, e);
		}finally {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Candidate Added Sucessfully at ID : '"+cid+");");
			out.println("location='addcandidates.jsp';");
			out.println("</script>");
		}
	}


}
