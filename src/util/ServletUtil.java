package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtil {

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
        System.out.println(request.getServletPath() + "转发到" + page);
        request.getRequestDispatcher(page).forward(request, response);
    }

    public static void forward(HttpServletRequest request,
            HttpServletResponse response, HttpServlet servlet,
            String parameterName) throws ServletException, IOException {
        forward(request, response,
                servlet.getServletConfig().getInitParameter(parameterName));
    }

    /**
     * 跳转（red）给指定页面
     *
     * @param request
     * @param response
     * @param page
     * @throws ServletException
     * @throws IOException
     */
    public static void redirect(HttpServletRequest request,
            HttpServletResponse response, String page) throws ServletException,
            IOException {
        System.out.println(request.getServletPath() + "跳转到" + page);
        response.sendRedirect(page);
    }

    public static void redirect(HttpServletRequest request,
            HttpServletResponse response, HttpServlet servlet,
            String parameterName) throws ServletException, IOException {
        redirect(request, response,
                servlet.getServletConfig().getInitParameter(parameterName));
    }
}
