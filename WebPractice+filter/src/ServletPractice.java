import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletPractice")
public class ServletPractice extends HttpServlet {
	public void init() {
//		try { 
//			Class.forName("com.mysql.jdbc.Driver");
//			} catch(ClassNotFoundException e){ 
//			   e.printStackTrace(); 
//			  } 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String acc = request.getParameter("account");
//		String pwd = request.getParameter("password");
//		ConnDB  db = new ConnDB();
//		Boolean loginStatus = db.conn(acc, pwd);
//		Check ck = new Check(loginStatus);
//		System.out.println(loginStatus);
//		System.out.println(acc);
//		System.out.println(pwd);
//		
		
		response.getWriter().append("login~");
		
		
	
	}

}
