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
