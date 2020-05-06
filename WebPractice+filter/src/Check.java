import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/ServletPractice")
public class Check implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		 System.out.println("filter destroy...");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 HttpServletRequest request =(HttpServletRequest)arg0;
		 HttpServletResponse response = (HttpServletResponse)arg1;
		String acc = request.getParameter("account");
		String pwd = request.getParameter("password");
		System.out.println(acc);
		System.out.println(pwd);
		ConnDB  db = new ConnDB();
		Boolean loginStatus = db.conn(acc, pwd);
		System.out.println(loginStatus);

		System.out.println("filter doFilter...");
		if(loginStatus) {
			arg2.doFilter(request, response);	
		}else {
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}

		 
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter init...");
	}

}
