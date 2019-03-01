package pl.coderslab.dao;

import pl.coderslab.model.DayName;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DayNameDao {

    private static final String FIND_ALL_DAYS_QUERY = "SELECT * FROM day_name";
    private static final String FIND_DAY_BY_ID_QUERY = "SELECT * from day_name where id = ?";

    public DayName readById(int id) {
        DayName dayName = new DayName();
        try (Connection connection = DbUtil.getConnection(); PreparedStatement statement = connection.prepareStatement(FIND_DAY_BY_ID_QUERY)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                dayName.setId(resultSet.getInt("id"));
                dayName.setName(resultSet.getString("name"));
                dayName.setOrder(resultSet.getInt("order"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return dayName;
    }

    public List<DayName> findAll() {
        List<DayName> daysName = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_DAYS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                DayName dayToAdd = new DayName();
                dayToAdd.setId(resultSet.getInt("id"));
                dayToAdd.setName(resultSet.getString("name"));
                dayToAdd.setOrder(resultSet.getInt("order"));
                daysName.add(dayToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daysName;

    }
}
