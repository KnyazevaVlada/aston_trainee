package com.vlknyazeva.jdbc_servlet.servlet;


import com.vlknyazeva.jdbc_servlet.entity.Child;
import com.vlknyazeva.jdbc_servlet.service.ChildService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SelectAllChildrenTest {

    @Test
    public void testDoGet() throws ServletException, IOException, SQLException {

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = Mockito.mock(RequestDispatcher.class);
        ChildService childService = Mockito.mock(ChildService.class);

        SelectAllChildren servlet = new SelectAllChildren(childService);

        List<Child> childList = new ArrayList<>();
        childList.add(new Child(14, "Roma", "Knyazev"));
        childList.add(new Child(16, "Mary", "El-Khattabi"));

        Mockito.when(childService.getAllChildren()).thenReturn(childList);

        Mockito.when(request.getRequestDispatcher("resultChildren.jsp")).thenReturn(dispatcher);

        servlet.doGet(request, response);

        Mockito.verify(childService).getAllChildren();

        Mockito.verify(request).setAttribute("childList", childList);

        Mockito.verify(request).getRequestDispatcher("resultChildren.jsp");
        Mockito.verify(dispatcher).forward(request, response);
    }
}

