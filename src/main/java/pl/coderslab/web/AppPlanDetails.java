package pl.coderslab.web;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.dao.RecipePlanDao;
import pl.coderslab.model.Plan;
import pl.coderslab.model.Recipe;
import pl.coderslab.model.RecipePlan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/app/plan/details")
public class AppPlanDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        PlanDao planDao = new PlanDao();
        Plan plan = planDao.read(id);
        RecipePlanDao recipePlanDao = new RecipePlanDao();

        List <RecipePlan> recipePlanList = recipePlanDao.read(plan.getId());

        request.setAttribute("namePlan", plan.getName());
        request.setAttribute("planDescription", plan.getDescription());
        request.setAttribute("recipePlan", recipePlanList);


        getServletContext().getRequestDispatcher("/appPlanDetails.jsp").forward(request, response);

    }
}
