package com.vlknyazeva.jdbc_servlet.servlet;

import com.vlknyazeva.jdbc_servlet.entity.Child;
import com.vlknyazeva.jdbc_servlet.service.ChildService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/delete")
public class DeleteDetails extends HttpServlet {

    private ChildService childService;

    public DeleteDetails() {
    }

    public DeleteDetails(ChildService childService) {
        this.childService = childService;
    }

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            long id = Long.parseLong(request.getParameter("id"));

            Child child = new Child();
            child.setId(id);

            childService.delete(child);

            response.sendRedirect("Success.jsp?msg=delete");
        } catch (SQLException e) {
            e.printStackTrace();
        }

/*        try {
            Class.forName(DBUtil.DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
            Connection conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USER, DBUtil.PASSWORD);
            System.out.println("connection successful");
            PreparedStatement st = conn.prepareStatement("DELETE FROM child WHERE id=?");

            st.setInt(1, Integer.parseInt(request.getParameter("id")));

            st.executeUpdate();

            st.close();
            conn.close();

            response.sendRedirect("Success.jsp?msg=delete");

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}

