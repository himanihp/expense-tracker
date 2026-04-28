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
            System.out.println("Welcome to Himani's ExpenseTracker!");
            int selectedOption = InputUtil.acceptMenuOption(sc);
            if (selectedOption == 1) {
                ExpenseTrackerDto expense = InputUtil.acceptExpenseDetails(sc);
                ExpenseTrackerService.saveEntry(expense);
            }
        }
    }


}