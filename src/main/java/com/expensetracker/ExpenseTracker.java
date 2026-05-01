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

        ExpenseTrackerService ExpenseTrackerService = new ExpenseTrackerServiceImpl();
        boolean invalidInput = false;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Welcome to Himani's ExpenseTracker!\n");
            do {
                int selectedOption = InputUtil.acceptMenuOption(sc);
                switch (selectedOption) {
                    case 1: {
                        ExpenseTrackerDto expense = InputUtil.acceptExpenseDetails(sc);
                        ExpenseTrackerService.saveEntry(expense);
                        break;
                    }
                    case 2: {
                        System.out.println("Search Functionality will be added soon...");
                        break;
                    }
                    case 3: {
                        ExpenseTrackerDto expense = InputUtil.acceptUpdatedExpenseDetails(sc);
                        ExpenseTrackerService.updateEntry(expense);
                        break;
                    }
                    case 4: {
                        System.out.println("Delete Functionality will be added soon...");
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