package com.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an Employee in the enterprise system.
 * Each employee belongs to one Department and can file multiple Expenses.
 */
@Entity
@Table(name = "employees") // Standard convention: lowercase, plural table names
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Correct annotation for auto-generation
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    private String jobTitle;

    // --- Relationships ---

    /**
     * This defines the "Many-to-One" relationship.
     * Many employees can belong to one department.
     * This is the OWNING side of the relationship. It holds the foreign key.
     */
    @ManyToOne(fetch = FetchType.LAZY) // LAZY is a performance best practice
    @JoinColumn(name = "department_id", nullable = false) // Defines the foreign key column
    private Department department;

    /**
     * This defines the "One-to-Many" relationship from Employee to Expense.
     * One employee can file many expenses.
     * 'mappedBy' indicates this is the INVERSE (non-owning) side.
     * The 'employee' field in the Expense class owns this relationship.
     */
    @OneToMany(
        mappedBy = "employee",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Expense> expenses = new ArrayList<>();


    // --- Constructors ---

    // A no-argument constructor is required by JPA
    public Employee() {
    }

    // A useful constructor for creating new employees
    public Employee(String firstName, String lastName, String email, String jobTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.jobTitle = jobTitle;
    }

    // --- Getters and Setters (Standard Java Bean format) ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}

