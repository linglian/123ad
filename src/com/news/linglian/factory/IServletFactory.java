package com.news.linglian.factory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IServletFactory {
	public void doThing(HttpServletRequest request,
			HttpServletResponse response, HttpServlet serlvet,
			String factoryName) throws ServletException, IOException;
}
