package com.vlknyazeva.jdbc_servlet.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChildTest {
    Child child;

    @BeforeEach
    public void createChild() {
        child = new Child(12, "Petr", "Kalugin");
    }

    @Test
    void getId() {
        assertEquals(12, child.getId());
    }

    @Test
    void setId() {
        child.setId(13);
        assertEquals(13, child.getId());
    }

    @Test
    void getName() {
        assertEquals("Petr", child.getName());
    }

    @Test
    void setName() {
        child.setName("Luk");
        assertEquals("Luk", child.getName());
    }

    @Test
    void getSurname() {
        assertEquals("Kalugin", child.getSurname());
    }

    @Test
    void setSurname() {
        child.setSurname("Komov");
        assertEquals("Komov", child.getSurname());
    }

    @Test
    void setListOfSections() {
        List<Section> sectionsList = new ArrayList<>();
        Section section1 = new Section(6, "baseball", 1);
        Section section2 = new Section(7, "poker", 1);
        sectionsList.add(section1);
        sectionsList.add(section2);

        child.setSections(sectionsList);

        List<Section> childSections = child.getSections();
        assertEquals(sectionsList, childSections);


    }

    @Test
    void getListOfSections() {
        List<Section> sectionsList = new ArrayList<>();

        Section section3 = new Section(8, "piano", 1);
        sectionsList.add(section3);
        child.setSections(sectionsList);
        List<Section> childSections = child.getSections();
        assertEquals(sectionsList, childSections);
    }


}
