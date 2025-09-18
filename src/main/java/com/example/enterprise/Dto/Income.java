/*i will create few employees in the employee class and than assign them departments and than also department will have their own expense so i make another class call

expense and this is where i will be applying onetoone onetomany or manytomany relationships and will expand as it grows

Entity Relationship Diagram

Department ---< Employees (One-to-Many)
   |
   |
   ---< Expenses (One-to-Many)

Employee  ---< Expenses (One-to-Many, for who filed it)
 Core Entities
 
 Department: The central entity. It has a name and acts as a container for employees and expenses.
 
 Employee: Represents an employee. Each employee must belong to exactly one department.
 
 Expense: Represents a single expense record. Each expense is logged against one department and is filed by one employee.
 
 
 Relationship Breakdown
 
 Department to Employee (One-to-Many)
 
 A Department can have many Employees.
 
 An Employee belongs to only one Department.
 
 
 Implementation:
 
 Department has a @OneToMany relationship with a Set<Employee>.
 
 Employee has a @ManyToOne relationship back to its Department. This is the "owning" side of the relationship, meaning the employees table will contain the foreign key (department_id).
 
 Department to Expense (One-to-Many)
 
 A Department can have many Expenses.
 
 An Expense is associated with only one Department.
 

 Implementation:
 
 Department has a @OneToMany relationship with a Set<Expense>.
 
 Expense has a @ManyToOne relationship back to its Department. The expenses table will contain the foreign key (department_id).
 
 Employee to Expense (One-to-Many)
 
 An Employee can file many Expenses.
 
 An Expense is filed by only one Employee.
 
 
 Implementation:
 
 Employee has a @OneToMany relationship with a Set<Expense>.
 
 Expense has a @ManyToOne relationship back to the filing Employee. The expenses table will contain the foreign key (employee_id). */