package com.expensetracker.util;

import com.expensetracker.dto.ExpenseTrackerDto;
import com.expensetracker.entity.ExpenseTrackerEntity;

public class MapperUtil {

    public static ExpenseTrackerEntity mapExpenseDTOtoEntity (ExpenseTrackerDto expense) {
        ExpenseTrackerEntity expenseEntity = new ExpenseTrackerEntity();
        expenseEntity.setAmount(expense.getAmount());
        expenseEntity.setDescription(expense.getDescription());
        expenseEntity.setExpenseDate(expense.getExpenseDate());
        expenseEntity.setExpenseType(expense.getExpenseType());
        expenseEntity.setCategory(expense.getCategory());
        expenseEntity.setSource(expense.getSource());
        return expenseEntity;
    }

    public static ExpenseTrackerDto mapExpenseEntityToDTO(ExpenseTrackerEntity expenseTrackerEntity) {
        ExpenseTrackerDto expenseDto = new ExpenseTrackerDto();
        // @todo map only relevant methods
        expenseDto.setAmount(expenseTrackerEntity.getAmount());
        expenseDto.setDescription(expenseTrackerEntity.getDescription());
        expenseDto.setExpenseDate(expenseTrackerEntity.getExpenseDate());
        expenseDto.setExpenseType(expenseTrackerEntity.getExpenseType());
        expenseDto.setCategory(expenseTrackerEntity.getCategory());
        expenseDto.setSource(expenseTrackerEntity.getSource());
        return expenseDto;
    }
}
