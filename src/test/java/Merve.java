import utilities.DataBaseHelper;

import java.util.List;

public class Merve extends DataBaseHelper {
    public static void main(String[] args) {
    }

    public void soru8() {
        List<List<String>> data = getData("select departments.dept_name,departments.dept_no,avg(salary)\n" +
                "from departments\n" +
                "left join dept_emp on dept_emp.dept_no = departments.dept_no\n" +
                "left join salaries on dept_emp.emp_no =salaries.emp_no\n" +
                "group by departments.dept_no,departments.dept_name;");
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    public void soru9() {
        List<List<String>> data = getData("select departments.dept_name,avg(salary)\n" +
                "from departments\n" +
                "left join dept_emp on dept_emp.dept_no = departments.dept_no\n" +
                "left join salaries on dept_emp.emp_no = salaries.emp_no\n" +
                "group by departments.dept_name,departments.dept_name;");
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    public void soru10() {
        List<List<String>> data = getData("select * from salaries where emp_no=10102;"
        );
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    public void soru11() {
        List<List<String>> data = getData("select * from salaries where emp_no='10102' order by to_date;"
        );
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    public void soru12() {
        List<List<String>> data = getData("select employees.first_name,employees.last_name,salaries.salary\n" +
                "from employees\n" +
                "left join salaries on employees.emp_no = salaries.emp_no\n" +
                "order by salaries.salary desc limit 1;"
        );
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    public void soru13() {
        List<List<String>> data = getData("select salaries.emp_no,max(salary)\n" +
                "from salaries\n" +
                "group by emp_no;"
        );
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    public void soru14() {
        List<List<String>> data = getData("select employees.first_name,employees.last_name,max(salary)\n" +
                "from employees\n" +
                "left join salaries on employees.emp_no = salaries.emp_no\n" +
                "left join dept_emp on employees.emp_no = dept_emp.emp_no\n" +
                "left join departments on dept_emp.dept_no = departments.dept_no\n" +
                "where departments.dept_no='d007' \n" +
                "group by employees.first_name,employees.last_name\n" +
                "order by max(salary) desc limit 1;"
        );
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    public void soru15() {
        List<List<String>> data = getData("select employees.first_name,employees.last_name,avg(salary)\n" +
                "from employees\n" +
                "left join salaries on employees.emp_no = salaries.emp_no\n" +
                "left join dept_emp on employees.emp_no = dept_emp.emp_no\n" +
                "left join departments on dept_emp.dept_no = departments.dept_no\n" +
                "where departments.dept_no='d008' \n" +
                "group by employees.first_name,employees.last_name\n" +
                "order by avg(salary) desc limit 1;"
        );
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    public void soru18() {
        List<List<String>> data = getData("select employees.first_name,employees.last_name,employees.hire_date\n" +
                "from employees\n" +
                "where employees.hire_date<'1990-01-01'\n" +
                "order by employees.first_name,employees.last_name;"
        );
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    public void soru19() {
        List<List<String>> data = getData("select employees.first_name,employees.last_name,employees.hire_date\n" +
                "from employees\n" +
                "where employees.hire_date between '1985-01-01' and '1989-12-31'\n" +
                "order by employees.hire_date;"
        );
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    public void soru20() {
        List<List<String>> data = getData("select employees.first_name,employees.last_name,employees.hire_date,salaries.salary\n" +
                "from employees\n" +
                "left join salaries on employees.emp_no = salaries.emp_no\n" +
                "left join dept_emp on employees.emp_no = dept_emp.emp_no\n" +
                "left join departments on dept_emp.dept_no = departments.dept_no\n" +
                "where departments.dept_no='d007' and employees.hire_date between '1985-01-01' and '1989-12-31'\n" +
                "order by salaries.salary desc limit 100;"
        );
        for (List<String> row : data) {
            System.out.println(row);
        }
    }
}
