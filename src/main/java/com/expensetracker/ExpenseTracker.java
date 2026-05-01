package com.expensetracker;

import com.expensetracker.dto.ExpenseTrackerDto;
import com.expensetracker.service.ExpenseTrackerService;
import com.expensetracker.service.ExpenseTrackerServiceImpl;
import com.expensetracker.util.InputUtil;

import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        ExpenseTracker et = new ExpenseTracker();
        et.run();
    }

    private void run() {

        ExpenseTrackerService expenseTrackerService = new ExpenseTrackerServiceImpl();
        boolean invalidInput = false;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Welcome to Himani's ExpenseTracker!\n");
            do {
                int selectedOption = InputUtil.acceptMenuOption(sc);
                switch (selectedOption) {
                    case 1: {
                        ExpenseTrackerDto expense = InputUtil.acceptExpenseDetails(sc);
                        expenseTrackerService.saveExpense(expense);
                        break;
                    }
                    case 2: {
                        int expenseId = InputUtil.acceptIdToSearch(sc);
                        ExpenseTrackerDto expenseDto = expenseTrackerService.readExpenseById(expenseId);
                        System.out.println("Expense fetched : " + expenseDto);
                        break;
                    }
                    case 3: {
                        ExpenseTrackerDto expense = InputUtil.acceptUpdatedExpenseDetails(sc);
                        expenseTrackerService.updateExpense(expense);
                        break;
                    }
                    case 4: {
                        int expenseId = InputUtil.acceptIdToSearch(sc);
                        expenseTrackerService.deleteExpenseById(expenseId);
                        System.out.println("Expense deleted successfully!");
                        break;
                    }
                    case 5: {
                        System.out.println("Calculate Functionality will be added soon...");
                        break;
                    }
                    case 6: {
                        System.out.println("Add New Category Functionality will be added soon...");
                        break;
                    }
                    default: {
                        System.out.println("Invalid Input, Please enter from the options provided:");
                        invalidInput = true;
                    }
                }
            }
            while (InputUtil.shouldContinue(sc, invalidInput));
        }
    }
}