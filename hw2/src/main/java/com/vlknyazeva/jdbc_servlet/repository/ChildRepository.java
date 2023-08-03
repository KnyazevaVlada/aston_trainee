package com.vlknyazeva.jdbc_servlet.repository;

import com.vlknyazeva.jdbc_servlet.entity.Child;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChildRepository extends JDBCUtils {

    public static final String SELECT_ALL_FROM_CHILD = "SELECT * FROM child";
    public static final String INSERT_INTO_CHILD = "INSERT INTO child VALUES (?, ?)";
    public static final String DELETE_BY_ID = "DELETE FROM child WHERE id=?";
    public static final String UPDATE_BY_ID = "UPDATE child SET name=?, surname=? WHERE id=?";

    public static final String COLUMN_LABEL_ID = "id";
    public static final String COLUMN_LABEL_NAME = "name";
    public static final String COLUMN_LABEL_SURNAME = "surname";

    Connection connection = getConnection();

    public void add(Child child) throws SQLException {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(INSERT_INTO_CHILD);

            preparedStatement.setString(1, child.getName());
            preparedStatement.setString(2, child.getSurname());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public List<Child> getAllChildren() throws SQLException {
        List<Child> children = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_CHILD);
            while (resultSet.next()) {
                Child child = new Child();
                child.setId(resultSet.getLong(COLUMN_LABEL_ID));
                child.setName(resultSet.getString(COLUMN_LABEL_NAME));
                child.setSurname(resultSet.getString(COLUMN_LABEL_SURNAME));
 //               children.add(convertChild(resultSet));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return children;
    }

    private Child convertChild(ResultSet resultSet) throws SQLException {
        Child child = new Child();
        child.setId(resultSet.getLong(COLUMN_LABEL_ID));
        child.setName(resultSet.getString(COLUMN_LABEL_NAME));
        child.setSurname(resultSet.getString(COLUMN_LABEL_SURNAME));
        return child;
    }

    public void update(Child child) throws SQLException {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setLong(1, child.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void delete(Child child) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {

            preparedStatement.setLong(1, child.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) connection.close();
        }
    }
}
