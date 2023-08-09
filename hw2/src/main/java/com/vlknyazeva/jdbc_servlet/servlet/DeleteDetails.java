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
    }
}

