package com.expensetracker.service;

import com.expensetracker.dto.ExpenseTrackerDto;

public interface ExpenseTrackerService {
    void saveEntry(ExpenseTrackerDto expense);
}
