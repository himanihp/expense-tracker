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

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Welcome to Himani's ExpenseTracker!\n");
            int selectedOption = InputUtil.acceptMenuOption(sc);
            if (selectedOption == 1) {
                ExpenseTrackerDto expense = InputUtil.acceptExpenseDetails(sc);
                ExpenseTrackerService.saveEntry(expense);
            }
            else if (selectedOption == 2) {
                System.out.println("Search Functionality will be added soon...");
            }
            else if (selectedOption == 3) {
                ExpenseTrackerDto expense = InputUtil.acceptUpdatedExpenseDetails(sc);
                ExpenseTrackerService.updateEntry(expense);
            }
            else if (selectedOption == 4) {
                System.out.println("Delete Functionality will be added soon...");
            }
            else if (selectedOption == 5) {
                System.out.println("Calculate Functionality will be added soon...");
            }
        }
    }


}