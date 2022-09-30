package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    User user = new User();
    Connection connection = getConnection();

    private Connection getConnection() {
        return connection;
    }

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {

    }

    public void dropUsersTable() {

    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        Statement prepareStatement;
        String sql = "INSERT INTO MYSQL(NAME, LASTNAME, AGE) value (?, ?, ?)";

        prepareStatement = connection.prepareStatement(sql);
       // prepareStatement.setCursorName(name);
//       prepareStatement.set

        // prepareStatement.e
        prepareStatement.close();
        if(connection != null) {
            connection.close();
        }
    }

    public void removeUserById(long id) throws SQLException {
        PreparedStatement preparedStatement;
        String sql = "DELETE FROM USER WHERE ID=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,user.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        if(connection != null) {
            connection.close();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT ID, NAME, LASTNAME, AGE";
        Statement statement;
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            user.setId(resultSet.getLong("ID"));
            user.setName(resultSet.getString("NAME"));
            user.setLastName(resultSet.getString("LASTNAME"));
            user.setAge(resultSet.getByte("AGE"));
            userList.add(user);
        }
        statement.close();
        if(connection != null) {
            connection.close();
        }
        return userList;
    }

    public void cleanUsersTable() {

    }
}
