package com.expensetracker.service;

import com.expensetracker.dto.ExpenseTrackerDto;

public interface ExpenseTrackerService {
    public void saveEntry(ExpenseTrackerDto expense);
    public void updateEntry(ExpenseTrackerDto expense);
}
