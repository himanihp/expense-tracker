package com.expensetracker.util;

import com.expensetracker.dto.ExpenseTrackerDto;
import com.expensetracker.enums.Category;
import com.expensetracker.enums.ExpenseType;
import com.expensetracker.enums.Source;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class InputUtil {
    public static int acceptMenuOption(Scanner sc) {
        System.out.println("Press 1 to create new entry");
        System.out.println("Press 2 to search for an entry");
        System.out.println("Press 3 to update an entry");
        System.out.println("Press 4 to delete an entry");
        System.out.println("Press 5 to calculate net transaction amount");
        System.out.println("Press 6 to add a new category\n");
        return sc.nextInt();
    }

    public static ExpenseTrackerDto acceptExpenseDetails(Scanner sc) {
        ExpenseTrackerDto expenseTrackerDto = new ExpenseTrackerDto();

        System.out.println("Please enter the expense date (Type 'T' for Today's Date or in 'YYYY-MM-DD' format): ");
        sc.nextLine(); // to consume buffer next line which next() or nextInt() leaves
        String inputExpenseDate = sc.nextLine();
        expenseTrackerDto.setExpenseDate(resolveExpenseDateTime(inputExpenseDate));
        System.out.println("Debug Log: Expense Date after formatting is - " + expenseTrackerDto.getExpenseDate());

        System.out.println("Please enter the expense type - " + Arrays.toString(ExpenseType.values()));
        String expenseType = FunctionUtil.toSentenceCase(sc.next());
        System.out.println("Debug Log: Expense Type after sentence casing is - '" + expenseType + "'");

        System.out.println("Please enter from given categories - " + Arrays.toString(Category.values()));
        String category = FunctionUtil.toSentenceCase(sc.next());
        System.out.println("Debug Log: Category after sentence casing is - '" + category + "'");

        System.out.println("Please enter the amount");
        expenseTrackerDto.setAmount(sc.nextFloat());

        System.out.println("Please enter the source of transaction - " + Arrays.toString(Source.values()));
        String source = FunctionUtil.toSentenceCase(sc.next());
        sc.nextLine(); // to consume buffer next line which next() or nextInt() leaves
        System.out.println("Debug Log: Source after sentence casing is - '" + source + "'");

        System.out.println("Please enter the description of transaction");
        expenseTrackerDto.setDescription(sc.nextLine());

        expenseTrackerDto.setSource(Source.valueOf(source));
        expenseTrackerDto.setCategory(Category.valueOf(category));
        expenseTrackerDto.setExpenseType(ExpenseType.valueOf(expenseType));
        return expenseTrackerDto;
    }

    public static LocalDateTime resolveExpenseDateTime(String inputDateString) {
        if (inputDateString != null && !inputDateString.isEmpty()) {
            if (inputDateString.equalsIgnoreCase("T")) {
                return LocalDateTime.now();
            } else
                return FunctionUtil.stringToLocalDateTime(inputDateString);
        }
        return null;
    }

    public static boolean shouldContinue(Scanner sc, boolean invalidInput) {
        if (invalidInput) {
            return true;
        }
        System.out.println("Press 'C' to continue or 'E' to exit");
        return "C".equalsIgnoreCase(sc.next());
    }

    public static ExpenseTrackerDto acceptUpdatedExpenseDetails(Scanner sc) {
        ExpenseTrackerDto expenseTrackerDto = new ExpenseTrackerDto();
//        System.out.println("Please enter the amount");
//        expenseTrackerDto.setAmount(sc.nextFloat());
        return expenseTrackerDto;
    }

    public static int acceptIdToSearch(Scanner sc) {
        System.out.println("Please enter 'ID' of the expense...");
        return sc.nextInt();
    }
}
