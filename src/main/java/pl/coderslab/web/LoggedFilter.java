package pl.coderslab.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoggedFilter", urlPatterns = "/app/*")
public class LoggedFilter implements Filter {
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/login";

        boolean loggedIn = session != null && session.getAttribute( "id" ) != null;
        boolean loginRequest = request.getRequestURI().equals( loginURI );

        if (loggedIn || loginRequest) {
            chain.doFilter( request, response );
        } else {
            response.sendRedirect( loginURI );
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
