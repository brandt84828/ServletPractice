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
		try { 
			Class.forName("com.mysql.jdbc.Driver");
			} catch(ClassNotFoundException e){ 
			   e.printStackTrace(); 
			  } 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acc = request.getParameter("account");
		String pwd = request.getParameter("password");
		System.out.println(acc);
		System.out.println(pwd);
		
		conndb();
		
		response.getWriter().append("login~");
		
		
	}
	
	public void conndb() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.print("執行conndb");
		try {
			String dbServer = "jdbc:mysql://localhost:3306/traindb?useSSL=false&serverTimezone=UTC";
			//Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库驱动加载成功");
			
			conn =DriverManager.getConnection(dbServer,"root","secret");
			
			ps = conn.prepareStatement("select account,password from user2 where account=?");
			ps.setString(1, "AAA");
			rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("login success");
			}else {
				System.out.println("login error");
			}
			
			if(!conn.isClosed()) System.out.print("AA");
		} catch (Exception e) {
			
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				
			}
			
			try {
				if(ps!=null) {
					ps.close();
				}
				
			} catch (SQLException e) {
				
			}
			
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				
			}
		}
	}

}
