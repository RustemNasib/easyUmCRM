package db;

import constants.Constants;
import entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBServices implements IDBServices {

    // Получить список активных дисциплин для таблицы
    @Override
    public List<Discipline> getAllActiveDisciplines() {
        //Создаем коллекцию
        List<Discipline> disciplines = new ArrayList<>();

        // оборачиваем в try catсh
        try {
            //Подключаем драйвер для MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указываем путь к схеме базы данных, логин и пароль
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm_easyum_33", "root", "bu7za7bekA+");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            //Statement (выбираем вариант подключения к базе данных sql)
            //Создаем запрос и формируем взаимодействие с базой данных, через путь и пароль, который указали выше
            Statement stmt = conn.createStatement();
            //указываем в качестве результата путь, откуда брать инфу
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.discipline");

            //вывод ResultSet (значения из базы данных) на консоль
            //делаем цикл, что бы наполнить коллекцию List<Discipline> disciplines = new ArrayList<>()
            while (rs.next()) {
                //Создали (подготовили) пустой объект типа дисциплина
                Discipline discipline = new Discipline();

                //Достали значение колонки id из базы данных SQL
                discipline.setId(rs.getInt("id"));

                //Достали значение колонки discipline из базы данных SQL
                discipline.setDiscipline(rs.getString("discipline"));

                //Добавляем в каждом цикле while обЪект discipline в коллекцию disciplines
                disciplines.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    //Создать дисциплину
    @Override
    public void createDiscipline(String discipline) {
        //Подключаемся к SQL
        try {
            //Подключаем драйвер для MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указываем путь к схеме базы данных, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement (выбираем вариант подключения к базе данных sql)
            //Создаем запрос и формируем взаимодействие с базой данных, через путь и пароль, который указали выше
            Statement stmt = conn.createStatement();
            //указываем в качестве результата путь, откуда брать инфу
            stmt.execute("INSERT INTO `crm_easyum_33`.`discipline` (`discipline`, `status`) VALUES ('"+discipline+"');\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Получить дисциплину по id
    @Override
    public Discipline getDisciplineById(String id) {
        return null;
    }

    //Модифицировать дисциплину
    @Override
    public void modifyDiscipline(String id, String newDiscipline) {

    }

    //удалить выбранную дисциплину
    @Override
    public void deleteDiscipline(String id) {

    }

    //Получить список студентов
    @Override
    public List<Student> getAllActiveStudents() {

        //Создаем коллекцию
        List<Student> students = new ArrayList<>();

        //Подключаемся к SQL
        // оборачиваем в try catсh
        try {
            //Подключаем драйвер для MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указываем путь к схеме базы данных, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement (выбираем вариант подключения к базе данных sql)
            //Создаем запрос и формируем взаимодействие с базой данных, через путь и пароль, который указали выше
            Statement stmt = conn.createStatement();
            //указываем в качестве результата путь, откуда брать инфу
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.student where status = '1'");

            //вывод ResultSet (значения из базы данных) на консоль
            //делаем цикл, что бы наполнить коллекцию List<Student> students = new ArrayList<>()
            while (rs.next()) {
                //Создали (подготовили) пустой объект типа студент
                Student student = new Student();

                //Достали значение колонки id из базы данных SQL
                student.setId(rs.getInt("id"));

                //Достали значение колонки name из базы данных SQL
                student.setName(rs.getString("name"));

                //Достали значение колонки surname из базы данных SQL
                student.setSurname(rs.getString("surname"));

                //Достали значение колонки group из базы данных SQL
                student.setGroup(rs.getString("group"));

                //Достали значение колонки date из базы данных SQL
                student.setDate(rs.getDate("date"));

                //Добавляем в каждом цикле while обЪект student в коллекцию students
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    //Создать студента
    @Override
    public void createStudent(String surname, String name, String group, String date) {
        //Подключаемся к SQL
        try {
            //Подключаем драйвер для MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указываем путь к схеме базы данных, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement (выбираем вариант подключения к базе данных sql)
            //Создаем запрос и формируем взаимодействие с базой данных, через путь и пароль, который указали выше
            Statement stmt = conn.createStatement();
            //указываем в качестве результата путь, откуда брать инфу
            stmt.execute("INSERT INTO `crm_easyum_33`.`student` (`surname`, `name`, `group`, `date`) VALUES ('"+surname+"', '"+name+"', '"+group+"', '"+date+"');\n");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //Получить студента по id
    @Override
    public Student getStudentById(String id) {
        return null;
    }

    //Модифицировать студента
    @Override
    public void modifyStudent(String id, String newSurname, String newName, String newGroup, String newDate) {

    }

    //Удалить студента
    @Override
    public void deleteStudent(String id) {

    }

    //Получить список семестров
    @Override
    public List<Term> getAllActiveTerms() {
        //Создаем коллекцию
        List<Term> terms = new ArrayList<>();

        // оборачиваем в try catсh
        try {
            //Подключаем драйвер для MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указываем путь к схеме базы данных, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement (выбираем вариант подключения к базе данных sql)
            //Создаем запрос и формируем взаимодействие с базой данных, через путь и пароль, который указали выше
            Statement stmt = conn.createStatement();
            //указываем в качестве результата путь, откуда брать инфу
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.term");

            //вывод ResultSet (значения из базы данных) на консоль
            //делаем цикл, что бы наполнить коллекцию List<Student> students = new ArrayList<>()
            while (rs.next()) {
                //Создали (подготовили) пустой объект типа дисциплина
                Term term = new Term();

                //Достали значение колонки id из базы данных SQL
                term.setId(rs.getInt("id"));

                //Достали значение колонки name из базы данных SQL
                term.setTerm(rs.getString("term"));

                //Достали значение колонки surname из базы данных SQL
                term.setDuration(rs.getString("duration"));

                //Добавляем в каждом цикле while обЪект student в коллекцию students
                terms.add(term);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return terms;
    }

    //Получить список дисциплин по выбранному семестру
    @Override
    public List<Discipline> getDisciplinesByTerm(String idTerm) {
        return null;
    }

    //Создать семестр
    @Override
    public void createTerm(String duration, String idsDisciplines) {
        //Подключаемся к SQL
        try {
            //Подключаем драйвер для MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указываем путь к схеме базы данных, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement (выбираем вариант подключения к базе данных sql)
            //Создаем запрос и формируем взаимодействие с базой данных, через путь и пароль, который указали выше
            Statement stmt = conn.createStatement();
            //указываем в качестве результата путь, откуда брать инфу
            stmt.execute("INSERT INTO `crm_easyum_33`.`term` (`term`, `duration`, `status`) VALUES ('"+duration+"');\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Получить семестр по id
    @Override
    public Term getTermById(String id) {
        return null;
    }

    //Модифицировать семестр
    @Override
    public void modifyTerm(String id, String newDuration, String newIdsDisciplines) {

    }
    //Удалить семестр
    @Override
    public void deleteTerm(String id) {

    }
    //Получить все оценки по студенту по семестру
    @Override
    public List<Mark> getMarks(String idStudent, String idTerm) {
        return null;
    }

    //Получить все роли
    @Override
    public List<Role> getAllActiveRoles() {
        return null;
    }

    //Проверка доступа
    @Override
    public boolean canLogin(String login, String password, String idRole) {
        return false;
    }
}
