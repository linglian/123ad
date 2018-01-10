package com.news.linglian.factoryImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linglian.util.ServletUtil;
import com.news.linglian.entity.Admin;
import com.news.linglian.factory.IServletFactory;
import com.news.linglian.service.IAdminService;
import com.news.linglian.serviceImpl.IAdminServiceImpl;

public class IServletFactoryImpl implements IServletFactory {

	@Override
	public void doThing(HttpServletRequest request,
			HttpServletResponse response, HttpServlet serlvet,
			String factoryName) throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch (factoryName) {
		case "login":
			doLogin(request, response, serlvet);
			break;
		}
	}

	protected void doLogin(HttpServletRequest request,
			HttpServletResponse response, HttpServlet serlvet)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String adminid = request.getParameter("adminid");
		String password = request.getParameter("password");
		if ("".equals(adminid)) {
			request.setAttribute("info", "管理员id不能为空!");
			ServletUtil.forward(request, response, serlvet, "login_from");
		} else if ("".equals(password)) {
			request.setAttribute("info", "密码不能为空!");
			ServletUtil.forward(request, response, serlvet, "login_from");
		} else {
			IAdminService ias = new IAdminServiceImpl();
			Admin admin = ias.getAdmin(adminid, password);
			if (admin == null) {
				request.setAttribute("info", "账号或者密码错误!");
				ServletUtil.forward(request, response, serlvet, "login_from");
			} else {
				request.getSession().setAttribute("identity", admin);
				request.setAttribute("info", "登录成功!");
				ServletUtil.forward(request, response, serlvet, "login_to");
			}
		}
	}

}
