package com.vlknyazeva.jdbc_servlet.repository;

import com.vlknyazeva.jdbc_servlet.entity.Child;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ChildRepositoryTest {

    private ChildRepository childRepository;

    @BeforeEach
    void setUp() throws SQLException {
        childRepository = new ChildRepository();
    }

    @Test
    void testAddChild() throws SQLException {
        Child child = new Child(25L, "John", "Doe");
        childRepository.add(child);

        List<Child> children = childRepository.getAllChildren();
        assertNotNull(children);
        assertEquals(1, children.size());

        Child addedChild = children.get(0);
        assertEquals(child.getName(), addedChild.getName());
        assertEquals(child.getSurname(), addedChild.getSurname());
    }

    @Test
    void testUpdateChild() throws SQLException {
        Child child = new Child(25, "John", "Doe");
        childRepository.add(child);

        child.setName("Jane");
        child.setSurname("Doe");
        childRepository.update(child);

        List<Child> children = childRepository.getAllChildren();
        assertNotNull(children);
        assertEquals(1, children.size());

        Child updatedChild = children.get(0);
        assertEquals(child.getName(), updatedChild.getName());
        assertEquals(child.getSurname(), updatedChild.getSurname());
    }

    @Test
    void testDeleteChild() throws SQLException {
        Child child = new Child(33, "John", "Doe");
        childRepository.add(child);

        List<Child> children = childRepository.getAllChildren();
        assertNotNull(children);
        assertEquals(1, children.size());

        childRepository.delete(child);

        children = childRepository.getAllChildren();
        assertNotNull(children);
        assertEquals(0, children.size());
    }
}
