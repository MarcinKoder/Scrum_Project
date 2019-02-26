package pl.coderslab.web;

import org.apache.commons.lang3.StringUtils;
import pl.coderslab.dao.AdminDao;
import pl.coderslab.model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class AppRegisterPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("passwordRepeat");

        if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName) || StringUtils.isBlank(email) || StringUtils.isBlank(password) || StringUtils.isBlank(passwordRepeat)) {
            response.getWriter().append("Niepoprawne dane");
            return;
        }

        if (!password.equals(passwordRepeat)) {
            response.getWriter().append("Hasło nie zostało prawidłowo powtórzone");
            getServletContext().getRequestDispatcher("/registerRepeat.jsp").forward(request, response);
            return;
        }

        Admin admin = new Admin(firstName, lastName, email, password);
        AdminDao adminDao = new AdminDao();
        adminDao.create(admin);

        request.setAttribute("admin", admin);

        getServletContext().getRequestDispatcher("/login").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
    }
}

