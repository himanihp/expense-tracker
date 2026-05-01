package com.expensetracker.service;

import com.expensetracker.dto.ExpenseTrackerDto;

public interface ExpenseTrackerService {
    public void saveExpense(ExpenseTrackerDto expenseDto);
    public void updateExpense(ExpenseTrackerDto expenseDto);
    public ExpenseTrackerDto readExpenseById(int expenseId);
    void deleteExpenseById(int expenseId);
}
