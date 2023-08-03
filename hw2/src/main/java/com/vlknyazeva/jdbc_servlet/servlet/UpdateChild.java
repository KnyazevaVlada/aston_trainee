package com.vlknyazeva.jdbc_servlet.servlet;

import com.vlknyazeva.jdbc_servlet.entity.Child;
import com.vlknyazeva.jdbc_servlet.service.ChildService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateChild {

    private ChildService childService;

    private static final long serialVersionUID = 1L;

    public UpdateChild() {
    }

    public UpdateChild(ChildService childService) {
        this.childService = childService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Long id = Long.valueOf(request.getParameter("id"));
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");

            Child child = new Child();
            child.setId(id);
            child.setName(name);
            child.setSurname(surname);

            childService.update(child);

            response.sendRedirect("Success.jsp?msg=insert");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
