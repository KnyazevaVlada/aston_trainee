package com.vlknyazeva.jdbc_servlet.servlet;

import com.vlknyazeva.jdbc_servlet.entity.Child;
import com.vlknyazeva.jdbc_servlet.service.ChildService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert.jsp")
public class AddNewChild extends HttpServlet {

    private ChildService childService;

    public AddNewChild(ChildService childService) {
    }

    public void init() throws ServletException {
        this.childService = childService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
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
    }
}

