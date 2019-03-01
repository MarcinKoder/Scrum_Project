package pl.coderslab.dao;

import pl.coderslab.exception.NotFoundException;
import pl.coderslab.model.Plan;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanDao {
    private static final String CREATE_PLAN = "INSERT INTO plan(name, description, created, admin_id) VALUES(?,?,NOW(),?)";
    private static final String READ_PLAN = "SELECT * FROM plan WHERE id=?";
    private static final String UPDATE_PLAN = "UPDATE plan SET name=?, description=? created=? WHERE id=?";
    private static final String DELETE_PLAN = "DELETE FROM plan WHERE id=?";
    private static final String FIND_ALL_PLANS_QUERY = "SELECT * FROM plan";
    private static final String HOW_MANY_PLANS = "SELECT COUNT(*) as plans FROM plan WHERE admin_id = ?";
    private static final String LAST_PLAN = "SELECT name FROM plan WHERE admin_id = ? ORDER BY created desc LIMIT 1";
    private static final String FIND_ALL_FROM_USER_QUERY = "SELECT * from plan where admin_id = ?";
    private static final String INSERT_RECIPE_INTO_PLAN_QUERY = "INSERT INTO recipe_plan (recipe_id,meal_name,`order`,day_name_id,plan_id) VALUES (?,?,?,?,?)";

    public static Plan create(Plan plan){
        try (Connection connection = DbUtil.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PLAN, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, plan.getName());
            preparedStatement.setString(2, plan.getDescription());
//            preparedStatement.setString(3, plan.getCreated());
            preparedStatement.setInt(3, plan.getAdminId());
            int result = preparedStatement.executeUpdate();

            if(result != 1){
                throw new RuntimeException("Execute update returned" + result);
            }
            try(ResultSet generatedKeys = preparedStatement.getGeneratedKeys()){
                if(generatedKeys.first()){
                    plan.setId(generatedKeys.getInt(1));
                    return plan;
                }else {
                    throw new RuntimeException("Generated Key was not found");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Plan read(String planName){
        Plan plan = new Plan();
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(READ_PLAN);
            preparedStatement.setString(1,planName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    plan.setId(resultSet.getInt("id"));
                    plan.setName(resultSet.getString("name"));
                    plan.setDescription(resultSet.getString("description"));
                    plan.setCreated(resultSet.getString("created"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plan;
    }
    public boolean update(Plan plan){
        boolean updated = false;
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PLAN);
            preparedStatement.setInt(3, plan.getId());
            preparedStatement.setString(1, plan.getName());
            preparedStatement.setString(2, plan.getDescription());
            int isUpdated = preparedStatement.executeUpdate();
            updated = isUpdated != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    public boolean delete(int planId){
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PLAN);
            preparedStatement.setInt(1,planId);
            return preparedStatement.executeUpdate()>0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public static List<Plan> findAll() {
        List<Plan> planList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_PLANS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Plan planToAdd = new Plan();
                planToAdd.setId(resultSet.getInt("id"));
                planToAdd.setName(resultSet.getString("name"));
                planToAdd.setDescription(resultSet.getString("description"));
                planToAdd.setCreated(resultSet.getString("created"));
                planToAdd.setAdminId(resultSet.getInt("adminId"));
                planList.add(planToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planList;
    }

    public static int howManyPlans(int id) {

        int count = 0;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement countStatement = connection.prepareStatement(HOW_MANY_PLANS)) {
            countStatement.setInt(1, id);
            try (ResultSet resultSet = countStatement.executeQuery()) {
                resultSet.next();
                count = resultSet.getInt("plans");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static String lastPlan(int id) {
        String lastPlan = "";
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(LAST_PLAN)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                lastPlan = resultSet.getString("name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lastPlan;
    }

    public static void newRecipePlan(int recipeId, String mealName, int order, int dayNameId, int planId) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_RECIPE_INTO_PLAN_QUERY)) {
            statement.setInt(1, recipeId);
            statement.setString(2, mealName);
            statement.setInt(3, order);
            statement.setInt(4, dayNameId);
            statement.setInt(5, planId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Plan> findAllFromUser(int id) {
        List<Plan> planList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_FROM_USER_QUERY);) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next())
                    if (id == resultSet.getInt("admin_id")) {
                        Plan planToAdd = new Plan();
                        planToAdd.setId(resultSet.getInt("id"));
                        planToAdd.setName(resultSet.getString("name"));
                        planToAdd.setDescription(resultSet.getString("description"));
                        planToAdd.setCreated(resultSet.getString("created"));
                        planToAdd.setAdminId(resultSet.getInt("admin_id"));
                        planList.add(planToAdd);
                    }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planList;

    }
}
