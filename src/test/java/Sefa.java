
import utilities.DataBaseHelper;

import java.util.List;

public class Sefa extends DataBaseHelper {


    public static void main(String[] args) {
        List<List<String>> data =getData("select * from employees\n" +
                "left join salaries on employees.emp_no = salaries.emp_no\n" +
                "where salaries.salary between 50000 and 100000;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    public void soru1(){
        List<List<String>> data =getData("select * from dept_manager where dept_no='D001';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }
    public void soru2(){
        List<List<String>> data =getData("select * from dept_manager where dept_no='d003';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }
    public void soru3(){
        List<List<String>> data =getData("select avg(salary) from salaries;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }
    public void soru4(){
        List<List<String>> data =getData("select avg(salary)\n" +
                "from salaries\n" +
                "left join employees on salaries.emp_no = employees.emp_no\n" +
                "where employees.gender='M';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }
    public void soru5(){
        List<List<String>> data =getData("select avg(salary)\n" +
                "from salaries \n" +
                "left join employees on salaries.emp_no = employees.emp_no\n" +
                "where employees.gender='F';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }
    public void soru6(){
        List<List<String>> data =getData("select employees.first_name,employees.last_name,salaries.salary\n" +
                "from employees.employees\n" +
                "left join salaries on employees.emp_no = salaries.emp_no\n" +
                "left join dept_emp on employees.emp_no = dept_emp.emp_no\n" +
                "left join departments on dept_emp.dept_no = departments.dept_no\n" +
                "where departments.dept_no='d007' and salaries.salary > 70000;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    public void soru7(){
        List<List<String>> data =getData("select * from employees\n" +
                "left join salaries on employees.emp_no = salaries.emp_no\n" +
                "where salaries.salary between 50000 and 100000;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    public void Soru13(){
        List<List<String>> data =getData("select salaries.emp_no,max(salary)\n" +
                "from salaries\n" +
                "group by emp_no;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }
    public void Soru14(){
        List<List<String>> data =getData("select employees.first_name,employees.last_name,max(salary)\n" +
                "from employees\n" +
                "left join salaries on employees.emp_no = salaries.emp_no\n" +
                "left join dept_emp on employees.emp_no = dept_emp.emp_no\n" +
                "left join departments on dept_emp.dept_no = departments.dept_no\n" +
                "where departments.dept_no='d007' \n" +
                "group by employees.first_name,employees.last_name\n" +
                "order by max(salary) desc limit 1;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

}
