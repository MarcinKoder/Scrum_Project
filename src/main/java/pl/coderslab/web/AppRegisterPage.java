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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html; charset=utf-8");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("passwordRepeat");
        int whatError;

        if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName) || StringUtils.isBlank(email) || StringUtils.isBlank(password) || StringUtils.isBlank(passwordRepeat)) {
            whatError = 1; //incorrect/incomplete data
            request.setAttribute("whatError", whatError);
            getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
        } else {

            Admin admin = new Admin(firstName, lastName, email, password);
            AdminDao adminDao = new AdminDao();
            adminDao.create(admin);

            if (admin.getId() == 0) {
                whatError = 2; //email already use by some admin
                request.setAttribute("whatError", whatError);
                getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
            }
        }



        response.sendRedirect("/login");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
    }
}

