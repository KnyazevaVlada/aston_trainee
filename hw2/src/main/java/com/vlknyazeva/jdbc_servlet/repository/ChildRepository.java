package com.vlknyazeva.jdbc_servlet.repository;

import com.vlknyazeva.jdbc_servlet.entity.Child;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChildRepository extends AbstractRepository {

    public static final String SELECT_ALL_FROM_CHILD = "SELECT * FROM child";

    public static final String COLUMN_LABEL_ID = "id";
    public static final String COLUMN_LABEL_NAME = "name";
    public static final String COLUMN_LABEL_SURNAME = "surname";

    Connection connection = getConnection();

    //todo: RENAME!!!
    public void createPreparedStatement(Child child, String sql) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            fillChildStatement(child, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private void fillChildStatement(Child child, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, child.getId());
        preparedStatement.setString(2, child.getName());
        preparedStatement.setString(3, child.getSurname());
    }

    public List<Child> getAllChildren() throws SQLException {
        List<Child> children = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_CHILD);
            while (resultSet.next()) {
/*                long id = resultSet.getLong(COLUMN_LABEL_ID);
                String name = resultSet.getString(COLUMN_LABEL_NAME);
                String surname = resultSet.getString(COLUMN_LABEL_SURNAME);*/
/*                Child child = new Child();
                child.setId(resultSet.getLong(COLUMN_LABEL_ID));
                child.setName(resultSet.getString(COLUMN_LABEL_NAME));
                child.setSurname(resultSet.getString(COLUMN_LABEL_SURNAME));*/
                children.add(convertChild(resultSet));

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
}
