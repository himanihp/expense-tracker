package com.expensetracker.entity;

import com.expensetracker.enums.Category;
import com.expensetracker.enums.ExpenseType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class ExpenseTrackerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "EXPENSE_TYPE")
    private ExpenseType expenseType;
    @Column(name = "EXPENSE_DATE")
    private LocalDate expenseDate;
    @Column(name = "AMOUNT")
    private float amount;
    @Column(name = "CATEGORY")
    private Category category;
    @Column(name = "DESCRIPTION")
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
