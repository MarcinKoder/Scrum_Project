package pl.coderslab.dao;

import pl.coderslab.model.Recipe;
import pl.coderslab.model.RecipePlan;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RecipePlanDao {

   // private static final String READ_RECIPE_PLAN_QUERY = "SELECT * FROM recipe_plan where plan_id = ? ORDER BY day_name_id, `order`";
  //  private static final String READ_RECIPE_IDS_QUERY = "SELECT recipe_id FROM recipe_plan where plan_id = ?";

    private static final String READ_RECIPE_PLAN_TABLE_QUERY = "SELECT day_name.name as day_name, meal_name, recipe.name as recipe_name, recipe.id as recipe_id " +
            "FROM `recipe_plan` JOIN day_name on day_name.id=day_name_id JOIN recipe on recipe.id=recipe_id WHERE plan_id = ? ORDER by day_name.order, recipe_plan.order";


    public List<RecipePlan> read(Integer planId) {
        List <RecipePlan> recipePlanList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_RECIPE_PLAN_TABLE_QUERY);
        ) {
            statement.setInt(1, planId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    RecipePlan recipePlan = new RecipePlan();
                    recipePlan.setDayName(resultSet.getString("day_name"));
                    recipePlan.setMealName(resultSet.getString("meal_name"));
                    recipePlan.setRecipeName(resultSet.getString("recipe_name"));
                    recipePlan.setRecipeId(resultSet.getString("recipe_id"));
                    recipePlanList.add(recipePlan);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipePlanList;
    }

   /* public List<RecipePlan> read(Integer planId) {
        List <RecipePlan> recipePlanList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_RECIPE_PLAN_QUERY);
        ) {
            statement.setInt(1, planId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    RecipePlan recipePlan = new RecipePlan();
                    recipePlan.setId(resultSet.getInt("id"));
                    recipePlan.setRecipeId(resultSet.getInt("recipe_id"));
                    recipePlan.setMealName(resultSet.getString("meal_name"));
                    recipePlan.setOrder(resultSet.getInt("order"));
                    recipePlan.setDayNameId(resultSet.getInt("day_name_id"));
                    recipePlan.setPlanId(resultSet.getInt("plan_id"));
                    recipePlanList.add(recipePlan);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipePlanList;

    }

    public List<Integer> readRecipeId(Integer planId) {
        List<Integer> recipeIds = new ArrayList<>();

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_RECIPE_IDS_QUERY);
        ) {
            statement.setInt(1, planId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Integer recipeId = resultSet.getInt("recipe_id");
                    recipeIds.add(recipeId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipeIds;

    } */
}
