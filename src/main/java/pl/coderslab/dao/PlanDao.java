package pl.coderslab.dao;

import pl.coderslab.exception.NotFoundException;
import pl.coderslab.model.Plan;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanDao {
    private static final String CREATE_PLAN = "INSERT INTO plan(name, description, created) VALUES(?,?,?)";
    private static final String READ_PLAN = "SELECT * FROM plan WHERE name=?";
    private static final String UPDATE_PLAN = "UPDATE plan SET name=?, description=? created=? WHERE name=?";
    private static final String DELETE_PLAN = "DELETE FROM plan WHERE name=?";

    public Plan create(Plan plan){
        try (Connection connection = DbUtil.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PLAN, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, plan.getName());
            preparedStatement.setString(2, plan.getDescription());
            preparedStatement.setString(3, plan.getCreated());
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
    public void  update(Plan plan){
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PLAN);
            preparedStatement.setString(1,plan.getName());
            preparedStatement.setString(2, plan.getDescription());
            preparedStatement.setString(3, plan.getCreated());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean delete(String planName){
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PLAN);
            preparedStatement.setString(1,planName);
            return preparedStatement.executeUpdate()>0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
