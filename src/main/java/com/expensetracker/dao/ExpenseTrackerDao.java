package com.expensetracker.dao;

import com.expensetracker.entity.ExpenseTrackerEntity;

public interface ExpenseTrackerDao {
    void saveExpense(ExpenseTrackerEntity expenseEntity);
    public void updateExpense(ExpenseTrackerEntity expenseEntity);
    public ExpenseTrackerEntity readExpenseById(int expenseId);
    void deleteExpenseById(int expenseId);
}
