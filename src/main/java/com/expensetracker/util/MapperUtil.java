package com.expensetracker.util;

import com.expensetracker.dto.ExpenseTrackerDto;
import com.expensetracker.entity.ExpenseTrackerEntity;

public class MapperUtil {

    public static ExpenseTrackerEntity mapExpenseDTOtoEntity (ExpenseTrackerDto expenseDto) {
        ExpenseTrackerEntity expenseEntity = new ExpenseTrackerEntity();
        expenseEntity.setId(expenseDto.getId());
        expenseEntity.setAmount(expenseDto.getAmount());
        expenseEntity.setDescription(expenseDto.getDescription());
        expenseEntity.setExpenseDate(expenseDto.getExpenseDate());
        expenseEntity.setExpenseType(expenseDto.getExpenseType());
        expenseEntity.setCategory(expenseDto.getCategory());
        expenseEntity.setSource(expenseDto.getSource());
        return expenseEntity;
    }

    public static ExpenseTrackerDto mapExpenseEntityToDTO(ExpenseTrackerEntity expenseTrackerEntity) {
        ExpenseTrackerDto expenseDto = new ExpenseTrackerDto();
        expenseDto.setId(expenseTrackerEntity.getId());
        expenseDto.setAmount(expenseTrackerEntity.getAmount());
        expenseDto.setDescription(expenseTrackerEntity.getDescription());
        expenseDto.setExpenseDate(expenseTrackerEntity.getExpenseDate());
        expenseDto.setExpenseType(expenseTrackerEntity.getExpenseType());
        expenseDto.setCategory(expenseTrackerEntity.getCategory());
        expenseDto.setSource(expenseTrackerEntity.getSource());
        return expenseDto;
    }
}
