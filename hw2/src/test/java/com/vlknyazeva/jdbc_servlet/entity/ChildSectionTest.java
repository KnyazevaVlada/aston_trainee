package com.vlknyazeva.jdbc_servlet.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChildSectionTest {
    @Test
    public void constructorAndGetters() {
        ChildSection childSection = new ChildSection();
        assertEquals(0, childSection.getChild_id());
        assertEquals(0, childSection.getSection_id());
    }

    @Test
    public void setters() {
        ChildSection childSection = new ChildSection();
        childSection.setChild_id(1);
        childSection.setSection_id(2);
        assertEquals(1, childSection.getChild_id());
        assertEquals(2, childSection.getSection_id());
    }

    @Test
    public void childIdSetter() {
        ChildSection childSection = new ChildSection();
        childSection.setChild_id(3);
        assertEquals(3, childSection.getChild_id());
    }

    @Test
    public void sectionIdSetter() {
        ChildSection childSection = new ChildSection();
        childSection.setSection_id(4);
        assertEquals(4, childSection.getSection_id());
    }

}
