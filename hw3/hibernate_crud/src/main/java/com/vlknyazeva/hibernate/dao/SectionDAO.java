package com.vlknyazeva.hibernate.dao;

import com.vlknyazeva.hibernate.entity.Section;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Objects;

public class SectionDAO {

    private final SessionFactory sessionFactory;

    public SectionDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Section section) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(section);
    }

    public void update(Section section) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(section);
    }

    public void delete(Section section) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(section);
    }

    public Section getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Section.class, id);
    }

    public List<Section> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Section", Section.class).list();
    }

    @Transactional
    public void saveOrUpdateSection(Section section) {
        if (Objects.isNull(section.getId())) {
            save(section);
        } else {
            update(section);
        }
    }

    @Transactional
    public void deleteSection(Long id) {
        Section section = getById(id);
        delete(section);
    }

    @Transactional
    public List<Section> getAllSections() {
        return getAll();
    }

}
