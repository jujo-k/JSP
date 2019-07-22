package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.checkLogin;
import entity.My_Users;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		My_Users u =new My_Users();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		u.setUserName(username);
		u.setPassWord(password);
		//存到session中，方便后面使用
		request.getSession().setAttribute(username, password);
		
		checkLogin check = new checkLogin();
		if(check.checkUsers(u)) {		
				response.sendRedirect(request.getContextPath()+"/test.jsp");
		}
		else { 
			response.sendRedirect(request.getContextPath()+"/fail.jsp");
		}
		
		
		
		
		
	}

}
