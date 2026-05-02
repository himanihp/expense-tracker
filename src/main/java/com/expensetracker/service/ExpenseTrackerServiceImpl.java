package com.expensetracker.service;

import com.expensetracker.dao.ExpenseTrackerDao;
import com.expensetracker.dao.ExpenseTrackerDaoImpl;
import com.expensetracker.dto.ExpenseTrackerDto;
import com.expensetracker.entity.ExpenseTrackerEntity;
import com.expensetracker.util.MapperUtil;

public class ExpenseTrackerServiceImpl implements ExpenseTrackerService {

    ExpenseTrackerDao expenseTrackerDao = new ExpenseTrackerDaoImpl();
    @Override
    public void saveExpense(ExpenseTrackerDto expenseDto) {
        expenseTrackerDao.saveExpense(MapperUtil.mapExpenseDTOtoEntity(expenseDto));
        System.out.println("Expense saved successfully.");
    }

    @Override
    public void updateExpense(ExpenseTrackerDto expenseDto, int expenseId) {
        expenseDto.setId(expenseId);
        expenseTrackerDao.updateExpense(MapperUtil.mapExpenseDTOtoEntity(expenseDto));
        System.out.println("Expense updated successfully: "+ expenseDto);
    }

    @Override
    public ExpenseTrackerDto readExpenseById(int expenseId) {
        ExpenseTrackerEntity expenseTrackerEntity = expenseTrackerDao.readExpenseById(expenseId);
        if (expenseTrackerEntity !=null) {
            ExpenseTrackerDto expenseDto = MapperUtil.mapExpenseEntityToDTO(expenseTrackerEntity);
            System.out.println("Expense fetched : " + expenseDto);
            return expenseDto;
        }
        System.out.println("No Entry found for the given Expense Id.");
        return null;
    }

    @Override
    public void deleteExpenseById(int expenseId) {
        expenseTrackerDao.deleteExpenseById(expenseId);
        System.out.println("Expense deleted successfully!");
    }
}
