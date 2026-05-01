package com.expensetracker.dto;

import com.expensetracker.enums.Category;
import com.expensetracker.enums.ExpenseType;
import com.expensetracker.enums.Source;

import java.time.LocalDateTime;

public class ExpenseTrackerDto {

    private int id;
    private ExpenseType expenseType;
    private LocalDateTime expenseDate;
    private float amount;
    private Category category;
    private String description;
    private Source source;

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

    public LocalDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDateTime expenseDate) {
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

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "ExpenseTrackerDto{" +
                "id=" + id +
                ", expenseType=" + expenseType +
                ", expenseDate=" + expenseDate +
                ", amount=" + amount +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", source=" + source +
                '}';
    }
}