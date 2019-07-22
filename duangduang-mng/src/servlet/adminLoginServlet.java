package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.checkLogin;
import entity.My_GoodsAdminuser;
import entity.My_Users;

/**
 * Servlet implementation class adminLogiServlet
 */
@WebServlet("/adminLogiServlet")
public class adminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		My_GoodsAdminuser ad =new My_GoodsAdminuser();
		String adusername = request.getParameter("username");
		String adpassword = request.getParameter("password");
		ad.setAdminUser(adusername);
		ad.setAdminPass(adpassword);
		//存到session中，方便后面使用
		request.getSession().setAttribute(adusername, adpassword);
		
		checkLogin check = new checkLogin();
		if(check.checkAdmin(ad)) {		
				response.sendRedirect(request.getContextPath()+"/test.jsp");
		}
		else { 
			response.sendRedirect(request.getContextPath()+"/fail.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
