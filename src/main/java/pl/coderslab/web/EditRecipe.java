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
import java.time.LocalDateTime;

@WebServlet(name = "EditRecipe", urlPatterns = "/app/recipe/edit")
public class EditRecipe extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        String name = request.getParameter( "name" );   // nazwa
        String description = request.getParameter( "description" );   //opis
        String preparation = request.getParameter( "preparation" );   //sposob
        int preparationTime = Integer.parseInt( request.getParameter( "preparationTime" ) );   // czas
        String ingredients = request.getParameter( "ingredients" );   //skladniki
        Recipe recipe = new Recipe();
        recipe.setName( name );
        recipe.setDescription( description );
        recipe.setPreparation( preparation );
        recipe.setPreparation_time( preparationTime );
        recipe.setIngredients( ingredients );
        recipe.setAdmin_id(Integer.valueOf( session.getAttribute( "adminID" ).toString() ));
//        recipe.setUpdated(LocalDateTime.now().toString());

        int recipeId = Integer.valueOf( session.getAttribute( "recipeId" ).toString() );
        recipe.setId( recipeId );
        RecipeDao recipeDao = new RecipeDao();
        recipeDao.update( recipe );
        response.sendRedirect( "/app/recipe/list/" );

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String idPararm = request.getParameter( "recipeId" );
        session.setAttribute( "recipeId", idPararm );
        int id = Integer.valueOf( idPararm );
        Recipe recipe = new Recipe();
        RecipeDao recipeDao = new RecipeDao();
        recipe = recipeDao.read( id );
        session.setAttribute( "name", recipe.getName() );
        session.setAttribute( "description", recipe.getDescription() );
        session.setAttribute( "preparationTime", recipe.getPreparation_time() );
        session.setAttribute( "preparation", recipe.getPreparation() );
        session.setAttribute( "ingredients", recipe.getIngredients() );

        response.sendRedirect( "/editRecipe.jsp" );

    }
}
