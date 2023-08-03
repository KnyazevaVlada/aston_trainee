package com.vlknyazeva.jdbc_servlet.entity;

import java.util.Objects;

public class Section {

    private long id;

    private String name;

    private long sectionChiefId;

    public Section() {
    }

    public Section(long id, String name, long sectionChiefId) {
        this.id = id;
        this.name = name;
        this.sectionChiefId = sectionChiefId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSectionChiefId() {
        return sectionChiefId;
    }

    public void setSectionChiefId(long sectionChiefId) {
        this.sectionChiefId = sectionChiefId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return id == section.id && sectionChiefId == section.sectionChiefId && Objects.equals(name, section.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sectionChiefId);
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
