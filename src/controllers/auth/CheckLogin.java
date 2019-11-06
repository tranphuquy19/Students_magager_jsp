package controllers.auth;

import models.BO.UserBO;
import models.Bean.User;
import utils.Constants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter check login, sử dụng session
 * @author tranphuquy19@gmail.com
 * @since 01/11/2019
 */
@WebFilter(urlPatterns = {"/students", "/students-create", "/students-update", "/students-delete", "/students-search", "/list-sv.jsp", "/new-sv.jsp", "/search-results.jsp", "/update-sv.jsp"})
public class CheckLogin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String currentUsername = (String) request.getSession().getAttribute(Constants.SS_LOGIN);
        if (currentUsername == null) response.sendRedirect(request.getContextPath() + "/login");
        else {
            User user = UserBO.getUser(currentUsername); //check user còn tồn tại trong DB hay không?
            if (user != null) {
                chain.doFilter(req, resp);
            }else response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
