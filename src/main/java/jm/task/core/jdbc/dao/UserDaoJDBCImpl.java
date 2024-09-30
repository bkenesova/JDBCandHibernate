package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection connection = Util.getConnection();) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS UserTo (id serial PRIMARY KEY, name VARCHAR,lastName VARCHAR,age INT)");
        } catch (SQLException e) {
            System.out.println(e);
        }


    }

    public void dropUsersTable() {
        try (Connection connection = Util.getConnection();) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE UserTo");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getConnection();) {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO UserTo (name,lastName,age) VALUES ('" + name + "','" + lastName + "','" + age + "')";
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void removeUserById(long id) {
        try (Connection connection = Util.getConnection();) {
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM UserTo WHERE Id = '" + id + "'";
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = Util.getConnection();) {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM UserTo";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge((byte) resultSet.getInt("age"));

                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return users;
    }

    public void cleanUsersTable() {
        try (Connection connection = Util.getConnection();) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM UserTo");

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}