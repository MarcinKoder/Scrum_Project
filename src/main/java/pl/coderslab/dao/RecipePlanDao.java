package pl.coderslab.dao;

import pl.coderslab.model.Plan;
import pl.coderslab.model.RecipePlan;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RecipePlanDao {
    private static final String READ_RECIPE_PLAN_BY_PLAN_QUERY = "select * from recipe_plan where plan_id=? order by day_name_id, recipe_plan.order;";


    public List<RecipePlan> read(Plan plan) {
        List<RecipePlan> recipePlans = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection(); PreparedStatement statement = connection.prepareStatement(READ_RECIPE_PLAN_BY_PLAN_QUERY)) {
            statement.setInt(1, plan.getId());
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    RecipePlan recipePlan = new RecipePlan();
                    recipePlan.setId(resultSet.getInt("id"));
                    recipePlan.setRecipe(new RecipeDao().read(resultSet.getInt("recipe_id")));
                    recipePlan.setMealName(resultSet.getString("meal_name"));
                    recipePlan.setOrder(resultSet.getInt("order"));
                    recipePlan.setDayName(new DayNameDao().readById(resultSet.getInt("day_name_id")));
                    recipePlan.setPlan(new PlanDao().read(resultSet.getString("plan_id")));
                    recipePlans.add(recipePlan);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipePlans;
    }
}