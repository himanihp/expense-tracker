package com.expensetracker.util;

import com.expensetracker.dto.ExpenseTrackerDto;

import java.util.Scanner;

public class InputUtil {
    public static int acceptMenuOption(Scanner sc) {
        System.out.println("Press 1 for creating New Entry");
        System.out.println("Press 2 for searching an entry");
        System.out.println("Press 3 to update an entry");
        System.out.println("Press 4 to delete an entry\n");
        return sc.nextInt();
    }

    public static ExpenseTrackerDto acceptExpenseDetails(Scanner sc) {
        ExpenseTrackerDto expenseTrackerDto = new ExpenseTrackerDto();
        System.out.println("Please enter the amount");
        expenseTrackerDto.setAmount(sc.nextFloat());
        return expenseTrackerDto;
    }
}
