package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jm.task.core.jdbc.util.Util;

public class UserDaoJDBCImpl implements UserDao {
    private String createUsersQuery = "create table if not exists users" +
            "(id INT AUTO_INCREMENT PRIMARY KEY NOT NULL," +
            " name VARCHAR(64) NOT NULL," +
            " lastName VARCHAR(64) NOT NULL, age TINYINT)";
    private String dropUsersQuery = "drop table if exists users";
    private String saveUserQuery = "insert into users (name, lastname, age) VALUES(?, ?, ?)";
    private String removeUserByIdQuery = "delete from users where id = ?";
    private String getAllUsersQuery = "select * from users";
    private String cleanUsersQuery = "truncate table users";
    private List<User> usersList = new ArrayList<>();
    private Connection connection;

    public UserDaoJDBCImpl() {
        connection = new Util().getConnection();
    }

    public void createUsersTable() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(createUsersQuery)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(dropUsersQuery)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(saveUserQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(removeUserByIdQuery)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(getAllUsersQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery(getAllUsersQuery);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public void cleanUsersTable() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(cleanUsersQuery)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}