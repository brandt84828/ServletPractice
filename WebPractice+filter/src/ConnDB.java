import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnDB {

	public boolean conn(String account,String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Boolean status = false;
		System.out.print("執行conndb");
		try {
			String dbServer = "jdbc:mysql://localhost:3306/traindb?useSSL=false&serverTimezone=UTC";
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库驱动加载成功");
			
			conn =DriverManager.getConnection(dbServer,"root","GGG");
			
			ps = conn.prepareStatement("select account,password from user2 where account=?");
			ps.setString(1, account);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("password").equals(password)){
					System.out.println("login success");
					status = true;
				}
			}else {
				System.out.println("login error");
			}
			
			if(!conn.isClosed()) System.out.print("還在連線中");
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
		
		return status;
	}

}
