import utilities.DataBaseHelper;

import java.util.List;
public class Songul extends DataBaseHelper {
    public static void main(String[] args) {

    }
    public void Soru31(){
        List<List<String>> data =getData("select employees.emp_no,employees.first_name,employees.last_name,max(salaries.salary)\n" +
                "from employees\n" +
                "left join salaries on employees.emp_no = salaries.emp_no\n" +
                "left join dept_emp on employees.emp_no = dept_emp.emp_no\n" +
                "where dept_emp.dept_no='D004'\n" +
                "group by employees.emp_no\n" +
                "order by max(salaries.salary) desc limit 1;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }
    public void Soru32(){
        List<List<String>> data =getData("select emp_no,title,from_date,to_date\n" +
                "from titles\n" +
                "where emp_no='10102';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }
    public void Soru33(){
        List<List<String>> data =getData("select (year(current_date()) - (avg(year(birth_date)))) as AvgAge \n" +
                "from employees;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }
    public void Soru34(){
        List<List<String>> data =getData("select departments.dept_name,count(dept_emp.emp_no)\n" +
                "from departments\n" +
                "left join dept_emp on departments.dept_no = dept_emp.dept_no\n" +
                "group by departments.dept_name;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }
    public void Soru35(){
        List<List<String>> data =getData("select employees.first_name,employees.last_name,(year(current_date())-(year(employees.hire_date))) as EmpHireDate\n" +
                "from employees;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }
    public void Soru36(){
        List<List<String>> data = getData("select employees.first_name,employees.last_name,(year(current_date())-(year(employees.hire_date))) as EmpHireDate\n" +
                "from employees limit 50;");
        for (List<String> row : data) {
            System.out.println(row);
        }
    }
    public void Soru37(){
        List<List<String>> data =getData("select titles.emp_no, max(titles.title)\n" +
                "from titles\n" +
                "group by emp_no limit 10;");
        for (List<String> row : data){
            System.out.println(row);
        }

    }
    public void Soru38(){
        List<List<String>> data =getData("select employees.first_name , employees.last_name\n" +
                "from employees\n" +
                "left join dept_manager on employees.emp_no = dept_manager.emp_no\n" +
                "where dept_manager.dept_no='D005';");
        for (List<String> row : data){
            System.out.println(row);
        }

    }
    public void Soru39(){
        List<List<String>> data =getData("select *  from employees order by birth_date limit 100;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }
    public void Soru40(){
        List<List<String>> data =getData("select * from employees\n" +
                "where hire_date between '1992-04-01' and '1992-04-30';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }
    public void Soru41(){
        List<List<String>> data =getData("select departments.dept_name\n" +
                "from dept_emp\n" +
                "inner join departments on departments.dept_no=dept_emp.dept_no\n" +
                "where dept_emp.emp_no='10102';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }
}