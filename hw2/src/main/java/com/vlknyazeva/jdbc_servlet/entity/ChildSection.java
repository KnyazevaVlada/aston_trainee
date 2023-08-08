package com.vlknyazeva.jdbc_servlet.entity;

import java.util.Objects;

public class ChildSection {

    private long child_id;

    private long section_id;

    public ChildSection() {
    }

    public ChildSection(long child_id, long section_id) {
        this.child_id = child_id;
        this.section_id = section_id;
    }

    public long getChild_id() {
        return child_id;
    }

    public void setChild_id(long child_id) {
        this.child_id = child_id;
    }

    public long getSection_id() {
        return section_id;
    }

    public void setSection_id(long section_id) {
        this.section_id = section_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildSection that = (ChildSection) o;
        return child_id == that.child_id && section_id == that.section_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(child_id, section_id);
    }

    @Override
    public String toString() {
        return "ChildSection{" +
                "child_id=" + child_id +
                ", section_id=" + section_id +
                '}';
    }
}
