package com.expensetracker.service;

import com.expensetracker.dao.ExpenseTrackerDao;
import com.expensetracker.dao.ExpenseTrackerDaoImpl;
import com.expensetracker.dto.ExpenseTrackerDto;
import com.expensetracker.entity.ExpenseTrackerEntity;

public class ExpenseTrackerServiceImpl implements ExpenseTrackerService {

    ExpenseTrackerDao expenseTrackerDao = new ExpenseTrackerDaoImpl();
    @Override
    public void saveEntry(ExpenseTrackerDto expense) {
        ExpenseTrackerEntity expenseEntity = new ExpenseTrackerEntity();
        expenseEntity.setAmount(expense.getAmount());
        expenseTrackerDao.saveEntry(expenseEntity);
        System.out.println("Expense saved successfully.");
    }

    @Override
    public void updateEntry(ExpenseTrackerDto expense) {

    }
}
