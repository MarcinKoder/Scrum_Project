package pl.coderslab.web;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Plan;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddRecipeToPlan", urlPatterns = "/app/recipe/plan/add")
public class AddRecipeToPlan extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int recipeId = Integer.valueOf(request.getParameter("recipie"));
        String mealName = request.getParameter("mealName");
        int order  = Integer.valueOf(request.getParameter("order"));
        int dayNameId = Integer.valueOf(request.getParameter("day"));
        int planId = Integer.valueOf(request.getParameter("choosePlan"));
        PlanDao.newRecipePlan(recipeId,mealName,order,dayNameId,planId);
        response.sendRedirect("/app/recipe/plan/add");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();
        int id = (int)sess.getAttribute("adminID");
        List<Plan> plans = PlanDao.findAllFromUser(id);
        sess.setAttribute("planNames", plans);
        List<Recipe> recipes = RecipeDao.findAllByAdmin(id);
        sess.setAttribute("recipes", recipes);
        response.sendRedirect( "/addRecipeToPlan.jsp" );
    }
}
