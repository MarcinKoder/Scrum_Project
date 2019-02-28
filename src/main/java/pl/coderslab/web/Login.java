package pl.coderslab.web;

import pl.coderslab.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean isLogin;
        AdminDao adminDao = new AdminDao();
        if (adminDao.login(email, password)) {
            request.getSession().setAttribute("id", email);
//            isLogin = true;
//            request.setAttribute("login", isLogin);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

        } else {
            isLogin = false;
            request.setAttribute("login", isLogin);
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
//            doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

    }
}
