package dataBaseTests;

import org.testng.annotations.Test;
import utilities.DataBaseHelper;

import java.util.List;

public class DatabaseTests extends DataBaseHelper {

    @Test
    public void executeQuery1(){
        List<List<String>> data =getData("select * from dept_manager where dept_no='D001';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery2(){
        List<List<String>> data =getData("select * from dept_manager where dept_no='d003';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery3(){
        List<List<String>> data =getData("select avg(salary) from salaries;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery4(){
        List<List<String>> data =getData("select avg(salary)\n" +
                "from salaries\n" +
                "left join employees on salaries.emp_no = employees.emp_no\n" +
                "where employees.gender='M';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery5(){
        List<List<String>> data =getData("select avg(salary)\n" +
                "from salaries \n" +
                "left join employees on salaries.emp_no = employees.emp_no\n" +
                "where employees.gender='F';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery6(){
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

    @Test
    public void executeQuery7(){
        List<List<String>> data =getData("select * from employees\n" +
                "left join salaries on employees.emp_no = salaries.emp_no\n" +
                "where salaries.salary between 50000 and 100000;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery8() {
        List<List<String>> data = getData("select departments.dept_name,departments.dept_no,avg(salary)\n" +
                "from departments\n" +
                "left join dept_emp on dept_emp.dept_no = departments.dept_no\n" +
                "left join salaries on dept_emp.emp_no =salaries.emp_no\n" +
                "group by departments.dept_no,departments.dept_name;");
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery9() {
        List<List<String>> data = getData("select departments.dept_name,avg(salary)\n" +
                "from departments\n" +
                "left join dept_emp on dept_emp.dept_no = departments.dept_no\n" +
                "left join salaries on dept_emp.emp_no = salaries.emp_no\n" +
                "group by departments.dept_name,departments.dept_name;");
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery10() {
        List<List<String>> data = getData("select * from salaries where emp_no=10102;"
        );
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery11() {
        List<List<String>> data = getData("select * from salaries where emp_no='10102' order by to_date;"
        );
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery12() {
        List<List<String>> data = getData("select employees.first_name,employees.last_name,salaries.salary\n" +
                "from employees\n" +
                "left join salaries on employees.emp_no = salaries.emp_no\n" +
                "order by salaries.salary desc limit 1;"
        );
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery13() {
        List<List<String>> data = getData("select salaries.emp_no,max(salary)\n" +
                "from salaries\n" +
                "group by emp_no;"
        );
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery14() {
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

    @Test
    public void executeQuery15() {
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

    @Test
    public void executeQuery16() {
        List<List<String>> data = getData("select employees.first_name,employees.last_name,employees.hire_date\n" +
                "from employees\n" +
                "where employees.hire_date<'1990-01-01'\n" +
                "order by employees.first_name,employees.last_name;"
        );
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery17() {
        List<List<String>> data = getData("select employees.first_name,employees.last_name,employees.hire_date\n" +
                "from employees\n" +
                "where employees.hire_date between '1985-01-01' and '1989-12-31'\n" +
                "order by employees.hire_date;"
        );
        for (List<String> row : data) {
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery18() {
        bufferWriter("src/test/java/fileWriterHelper/queries18.txt","select employees.first_name,employees.last_name,employees.hire_date,salaries.salary\n" +
                "from employees\n" +
                "left join salaries on employees.emp_no = salaries.emp_no\n" +
                "left join dept_emp on employees.emp_no = dept_emp.emp_no\n" +
                "left join departments on dept_emp.dept_no = departments.dept_no\n" +
                "where departments.dept_no='d007' and employees.hire_date between '1985-01-01' and '1989-12-31'\n" +
                "order by salaries.salary desc limit 100;");
    }

    @Test
    public void executeQuery19a(){
        List<List<String>> data =getData("select count(*) from employees where employees.gender='M';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery19b(){
        List<List<String>> data =getData("select count(*) from employees where employees.gender='F';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery19c(){
        List<List<String>> data =getData("select count(*) from employees group by employees.gender;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery19d(){
        List<List<String>> data =getData("select count(*) from employees;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery20a(){
        List<List<String>> data =getData("select count(distinct employees.first_name)\n" +
                "from employees;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery20b(){
        List<List<String>> data =getData("select count(distinct departments.dept_name)\n" +
                "from departments;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery21(){
        List<List<String>> data =getData("select departments.dept_name, count(dept_emp.emp_no)\n" +
                "from departments\n" +
                "left join dept_emp on departments.dept_no=dept_emp.dept_no\n" +
                "group by departments.dept_name;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery22(){
        bufferWriter("src/test/java/fileWriterHelper/query22.txt","select employees.first_name, employees.last_name, employees.hire_date\n" +
                "from employees\n" +
                "where employees.hire_date between '1990-02-20' and '1995-02-20' limit 100;");
    }

    @Test
    public void executeQuery23(){
        List<List<String>> data =getData("select * from employees\n" +
                "where employees.first_name='Annemarie' and employees.last_name='Redmiles';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery24(){
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

    @Test
    public void executeQuery25(){
        bufferWriter("src/test/java/fileWriterHelper/query25.txt","select * from employees \n" +
                "left join dept_emp on dept_emp.emp_no=employees.emp_no\n" +
                "left join dept_manager on dept_emp.dept_no=dept_manager.dept_no\n" +
                "where dept_emp.dept_no='d005' limit 100;");
    }

    @Test
    public void executeQuery26(){
        bufferWriter("src/test/java/fileWriterHelper/query26.txt","select employees.first_name, employees.last_name, salaries.salary\n" +
                "from employees\n" +
                "left join salaries on employees.emp_no=salaries.emp_no\n" +
                "where employees.hire_date>'1990-02-20' and salaries.salary>50000 limit 100;");
    }

    @Test
    public void executeQuery27(){
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

    @Test
    public void executeQuery28(){
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

    @Test
    public void executeQuery29(){
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

    @Test
    public void executeQuery30(){
        List<List<String>> data =getData("select emp_no,title,from_date,to_date\n" +
                "from titles\n" +
                "where emp_no='10102';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery31(){
        List<List<String>> data =getData("select (year(current_date()) - (avg(year(birth_date)))) as AvgAge \n" +
                "from employees;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery32(){
        List<List<String>> data =getData("select departments.dept_name,count(dept_emp.emp_no)\n" +
                "from departments\n" +
                "left join dept_emp on departments.dept_no = dept_emp.dept_no\n" +
                "group by departments.dept_name;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery33(){
        List<List<String>> data =getData("select dept_manager.emp_no,dept_manager.dept_no,dept_manager.from_date,dept_manager.to_date\n" +
                "from dept_manager\n" +
                "where emp_no=110022;");
        for (List<String> row : data){
            System.out.println(row);
        }
    }

    @Test
    public void executeQuery34(){
       bufferWriter("src/test/java/fileWriterHelper/query34.txt","select employees.first_name,employees.last_name,(year(current_date())-(year(employees.hire_date))) as EmpHireDate\n" +
               "from employees Limit 100;");
    }

    @Test
    public void executeQuery35() {
        bufferWriter("src/test/java/fileWriterHelper/query35.txt","select titles.emp_no, max(titles.title)\n" +
                "from titles\n" +
                "group by emp_no limit 100 ;");
    }

    @Test
    public void executeQuery36(){
        List<List<String>> data =getData("select employees.first_name , employees.last_name\n" +
                "from employees\n" +
                "left join dept_manager on employees.emp_no = dept_manager.emp_no\n" +
                "where dept_manager.dept_no='D005';");
        for (List<String> row : data){
            System.out.println(row);
        }

    }

    @Test
    public void executeQuery37(){
        bufferWriter("src/test/java/fileWriterHelper/query37.txt","select *  from employees order by birth_date limit 100;");
    }

    @Test
    public void executeQuery38(){
       bufferWriter("src/test/java/fileWriterHelper/query38.txt","select * from employees\n" +
               "where hire_date between '1992-04-01' and '1992-04-30';");
    }

    @Test
    public void executeQuery39(){
        List<List<String>> data =getData("select departments.dept_name\n" +
                "from dept_emp\n" +
                "inner join departments on departments.dept_no=dept_emp.dept_no\n" +
                "where dept_emp.emp_no='10102';");
        for (List<String> row : data){
            System.out.println(row);
        }
    }
}
