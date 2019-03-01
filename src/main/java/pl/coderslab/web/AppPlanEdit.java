package pl.coderslab.web;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Plan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/app/plan/edit")
public class AppPlanEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String planName = request.getParameter("planName");
        String planDescription = request.getParameter("planDescription").trim();
        int planId = Integer.parseInt(request.getParameter("planId"));

        Plan plan = new Plan();
        plan.setName(planName);
        plan.setDescription(planDescription);
        plan.setId(planId);

        PlanDao planDao = new PlanDao();
        boolean isUpdated = planDao.update(plan);

        if(isUpdated){
            response.sendRedirect("/app/plan/list");
        }

        response.getWriter().append("fuck-Up!!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String planId = request.getParameter("planId");
        PlanDao planDao = new PlanDao();
        Plan plan = planDao.read(planId);
        request.setAttribute("plan", plan);
        getServletContext().getRequestDispatcher("/appPlanEdit.jsp").forward(request, response);

    }
}
