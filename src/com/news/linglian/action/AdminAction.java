package com.news.linglian.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.linglian.factory.IServletFactory;
import com.news.linglian.factoryImpl.IServletFactoryImpl;

/**
 * Servlet implementation class AdminLoginServlet
 * 主要负责admin管理员的登录，默认成功后跳转到admin.jsp，失败则跳转到adminLogin.jsp。
 * 
 * @param adminid
 * @param password
 * @return 存入到request作用域的info中。
 * 
 */
@WebServlet(name = "AdminAction", urlPatterns = "/AdminAction.do", initParams = {
		@WebInitParam(name = "action_factory", value = "com.news.linglian.factoryImpl.IServletFactoryImpl"),
		@WebInitParam(name = "login_from", value = "adminLogin.jsp"),
		@WebInitParam(name = "login_to", value = "admin.jsp") })
public class AdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doThing(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		IServletFactory isf;
		try {
			isf = (IServletFactory) Class.forName(
					this.getServletConfig().getInitParameter("action_factory"))
					.newInstance();
			isf.doThing(request, response, this, method);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doThing(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doThing(request, response);
	}

}
