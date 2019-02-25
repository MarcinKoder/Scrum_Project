package pl.coderslab.dao;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.exception.NotFoundException;
import pl.coderslab.model.Admin;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
    private static final String CREATE_ADMIN_QUERY = "INSERT INTO admins (first_name, last_name, email, password, " +
            "superadmin, enable) VALUES (?,?,?,?,?,?)";
    private static final String READ_ADMIN_BY_EMAIL_QUERY = "SELECT * FROM admins WHERE email=?";
    private static final String READ_ALL_ADMIN_QUERY = "SELECT * FROM admins";
    private static final String UPDATE_ADMIN_QUERY = "UPDATE admins SET first_name=?, last_name=?, email=?, " +
            "password=?, superadmin=?, enable=?";
    private static final String DELETE_ADMIN_QUERY = "DELETE FROM admins WHERE id=?";


    public Admin create(Admin admin) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_ADMIN_QUERY,
                                                                       PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, admin.getFirstName());
            insertStm.setString(2, admin.getLastName());
            insertStm.setString(3, admin.getEmail());
            insertStm.setString(4, admin.getPassword());
            insertStm.setInt(5, admin.getSuperadmin());
            insertStm.setInt(6, admin.getEnable());
            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {

                if (generatedKeys.first()) {
                    admin.setId(generatedKeys.getInt(1));
                    return admin;
                } else {
                    throw new RuntimeException("Genereted key was not found");
                }
            }

        } catch (SQLException e) {
            System.out.println("to ten błąd wywala.");
            e.printStackTrace();
        }
        return null;
    }

    public List<Admin> readAll() {
        List<Admin> admins = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_ALL_ADMIN_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Admin adminToAdd = new Admin();
                adminToAdd.setId(resultSet.getInt("id"));
                adminToAdd.setFirstName(resultSet.getString("first_name"));
                adminToAdd.setLastName(resultSet.getString("last_name"));
                adminToAdd.setEmail(resultSet.getString("email"));
                adminToAdd.setSuperadmin(resultSet.getInt("superadmin"));
                adminToAdd.setEnable(resultSet.getInt("enable"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    public void update(Admin admin) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement updateStm = connection.prepareStatement(UPDATE_ADMIN_QUERY)) {
            updateStm.setString(1, admin.getFirstName());
            updateStm.setString(2, admin.getLastName());
            updateStm.setString(3, admin.getEmail());
            updateStm.setString(4, admin.getPassword());
            updateStm.setInt(5, admin.getSuperadmin());
            updateStm.setInt(6, admin.getEnable());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int adminId) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement delStm = connection.prepareStatement(DELETE_ADMIN_QUERY)) {
            delStm.setInt(1, adminId);
            delStm.executeUpdate();

            boolean deleted = delStm.execute();
            if (!deleted) {
                throw new NotFoundException("Product not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean login(String email, String enteredPassword){
        try(Connection connection = DbUtil.getConnection();
            PreparedStatement readStm = connection.prepareStatement(READ_ADMIN_BY_EMAIL_QUERY)){
            readStm.setString(1, email);
            ResultSet resultSet = readStm.executeQuery();

            String password="";
            if(resultSet.next()){
                password = resultSet.getString("password");
            }
            if(BCrypt.checkpw(enteredPassword, password)){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
