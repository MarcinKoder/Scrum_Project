package pl.coderslab.web;

import org.apache.commons.lang3.StringUtils;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/app/recipe/add")
public class AddRecipe extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        HttpSession session = request.getSession();
        int adminId = (int) session.getAttribute("adminID");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String preparationTime = request.getParameter("preparationTime");
        String preparation = request.getParameter("preparation");
        String ingredients = request.getParameter("ingredients");

        int whatError;

        if (StringUtils.isBlank(name) || StringUtils.isBlank(description) || StringUtils.isBlank(preparationTime) || StringUtils.isBlank(preparation) || StringUtils.isBlank(ingredients)) {
            whatError = 1;  //incompleteForm
            request.setAttribute("whatError", whatError);
            getServletContext().getRequestDispatcher("/addRecipe.jsp").forward(request, response);
        }

        int preparationTimeInt = Integer.parseInt(preparationTime);
        Recipe recipe = new Recipe(name, ingredients, description, preparationTimeInt, preparation, adminId);
        RecipeDao.create(recipe);

        if (recipe.getId() == 0) {
            whatError = 2; //unsuccessful saving in DB
            request.setAttribute("whatError", whatError);
            getServletContext().getRequestDispatcher("/addRecipe.jsp").forward(request, response);
        }

        response.sendRedirect("/app/recipe/list/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        getServletContext().getRequestDispatcher("/addRecipe.jsp").forward(request, response);
    }
}
