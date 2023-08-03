package com.vlknyazeva.jdbc_servlet.servlet;

import com.vlknyazeva.jdbc_servlet.entity.Child;
import com.vlknyazeva.jdbc_servlet.service.ChildService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert.jsp")
public class AddNewChild extends HttpServlet {

    private ChildService childService;


    public AddNewChild() {
    }

    public AddNewChild(ChildService childService) {
        this.childService = childService;
    }

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try{
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");

            Child child = new Child();
            child.setName(name);
            child.setSurname(surname);

            childService.add(child);

            response.sendRedirect("Success.jsp?msg=insert");
        } catch (Exception e) {
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

            PreparedStatement st = conn.prepareStatement("INSERT INTO child values(?, ?)");

            st.setString(2, request.getParameter("name"));
            st.setString(3, request.getParameter("surname"));

            st.executeUpdate();

            st.close();
            conn.close();

            response.sendRedirect("Success.jsp?msg=insert");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}

