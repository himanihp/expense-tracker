package com.expensetracker.dao;

import com.expensetracker.config.DatabaseConfig;
import com.expensetracker.entity.ExpenseTrackerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ExpenseTrackerDaoImpl implements ExpenseTrackerDao{
    private SessionFactory sessionFactory = DatabaseConfig.getSessionFactory();
    @Override
    public void saveEntry(ExpenseTrackerEntity expenseEntity) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(expenseEntity);
            tx.commit();
        }
    }
}
