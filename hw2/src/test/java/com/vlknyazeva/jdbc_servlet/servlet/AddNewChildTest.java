package com.vlknyazeva.jdbc_servlet.servlet;
import com.vlknyazeva.jdbc_servlet.entity.Child;
import com.vlknyazeva.jdbc_servlet.service.ChildService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class AddNewChildTest {
    @Test
    public void testDoPost() throws ServletException, IOException, SQLException {

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        ChildService childService = Mockito.mock(ChildService.class);

        Mockito.when(request.getParameter("name")).thenReturn("Sasha");
        Mockito.when(request.getParameter("surname")).thenReturn("Brown");

        AddNewChild servlet = new AddNewChild(childService);

        servlet.doPost(request, response);

        Mockito.verify(childService).add(Mockito.any(Child.class));
    }

}
