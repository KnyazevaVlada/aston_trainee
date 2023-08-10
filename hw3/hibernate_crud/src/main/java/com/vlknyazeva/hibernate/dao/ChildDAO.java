package com.vlknyazeva.hibernate.dao;

import com.vlknyazeva.hibernate.entity.Child;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class ChildDAO {
    private SessionFactory sessionFactory;

    public ChildDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Child child) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.persist(child);

        tx.commit();
    }

    public void update(Child child) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        session.merge(child);

        tx.commit();
    }

    public void delete(Child child) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(child);
    }

    public Child getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Child.class, id);
    }

    public List<Child> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Child", Child.class).list();
    }

    @Transactional
    public void saveOrUpdateChild(Child child) {
        if (Objects.isNull(child.getId())) {

            save(child);
        } else {
            update(child);
        }
    }

    @Transactional
    public void deleteChild(Long id) {
        Child child = getById(id);
        delete(child);
    }

    @Transactional
    public List<Child> getAllChildren() {
        return getAll();
    }

}
