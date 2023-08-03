package com.vlknyazeva.jdbc_servlet.servlet;

import com.vlknyazeva.jdbc_servlet.entity.Child;
import com.vlknyazeva.jdbc_servlet.service.ChildService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resultChildren")
public class SelectAllChildren extends HttpServlet {

     private ChildService childService;

    public SelectAllChildren() {
         super();
    }
    public SelectAllChildren(ChildService childService) {
        this.childService = childService;
    }

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Child> childList = childService.getAllChildren();

            request.setAttribute("childList", childList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("resultChildren.jsp");
            dispatcher.forward(request, response);
//            request.getRequestDispatcher("WEB-INF/jsp/resultChildren.jsp").forward(request, response);


            //   response.sendRedirect("Result.jsp?id=" + id + "&name=" + name + "&email=" + email + "&phone=" + ph);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

