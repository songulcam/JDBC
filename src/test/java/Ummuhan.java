import utilities.DataBaseHelper;

import java.util.List;

public class Ummuhan extends DataBaseHelper {

    public static void main(String[] args) {

    }

    public void soru21a(){
        List<List<String>> data =getData("select count(*) from employees where employees.gender='M';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    public void soru21b(){
        List<List<String>> data =getData("select count(*) from employees where employees.gender='F';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    public void soru21c(){
        List<List<String>> data =getData("select count(*) from employees group by employees.gender;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    public void soru21d(){
        List<List<String>> data =getData("select count(*) from employees;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    public void soru22a(){
        List<List<String>> data =getData("select count(distinct employees.first_name)\n" +
                "from employees;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    public void soru22b(){
        List<List<String>> data =getData("select count(distinct departments.dept_name)\n" +
                "from departments;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    public void soru23(){
        List<List<String>> data =getData("select departments.dept_name, count(dept_emp.emp_no)\n" +
                "from departments\n" +
                "left join dept_emp on departments.dept_no=dept_emp.dept_no\n" +
                "group by departments.dept_name;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    public void soru24(){ //TODO : Veri farklı
        List<List<String>> data =getData("select employees.first_name, employees.last_name, employees.hire_date\n" +
                "from employees\n" +
                "where employees.hire_date between '1990-02-20' and '1995-02-20';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    public void soru25(){
        List<List<String>> data =getData("select * from employees\n" +
                "where employees.first_name='Annemarie' and employees.last_name='Redmiles';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    public void soru26(){
        List<List<String>> data =getData("select employees.*, salaries.salary, departments.dept_name, titles.title\n" +
                "from employees\n" +
                "left join salaries on employees.emp_no=salaries.emp_no\n" +
                "left join  dept_emp on employees.emp_no=dept_emp.emp_no \n" +
                "left join departments on dept_emp.dept_no=departments.dept_no \n" +
                "left join titles on employees.emp_no=titles.emp_no \n" +
                "where employees.first_name='Annemarie' and  employees.last_name='Redmiles';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    public void soru27(){
        List<List<String>> data =getData("select * from employees \n" +
                "left join dept_emp on dept_emp.emp_no=employees.emp_no\n" +
                "left join dept_manager on dept_emp.dept_no=dept_manager.dept_no\n" +
                "where dept_emp.dept_no='d005';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    public void soru28(){
        List<List<String>> data =getData("select employees.first_name, employees.last_name, salaries.salary\n" +
                "from employees\n" +
                "left join salaries on employees.emp_no=salaries.emp_no\n" +
                "where employees.hire_date>'1990-02-20' and salaries.salary>50000;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    public void soru29(){ //TODO : Veri farklı
        List<List<String>> data =getData("select employees.*, departments.dept_name, titles.title\n" +
                "from employees\n" +
                "left join  dept_emp on employees.emp_no=dept_emp.emp_no \n" +
                "left join departments on dept_emp.dept_no=departments.dept_no \n" +
                "left join titles on employees.emp_no=titles.emp_no \n" +
                "where departments.dept_name='Sales' and titles.title='Manager';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    public void soru30(){
        List<List<String>> data =getData("select dept_emp.dept_no,departments.dept_name, (year(current_date())-year(dept_emp.from_date)) as maxTimeTable\n" +
                "from dept_emp\n" +
                "left join departments on departments.dept_no = dept_emp.dept_no\n" +
                "where dept_emp.emp_no='10102'\n" +
                "group by dept_emp.dept_no\n" +
                "order by maxTimeTable desc;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }
}