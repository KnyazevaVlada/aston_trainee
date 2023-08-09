package com.vlknyazeva.jdbc_servlet.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SectionTest {

    Section section;

    @Test
    public void constructorAndGetters() {
        section = new Section(1, "cricket", 10);
        assertEquals(1, section.getId());
        assertEquals("cricket", section.getName());
        assertEquals(10, section.getSectionChiefId());
    }

    @Test
    public void setters() {
        section = new Section();
        section.setId(2);
        section.setName("polo");
        section.setSectionChiefId(20);
        assertEquals(2, section.getId());
        assertEquals("polo", section.getName());
        assertEquals(20, section.getSectionChiefId());
    }

    @Test
    public void idSetter() {
        section = new Section();
        section.setId(3);
        assertEquals(3, section.getId());
    }

    @Test
    public void setSetter() {
        section = new Section();
        section.setName("Section 3");
        assertEquals("Section 3", section.getName());
    }

    @Test
    public void sectionChiefIdSetter() {
        section = new Section();
        section.setSectionChiefId(30);
        assertEquals(30, section.getSectionChiefId());
    }

}
