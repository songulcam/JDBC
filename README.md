# Employees Schema
This README file contains various SQL queries for a sample `employees` schema. The queries can be adapted to your database schema and needs.

[MySQL Employee Structure](https://dev.mysql.com/doc/employee/en/sakila-structure.html)
## Employees Table
| Column Name | Description      |
|-------------|------------------|
| emp_no      | Employee number  |
| first_name  | First name       |
| last_name   | Last name        |
| birth_date  | Birth date       |
| gender      | Gender           |
| hire_date   | Hire date        |

## Departments Table
| Column Name | Description        |
|-------------|--------------------|
| dept_no     | Department number  |
| dept_name   | Department name    |

## Dept_Manager Table
| Column Name | Description                      |
|-------------|----------------------------------|
| emp_no      | Employee number                  |
| dept_no     | Department number                |
| from_date   | Start date of management         |
| to_date     | End date of management           |

## Titles Table
| Column Name | Description                       |
|-------------|-----------------------------------|
| emp_no      | Employee number                   |
| title       | Job title                         |
| from_date   | Start date of job title           |
| to_date     | End date of job title             |

## Salaries Table
| Column Name | Description                       |
|-------------|-----------------------------------|
| emp_no      | Employee number                   |
| salary      | Salary                            |
| from_date   | Start date of salary              |
| to_date     | End date of salary                |

![employees-schema.png](src/main/resources/img/employees-schema.png)

## 1. List all employees in department D001.
select * from dept_manager where dept_no='d001';

## 2. List all employees in 'Human Resources' department.
select * from dept_manager where dept_no='d003';

## 3. Calculate the average salary of all employees
select * from salaries;
select avg(salary) as Salary from salaries;

## 4. Calculate the average salary of all employees with gender "M"
select avg(salary)
from salaries
left join employees on salaries.emp_no = employees.emp_no
where employees.gender='M';

## 5. Calculate the average salary of all employees with gender "F"
select avg(salary)
from salaries
left join employees on salaries.emp_no=employees.emp_no
where employees.gender='F'; 

## 6. List all employees in the "Sales" department with a salary greater than 70,000.
select employees.first_name, employees.last_name, salaries.salary
from employees
left join salaries on salaries.emp_no=employees.emp_no
left join dept_emp on dept_emp.emp_no=employees.emp_no
left join departments on departments.dept_no=dept_emp.dept_no
where departments.dept_no='d007'and salaries.salary>70000;

## 7. This query retrieves employees who have salaries between 50000 and 100000.
select employees.first_name, employees.last_name, salaries.salary
from employees
left join salaries on salaries.emp_no=employees.emp_no
where salaries.salary between 50000 and 100000;

## 8. Calculate the average salary for each department (by department number or department name)
select departments.dept_no, departments.dept_name, avg(salary)
from departments
left join dept_emp on dept_emp.dept_no=departments.dept_no
left join salaries on salaries.emp_no=dept_emp.emp_no
group by departments.dept_no, departments.dept_name;

## 9. Calculate the average salary for each department, including department names
select departments.dept_no, departments.dept_name, avg(salary)
from departments
left join dept_emp on dept_emp.dept_no=departments.dept_no
left join salaries on salaries.emp_no=dept_emp.emp_no
group by departments.dept_no, departments.dept_name;

## 10. Find all salary changes for employee with emp. no '10102'
select * from salaries where emp_no='10102';

## 11. Find the salary increases for employee with employee number '10102' (using the to_date column
in salaries)
select * from salaries where emp_no='10102' order by salary;

## 12. Find the employee with the highest salary
select employees.first_name, employees.last_name, salaries.salary
from employees
left join salaries on employees.emp_no=salaries.emp_no 
order by salary desc limit 1;

## 13. Find the latest salaries for each employee
select salaries.emp_no, max(salary) from salaries group by emp_no;

## 14. List the first name, last name, and highest salary of employees in the "Sales" department.
Order the list by highest salary descending and only show the employee with the highest salary.
select employees.first_name, employees.last_name, max(salary) as maxSalary
from employees
left join dept_emp on employees.emp_no=dept_emp.emp_no
left join departments on dept_emp.dept_no=departments.dept_no
left join salaries on dept_emp.emp_no=salaries.emp_no
where departments.dept_no='d007'
group by employees.emp_no, employees.first_name, employees.last_name
order by maxSalary desc limit 1;


## 15. Find the Employee with the Highest Salary Average in the Research Department
select employees.first_name, employees.last_name, avg(salaries.salary) as average  
from employees
left join dept_emp on employees.emp_no=dept_emp.emp_no
left join departments on dept_emp.dept_no=departments.dept_no
left join salaries on dept_emp.emp_no=salaries.emp_no
where departments.dept_no='d008'
group by employees.emp_no, employees.first_name, employees.last_name
order by average desc limit 1;

## 16. For each department, identify the employee with the highest single salary ever recorded. List the
department name, employee's first name, last name, and the peak salary amount. Order the results
by the peak salary in descending order.


## 17. Identify the employees in each department who have the highest average salary. List the
department name, employee's first name, last name, and the average salary. Order the results by
average salary in descending order, showing only those with the highest average salary within their
department.


## 18. List the names, last names, and hire dates in alphabetical order of all employees hired before
January 01, 1990.
select employees.first_name, employees.last_name, employees.hire_date
from employees
where employees.hire_date < '1990-01-01'
order by employees.first_name, employees.last_name;


## 19. List the names, last names, hire dates of all employees hired between January 01, 1985 and
December 31, 1989, sorted by hire date.
select employees.first_name, employees.last_name, employees.hire_date
from employees
where employees.hire_date between '1985-01-01' and '1989-12-31'
order by employees.hire_date;

## 20. List the names, last names, hire dates, and salaries of all employees in the Sales department who
were hired between January 01, 1985 and December 31, 1989, sorted by salary in descending order.
select employees.first_name, employees.last_name, employees.hire_date, salaries.salary
from employees
left join salaries on employees.emp_no=salaries.emp_no
left join dept_emp on salaries.emp_no=dept_emp.emp_no
left join departments on dept_emp.dept_no=departments.dept_no
where departments.dept_no='d007' and employees.hire_date between '1985-01-01' and '1989-12-31'
order by salaries.salary desc;

## 21.
-- a: Find the count of male employees (179973)
-- b: Determine the count of female employees (120050)
-- c: Find the number of male and female employees by grouping:
-- d: Calculate the total number of employees in the company (300023)
select count(*) from employees where employees.gender='M';
select count(*) from employees where employees.gender='F';
select count(*) from employees group by employees.gender;
select count(*) from employees;

## 22.
-- a: Find out how many employees have unique first names (1275)
-- b: Identify the number of distinct department names (9)
select count(distinct employees.first_name)
from employees;
select count(distinct departments.dept_name)
from departments;

## 23. List the number of employees in each department
select departments.dept_name, count(dept_emp.emp_no)
from departments
left join dept_emp on departments.dept_no=dept_emp.dept_no
group by departments.dept_name;


## 24. List all employees hired within the last 5 years from February 20, 1990
select employees.first_name, employees.last_name, employees.hire_date
from employees
where employees.hire_date between '1990-02-20' and '1995-02-20';


## 25. List the information (employee number, date of birth, first name, last name, gender, hire date) of
the employee named "Annemarie Redmiles".
select * from employees
where employees.first_name='Annemarie' and employees.last_name='Redmiles';


## 26. List all information (employee number, date of birth, first name, last name, gender, hire date,
salary, department, and title) for the employee named "Annemarie Redmiles".
select employees.*, salaries.salary, departments.dept_name, titles.title
from employees
left join salaries on employees.emp_no=salaries.emp_no
left join  dept_emp on employees.emp_no=dept_emp.emp_no 
left join departments on dept_emp.dept_no=departments.dept_no 
left join titles on employees.emp_no=titles.emp_no 
where employees.first_name='Annemarie' and  employees.last_name='Redmiles';

## 27. List all employees and managers in the D005 department
select * from employees 
left join dept_emp on dept_emp.emp_no=employees.emp_no
left join dept_manager on dept_emp.dept_no=dept_manager.dept_no
where dept_emp.dept_no='d005';

## 28. List all employees hired after '1994-02-24' and earning more than 50,000
select employees.first_name, employees.last_name, salaries.salary
from employees
left join salaries on employees.emp_no=salaries.emp_no
where employees.hire_date>'1990-02-20' and salaries.salary>50000;

## 29. List all employees working in the "Sales" department with the title "Manager"
select employees.*, departments.dept_name, titles.title
from employees
left join  dept_emp on employees.emp_no=dept_emp.emp_no 
left join departments on dept_emp.dept_no=departments.dept_no 
left join titles on employees.emp_no=titles.emp_no 
where departments.dept_name='Sales' and titles.title='Manager';

## 30. Find the department where employee with '10102' has worked the longest
select dept_emp.dept_no,departments.dept_name, (year(current_date())-year(dept_emp.from_date)) as maxTimeTable
from dept_emp
left join departments on departments.dept_no = dept_emp.dept_no
where dept_emp.emp_no='10102'
group by dept_emp.dept_no
order by maxTimeTable desc;

## 31. Find the highest paid employee in department D004
select employees.first_name, employees.last_name, departments.dept_no, max(salaries.salary)
from employees
left join dept_emp on employees.emp_no=dept_emp.emp_no
left join salaries on employees.emp_no=salaries.emp_no
left join departments on dept_emp.dept_no=departments.dept_no
where departments.dept_no='d004'
group by employees.emp_no, employees.first_name, employees.last_name
order by max(salaries.salary) desc limit 1;

## 32. Find the entire position history for employee with emp. no '10102'
 select  titles.title, titles.emp_no
 from titles 
 where titles.emp_no='10102';

## 33. Finding the average "employee age"
select (year(current_date())-(avg(year(birth_date)))) as AvgAge from employees;

## 34. Finding the number of employees per department
 select dept_no, COUNT(*) 
from dept_emp
group by dept_no;

## 35. Finding the managerial history of employee with ID (emp. no) 110022
select dept_manager.emp_no,dept_manager.dept_no,dept_manager.from_date,dept_manager.to_date
from dept_manager
where emp_no=110022;

## 36. Find the duration of employment for each employee
select employees.first_name, employees.last_name, (year(current_date())) - (year(hire_date)) as EmpHireDate from employees;

## 37. Find the latest title information for each employee
select titles.emp_no, max(titles.title)
from titles
group by emp_no;

## 38. Find the first and last names of managers in department 'D005'
select employees.first_name, employees.last_name
from employees
left join dept_manager on employees.emp_no = dept_manager.emp_no
where dept_manager.dept_no ='d005';

## 39. Sort employees by their birth dates
select *  from employees order by birth_date;

## 40. List employees hired in April 1992
select * from employees
where hire_date between '1992-04-01' and '1992-04-30';

## 41. Find all departments that employee '10102' has worked in.
select departments.dept_name
from dept_emp
inner join departments on departments.dept_no=dept_emp.dept_no
where dept_emp.emp_no='10102';
