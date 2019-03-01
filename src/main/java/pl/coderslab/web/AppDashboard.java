package pl.coderslab.web;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipePlanDao;
import pl.coderslab.model.Plan;
import pl.coderslab.model.RecipePlan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static pl.coderslab.dao.PlanDao.howManyPlans;
import static pl.coderslab.dao.PlanDao.lastPlan;
import static pl.coderslab.dao.RecipeDao.recipeCount;

@WebServlet(name = "App", urlPatterns = "/app/dashboard")
public class AppDashboard extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute( "recipes", recipeCount( (int) session.getAttribute( "adminID" ) ) );
        session.setAttribute( "plans", howManyPlans( (int) session.getAttribute( "adminID" ) ) );
//        session.setAttribute( "lastPlan", lastPlan( (int) session.getAttribute( "adminID" ) ) );

        PlanDao planDao = new PlanDao();
        Plan lastAddedPlan = planDao.readLastAdded((int) session.getAttribute("adminID"));
        session.setAttribute("lastAddedPlan",lastAddedPlan);
        session.setAttribute("lastAddedPlanName", lastAddedPlan.getName());
        RecipePlanDao recipePlanDao = new RecipePlanDao();
        List<RecipePlan> recipePlans = recipePlanDao.read(lastAddedPlan);
        session.setAttribute("recipePlans", recipePlans);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost( request, response );
        response.sendRedirect( "/appDashboard.jsp" );
    }
}