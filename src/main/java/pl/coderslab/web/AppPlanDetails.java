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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/app/plan/details")
public class AppPlanDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String namePlan = request.getParameter("namePlan");
        PlanDao planDao = new PlanDao();
        Plan plan = planDao.read(namePlan);
        RecipePlanDao recipePlanDao = new RecipePlanDao();
        RecipePlan recipePlan = recipePlanDao.read(plan.getId());
        List <Integer> recipeIds = recipePlanDao.readRecipeId(plan.getId());
        Map<Integer, String> recipes = new HashMap<>();
        RecipeDao recipeDao = new RecipeDao();
        int i=1;
        while (recipeIds.size()>=i) {
            recipes.put(recipeIds.get(i), recipeDao.read(recipeIds.get(i)).getName());
        }

        request.setAttribute("namePlan", namePlan);
        request.setAttribute("planDescription", plan.getDescription());
        request.setAttribute("recipesName", recipes);
        request.setAttribute("recipePlan", recipePlan);


        getServletContext().getRequestDispatcher("/appPlanDetails.jsp").forward(request, response);

    }
}
