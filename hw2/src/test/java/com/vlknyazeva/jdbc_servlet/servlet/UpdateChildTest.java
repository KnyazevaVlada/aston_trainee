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

public class UpdateChildTest {
    @Test
    public void testDoPost() throws ServletException, IOException, SQLException {

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        ChildService childService = Mockito.mock(ChildService.class);

        UpdateChild servlet = new UpdateChild(childService);

        Mockito.when(request.getParameter("id")).thenReturn("1");
        Mockito.when(request.getParameter("name")).thenReturn("Katya");
        Mockito.when(request.getParameter("surname")).thenReturn("To");

        servlet.doPost(request, response);

        Child expectedChild = new Child();
        expectedChild.setId(1L);
        expectedChild.setName("Katya");
        expectedChild.setSurname("To");
        Mockito.verify(childService).update(expectedChild);

        Mockito.verify(response).sendRedirect("Success.jsp?msg=insert");
    }

}
