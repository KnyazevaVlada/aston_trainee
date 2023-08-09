package com.vlknyazeva.jdbc_servlet.service;

import com.vlknyazeva.jdbc_servlet.entity.Child;
import com.vlknyazeva.jdbc_servlet.repository.ChildRepository;

import java.sql.SQLException;
import java.util.List;

public class ChildService {
    private final ChildRepository childRepository;

    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    public List<Child> getAllChildren() throws SQLException {
        return childRepository.getAllChildren();
    }

    public void add(Child child) throws SQLException {
        childRepository.add(child);
    }

    public void delete(Child child) throws SQLException {
        childRepository.delete(child);
    }

    public void update(Child child) throws SQLException {
        childRepository.update(child);
    }
}
