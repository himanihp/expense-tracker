package com.expensetracker.dao;

import com.expensetracker.config.DatabaseConfig;
import com.expensetracker.entity.ExpenseTrackerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ExpenseTrackerDaoImpl implements ExpenseTrackerDao{
    private final SessionFactory sessionFactory = DatabaseConfig.getSessionFactory();
    @Override
    public void saveExpense(ExpenseTrackerEntity expenseEntity) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(expenseEntity);
            tx.commit();
        }
    }

    @Override
    public void updateExpense(ExpenseTrackerEntity expenseEntity) {
        System.out.println("Debug Log: " + expenseEntity);
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(expenseEntity);
            tx.commit();
        }
    }

    @Override
    public ExpenseTrackerEntity readExpenseById(int expenseId) {
        try(Session session = sessionFactory.openSession()) {
            ExpenseTrackerEntity expenseTrackerEntity = session.find(ExpenseTrackerEntity.class, expenseId);
            return expenseTrackerEntity;
        }
    }

    @Override
    public void deleteExpenseById(int expenseId) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            ExpenseTrackerEntity expenseTrackerEntity = session.find(ExpenseTrackerEntity.class, expenseId);
            session.remove(expenseTrackerEntity);
            tx.commit();
        }
    }
}
