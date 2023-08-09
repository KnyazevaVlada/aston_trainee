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

public class DeleteDetailsTest {
    @Test
    public void testDoPost() throws ServletException, IOException, SQLException {

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        ChildService childService = Mockito.mock(ChildService.class);

        Mockito.when(request.getParameter("id")).thenReturn("1");

        DeleteDetails servlet = new DeleteDetails(childService);

        servlet.doPost(request, response);

        Mockito.verify(childService).delete(Mockito.any(Child.class));

        Mockito.verify(response).sendRedirect("Success.jsp?msg=delete");
    }

}
