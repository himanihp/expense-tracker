package com.expensetracker.dto;

import com.expensetracker.enums.Category;
import com.expensetracker.enums.ExpenseType;

import java.time.LocalDate;

public class ExpenseTrackerDto {

    private int id;
    private ExpenseType expenseType;
    private LocalDate expenseDate;
    private float amount;
    private Category category;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ExpenseTrackerEntity{" +
                "id=" + id +
                ", expenseType=" + expenseType +
                ", expenseDate=" + expenseDate +
                ", amount=" + amount +
                ", category=" + category +
                ", description='" + description + '\'' +
                '}';
    }
}