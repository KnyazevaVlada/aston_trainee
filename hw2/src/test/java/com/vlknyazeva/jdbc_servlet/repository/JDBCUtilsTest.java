package com.vlknyazeva.jdbc_servlet.repository;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class JDBCUtilsTest {
    @Test
    public void testGetConnectJDBC() {
        JDBCUtils connection = new JDBCUtils();

        try {
            assertFalse(connection.getConnection().isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
