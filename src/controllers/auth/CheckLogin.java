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
 * @author tranphuquy19@gmail.com
 * @since 01/11/2019
 */
@WebFilter(urlPatterns = {"/students"})
public class CheckLogin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String currentUsername = (String) request.getSession().getAttribute(Constants.SS_LOGIN);
        if (currentUsername == null) response.sendRedirect(request.getContextPath() + "/login");
        else{
            User user = UserBO.getUser(currentUsername);
            if(user != null){
                chain.doFilter(req, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
