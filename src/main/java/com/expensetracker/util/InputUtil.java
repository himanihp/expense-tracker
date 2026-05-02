package com.expensetracker.util;

import com.expensetracker.dto.ExpenseTrackerDto;
import com.expensetracker.enums.Category;
import com.expensetracker.enums.ExpenseType;
import com.expensetracker.enums.Source;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
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
//        System.out.println("Debug Log: Expense Date after formatting is - " + expenseTrackerDto.getExpenseDate());

        System.out.println("Please enter the expense type - " + Arrays.toString(ExpenseType.values()));
        String expenseType = FunctionUtil.toSentenceCase(sc.next());
//        System.out.println("Debug Log: Expense Type after sentence casing is - '" + expenseType + "'");

        System.out.println("Please enter from given categories - " + Arrays.toString(Category.values()));
        String category = FunctionUtil.toSentenceCase(sc.next());
//        System.out.println("Debug Log: Category after sentence casing is - '" + category + "'");

        System.out.println("Please enter the amount");
        expenseTrackerDto.setAmount(sc.nextFloat());

        System.out.println("Please enter the source of transaction - " + Arrays.toString(Source.values()));
        String source = FunctionUtil.toSentenceCase(sc.next());
        sc.nextLine(); // to consume buffer next line which next() or nextInt() leaves
//        System.out.println("Debug Log: Source after sentence casing is - '" + source + "'");

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

    public static ExpenseTrackerDto acceptUpdatedExpenseDetails(ExpenseTrackerDto expenseTrackerDto, Scanner sc) {
        List<String> updateOptions = acceptFieldsToUpdate(sc);
        for (String option : updateOptions) {
            switch(option) {
                case "1" : {
                    System.out.println("Please enter updated Date (Type 'T' for Today's Date or in 'YYYY-MM-DD' format): ");
                    expenseTrackerDto.setExpenseDate(resolveExpenseDateTime(sc.nextLine()));
                    break;
                }
                case "2" : {
                    System.out.println("Please enter updated Amount");
                    expenseTrackerDto.setAmount(sc.nextFloat());
                    break;
                }
                case "3" : {
                    System.out.println("Please enter updated Expense Type - " + Arrays.toString(ExpenseType.values()));
                    String expenseType = FunctionUtil.toSentenceCase(sc.next());
                    expenseTrackerDto.setExpenseType(ExpenseType.valueOf(expenseType));
                    break;
                }
                case "4" : {
                    System.out.println("Please enter updated Source - " + Arrays.toString(Source.values()));
                    String source = FunctionUtil.toSentenceCase(sc.next());
                    expenseTrackerDto.setSource(Source.valueOf(source));
                    break;
                }
                case "5" : {
                    System.out.println("Please enter updated Description");
                    sc.nextLine(); // TODO: correct the redundant input because of next();
                    expenseTrackerDto.setDescription(sc.nextLine());
                    break;
                }
                case "6" : {
                    System.out.println("Please enter updated Category - " + Arrays.toString(Category.values()));
                    String category = FunctionUtil.toSentenceCase(sc.next());
                    expenseTrackerDto.setCategory(Category.valueOf(category));
                    break;
                }
            }
        }
        return expenseTrackerDto;
    }

    public static List<String> acceptFieldsToUpdate(Scanner sc) {
        System.out.println("Please enter what all to update in a comma-separated format, for example: 1,2,3...");
        System.out.println("1 to update the Date");
        System.out.println("2 to update the Amount");
        System.out.println("3 to update the Expense Type");
        System.out.println("4 to update the Source");
        System.out.println("5 to update the Description");
        System.out.println("6 to update the Category\n");
        sc.nextLine();
        String updateOptions = sc.nextLine();
        return List.of(updateOptions.split(","));
    }

    public static int acceptIdToSearch(Scanner sc) {
        System.out.println("Please enter 'ID' of the expense...");
        return sc.nextInt();
    }
}
