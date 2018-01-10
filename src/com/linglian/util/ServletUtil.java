package com.linglian.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class ServletUtil {

    private ServletUtil() {

    }

    /**
     * 转发（forward）给指定页面
     *
     * @param request
     * @param response
     * @param page
     * @throws ServletException
     * @throws IOException
     */
    public static void forward(HttpServletRequest request,
            HttpServletResponse response, String page) throws ServletException,
            IOException {
        request.getRequestDispatcher(page).forward(request, response);
    }

    public static void forward(HttpServletRequest request,
            HttpServletResponse response, HttpServlet servlet,
            String parameterName) throws ServletException, IOException {
        forward(request, response,
                servlet.getServletConfig().getInitParameter(parameterName));
    }
}
