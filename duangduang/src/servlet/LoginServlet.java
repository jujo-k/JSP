package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		Boolean isLogin = (Boolean) session.getAttribute("isLogin");
		
		if(isLogin == null) {
			isLogin = false;
		}
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(isLogin == false ||(isLogin ==true && username!=request.getSession().getValue(username) )) {
		
			My_Users u =new My_Users();
			u.setUserName(username);
			u.setPassWord(password);
			checkLogin check = new checkLogin();
			if(check.checkUsers(u)) {	
				session.setAttribute("username", username);
				//写Cookie
				if(request.getParameter("checkbox")!=null) {
					System.out.println("开始写cookie");
					
					Cookie nameCookie = new Cookie("name",username);
					Cookie pswCookie = new Cookie("psw",password);
					nameCookie.setMaxAge(60*60*24);
					nameCookie.setPath("/");
					pswCookie.setMaxAge(60*60*24);
					pswCookie.setPath("/");
					response.addCookie(nameCookie);
					System.out.println("添加了"+username);
					response.addCookie(pswCookie);
				}else {
					Cookie c1=null,c2=null;
					Cookie[] cookies = request.getCookies();
					if(cookies!=null && cookies.length!=0){
						for(Cookie c:cookies){
							if(c.getName().equals("name")){
								c1 = c;
							}
							if(c.getName().equals("psw")){
								c2 = c;
								
							}
						}
						System.out.println("删除了"+c1.getValue());
						if(c1!=null) {
							c1.setMaxAge(0);
							response.addCookie(c1);
						}
						
						if(c2!=null) {
							c2.setMaxAge(0);
							response.addCookie(c2);
						}
					}
				}
				
				//跳转到另一个页面
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}
			else { 
				response.sendRedirect(request.getContextPath()+"/fail.jsp");
			}
		}else {
			if(request.getParameter("checkbox")==null) {
			Cookie c1=null,c2=null;
			Cookie[] cookies = request.getCookies();
			if(cookies!=null && cookies.length!=0){
				for(Cookie c:cookies){
					if(c.getName().equals("name")){
						c.setMaxAge(0);
						response.addCookie(c);
					}
					if(c.getName().equals("psw")){
						c.setMaxAge(0);
						response.addCookie(c);
						
					}
				}
				System.out.println("删除了"+c1.getValue());
//				if(c1!=null) {
//					c1.setMaxAge(0);
//					response.addCookie(c1);
//				}
//				
//				if(c2!=null) {
//					c2.setMaxAge(0);
//					response.addCookie(c2);
//				}
			}
			
		}

			request.getRequestDispatcher("success.jsp").forward(request, response);
		}
		
	}

}
