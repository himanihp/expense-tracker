package com.expensetracker.dao;

import com.expensetracker.entity.ExpenseTrackerEntity;

public interface ExpenseTrackerDao {
    void saveEntry(ExpenseTrackerEntity expenseEntity);
}
