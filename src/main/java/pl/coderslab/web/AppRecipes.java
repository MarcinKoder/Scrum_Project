package pl.coderslab.web;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/app/recipe/list/")
public class AppRecipes extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecipeDao recipeDao = new RecipeDao();
        HttpSession session = request.getSession();
        int adminId = (int) session.getAttribute("adminID");
        List<Recipe> recipeList = (List<Recipe>) recipeDao.findAllByAdmin(adminId);

        request.setAttribute("recipeList", recipeList);

        getServletContext().getRequestDispatcher("/app-recipes.jsp").forward(request, response);
    }

}