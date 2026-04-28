package com.expensetracker.dao;

import com.expensetracker.dto.ExpenseTrackerDto;
import com.expensetracker.entity.ExpenseTrackerEntity;

public interface ExpenseTrackerDao {
    void saveEntry(ExpenseTrackerEntity expenseEntity);
    public void updateEntry(ExpenseTrackerDto expense);
}
