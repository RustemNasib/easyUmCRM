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
            stmt.execute("INSERT INTO `crm_easyum_33`.`discipline` (`discipline`) VALUES ('" + discipline + "');\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Discipline getDisciplineById(String id) {
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.discipline where status = '1' and id = " + id + "");

            //вывод ResultSet (значения из базы данных) на консоль
            //делаем цикл, что бы наполнить коллекцию  List <Discipline>disciplines = new ArrayList<>();
            while (rs.next()) {
                //Создали (подготовили) пустой объект типа дисциплина
                Discipline discipline = new Discipline();

                //Достали значение колонки id из базы данных SQL
                discipline.setId(rs.getInt("id"));

                //Достали значение колонки discipline из базы данных SQL
                discipline.setDiscipline(rs.getString("discipline"));

                //возвращаем дисциплину
                return discipline;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Модифицировать дисциплину
    @Override
    public void modifyDiscipline(String id, String newDiscipline) {
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
            stmt.execute("UPDATE `crm_easyum_33`.`discipline` SET `discipline` = '" + newDiscipline + "' WHERE (`id` = '" + id + "');\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //удалить выбранную дисциплину
    @Override
    public void deleteDiscipline(String id) {
        try {
            //Подключаем драйвер для MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указываем путь к схеме базы данных, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement (выбираем вариант подключения к базе данных sql)
            //Создаем запрос и формируем взаимодействие с базой данных, через путь и пароль, который указали выше
            Statement stmt = conn.createStatement();

//            //Обнуляем id дисциплины
//            stmt.execute("UPDATE `crm_easyum_33`.`discipline` WHERE (`id` = '" + id + "');\n");
            //Удалим дисциплину
            stmt.execute("DELETE FROM `crm_easyum_33`.`discipline` WHERE (`id` = '" + id + "')");

        } catch (Exception e) {
            e.printStackTrace();
        }

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
            stmt.execute("INSERT INTO `crm_easyum_33`.`student` (`surname`, `name`, `group`, `date`) VALUES ('" + surname + "', '" + name + "', '" + group + "', '" + date + "');\n");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //Получить студента по id
    @Override
    public Student getStudentById(String id) {
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.student where status = '1' and id = " + id + "");

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

                //возвращаем студента
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Модифицировать студента
    @Override
    public void modifyStudent(String id, String newSurname, String newName, String newGroup, String newDate) {
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
            stmt.execute("UPDATE `crm_easyum_33`.`student` SET `surname` = '" + newSurname + "', `name` = '" + newName + "', `group` = '" + newGroup + "', `date` = '" + newDate + "' WHERE (`id` = '" + id + "');");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Удалить студента
    @Override
    public void deleteStudent(String id) {
        try {
            //Подключаем драйвер для MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указываем путь к схеме базы данных, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement (выбираем вариант подключения к базе данных sql)
            //Создаем запрос и формируем взаимодействие с базой данных, через путь и пароль, который указали выше
            Statement stmt = conn.createStatement();
            //указываем в качестве результата путь, откуда брать инфу (c Workbench)
            stmt.execute("UPDATE `crm_easyum_33`.`student` SET `status` = '0' WHERE (`id` = '" + id + "');\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.term where status = '1'");

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

                //Добавляем в каждом цикле while объект term в коллекцию terms
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
        //Создаем коллекцию
        List<Discipline> disciplines = new ArrayList<>();
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.term_discipline as td\n" +
                    "left join discipline as d on td.id_discipline = d.id\n" +
                    "where d.status = '1' and td.id_term = " + idTerm + "");

            //вывод ResultSet (значения из базы данных) на консоль
            //делаем цикл, что бы наполнить коллекцию List<Student> students = new ArrayList<>()
            while (rs.next()) {
                //Создали (подготовили) пустой объект типа дисциплина
                Discipline discipline = new Discipline();

                //Достали значение колонки id из базы данных SQL
                discipline.setId(rs.getInt("id_discipline"));

                //Достали значение колонки name из базы данных SQL
                discipline.setDiscipline(rs.getString("discipline"));

                //Добавляем предметы в коллекцию
                disciplines.add(discipline);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //возвращаем коллекцию
        return disciplines;
    }

    //Создать семестр
    @Override
    public void createTerm(String duration, String[] idsDisciplines) {
        //Подключаемся к SQL
        try {
            //Подключаем драйвер для MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указываем путь к схеме базы данных, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement (выбираем вариант подключения к базе данных sql)
            //Создаем запрос и формируем взаимодействие с базой данных, через путь и пароль, который указали выше
            Statement stmt = conn.createStatement();
            //Достаем из БД последний семестр
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.term where id = (select max(id) FROM term)");
            Term term = new Term();
            //Наполнить
            while (rs.next()) {
                term.setId(rs.getInt("id"));
                term.setTerm(rs.getString("term"));
                term.setDuration(rs.getString("duration"));
            }
            //Разрезали слово и цифру {семестр, 9}
            String[] nameTerm = term.getTerm().split(" ");


            //Достанем цифру
            String x = nameTerm[nameTerm.length - 1];

            // Превращаем String в число int и сохраняем на переменную
            int i = Integer.parseInt(x) + 1;

            //Увеличенное число записываем String обратно в массив {семестр, 10}
            nameTerm[nameTerm.length - 1] = i + "";

            //Собираем массив в одно название семестра
            StringBuffer newTermStr = new StringBuffer();
            for (String str : nameTerm) {
                newTermStr.append(str).append(" ");
            }
            newTermStr.substring(0, newTermStr.length() - 1);

            //Добавляем новый семестр в БД, чтобы получить id нового семестра
            stmt.execute("INSERT INTO `crm_easyum_33`.`term` (`term`, `duration`) VALUES ('" + newTermStr + "', '" + duration + "');");

            //Достаем id нового семестра (достаем всю строку и формируем объект с полями)
            rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.term where term = '" + newTermStr + "'");

            while (rs.next()) {
                term.setId(rs.getInt("id"));
                term.setTerm(rs.getString("term"));
                term.setDuration(rs.getString("duration"));
            }
            //Создаем записи о соответствии нового семестра и дисциплин
            for (String id_discipline : idsDisciplines) {
                stmt.execute("INSERT INTO `crm_easyum_33`.`term_discipline` (`id_term`, `id_discipline`) VALUES ('" + term.getId() + "', '" + id_discipline + "');");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Получить семестр по id
    @Override
    public Term getTermById(String id) {

        // оборачиваем в try catсh
        try {
            //Подключаем драйвер для MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указываем путь к схеме базы данных, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement (выбираем вариант подключения к базе данных sql)
            //Создаем запрос и формируем взаимодействие с базой данных, через путь и пароль, который указали выше
            Statement stmt = conn.createStatement();
            //указываем в качестве результата путь, откуда брать информацию
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.term where status = '1' and id = " + id + "");

            //вывод ResultSet (значения из базы данных) на консоль
            //делаем цикл, что бы наполнить коллекцию List<Term> term = new ArrayList<>()
            while (rs.next()) {
                //Создали (подготовили) пустой объект типа дисциплина
                Term term = new Term();

                //Достали значение колонки id из базы данных SQL
                term.setId(rs.getInt("id"));

                //Достали значение колонки term из базы данных SQL
                term.setTerm(rs.getString("term"));

                //Достали значение колонки duration из базы данных SQL
                term.setDuration(rs.getString("duration"));

                return term;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    //Модифицировать семестр
    @Override
    public void modifyTerm(String id, String newDuration, String[] newIdsDisciplines) {
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
            stmt.execute("UPDATE `crm_easyum_33`.`term` SET `duration` = '" + newDuration + "' WHERE (`id` = '" + id + "');");

            //Удалим все записи связей текущего семестра с дисциплинами в term_discipline
            stmt.execute("DELETE FROM `crm_easyum_33`.`term_discipline` WHERE (`id_term` = '" + id + "');");

            //Добавляем новые записи
            for (String id_discipline : newIdsDisciplines) {
                stmt.execute("INSERT INTO `crm_easyum_33`.`term_discipline` (`id_term`, `id_discipline`) VALUES ('" + id + "', '" + id_discipline + "');");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Удалить семестр
    @Override
    public void deleteTerm(String id) {
        try {
            //Подключаем драйвер для MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указываем путь к схеме базы данных, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement (выбираем вариант подключения к базе данных sql)
            //Создаем запрос и формируем взаимодействие с базой данных, через путь и пароль, который указали выше
            Statement stmt = conn.createStatement();

            //Удалим все записи из term_discipline
            stmt.execute("DELETE FROM `crm_easyum_33`.`term_discipline` WHERE (`id_term` = '" + id + "')");

            //Удалим семестр
            stmt.execute("DELETE FROM `crm_easyum_33`.`term` WHERE (`id` = '" + id + "')");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean isItLastTerm() {
        try {
            //Подключаем драйвер для MySql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Указать путь к схеме базы данных, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            //Statement
            Statement stmt = conn.createStatement();
            //Запрос
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.term");

            List<Term> terms = new ArrayList<>();
            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt("id"));
                terms.add(term);
            }

            if (terms.size() == 1) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //Получить все оценки по студенту по семестру
    @Override
    public List<Mark> getMarks(String idStudent, String idTerm) {

        //Проверка idTerm на null -> взять первый из БД
        if (idTerm == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                //Указываем путь к схеме базы данных, логин и пароль
                Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

                //Statement (выбираем вариант подключения к базе данных sql)
                //Создаем запрос и формируем взаимодействие с базой данных, через путь и пароль, который указали выше
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.term where id = (select min(id) FROM term)");
                while (rs.next()) {
                    idTerm = rs.getString("id");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<Mark> marks = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указываем путь к схеме базы данных, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement (выбираем вариант подключения к базе данных sql)
            //Создаем запрос и формируем взаимодействие с базой данных, через путь и пароль, который указали выше
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.mark\n" +
                    "LEFT JOIN term_discipline ON mark.id_term_discipline = term_discipline.id\n" +
                    "LEFT JOIN discipline ON term_discipline.id_discipline = discipline.id WHERE id_term = " + idTerm + " AND id_student = " + idStudent + "; ");
            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt("id_term"));

                Student student = new Student();
                student.setId(rs.getInt("id_student"));

                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id_discipline"));
                discipline.setDiscipline(rs.getString("discipline"));

                Mark mark = new Mark();
                mark.setId(rs.getInt("id"));
                mark.setStudent(student);
                mark.setDiscipline(discipline);
                mark.setMark(rs.getInt("mark"));
                marks.add(mark);
            }
            return marks;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Получить все роли
    @Override
    public List<Role> getAllActiveRoles() {
        //Создаем коллекцию
        List<Role> roles = new ArrayList<>();

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
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.role");

            //вывод ResultSet (значения из базы данных) на консоль
            //делаем цикл, что бы наполнить коллекцию List<Student> students = new ArrayList<>()
            while (rs.next()) {
                //Создали (подготовили) пустой объект типа role
                Role role = new Role();

                //Достали значение колонки id из базы данных SQL
                role.setId(rs.getInt("id"));

                //Достали значение колонки из базы данных SQL
                role.setRole(rs.getString("role"));

                //Добавляем в коллекцию roles
                roles.add(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }


    //Проверка доступа
    @Override
    public boolean canLogin(String login, String password, String idRole) {
        /*должно быть две проверки
        1-я логин и пароль в user есть
                2-я есть ли у логина такая роль
                Две проверки одним запросом

         */
        try {
            //Подключаем драйвер для MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Указываем путь к схеме базы данных, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);

            //Statement (выбираем вариант подключения к базе данных sql)
            //Создаем запрос и формируем взаимодействие с базой данных, через путь и пароль, который указали выше
            Statement stmt = conn.createStatement();
            //указываем в качестве результата путь, откуда брать инфу (c Workbench)
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.user_role as ur\n" +
                    "left join user as u on ur.id_user = u.id\n" +
                    "where u.login = '" + login + "' and u.password = '" + password + "' and ur.id_role = " + idRole + "");

//возвращаем  true если такой пользователь уже есть
            while (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//        если такого пользователя нет то
        return false;
    }

    @Override
    public Term getLastTerm() {
        try {
            //Подключаем драйвер для MySql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Указать путь к схеме базы данных, логин и пароль
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB, Constants.LOGIN_TO_DB, Constants.PASSWORD_TO_DB);
            //Statement
            Statement stmt = conn.createStatement();
            //Запрос - достать последний семестр
            ResultSet rs = stmt.executeQuery("SELECT * FROM crm_easyum_33.term where id = (SELECT max(id) FROM term)");

            Term term = new Term();
            while (rs.next()) {
                term.setId(rs.getInt("id"));
                term.setTerm(rs.getString("term"));
                term.setDuration(rs.getString("duration"));
            }


            return term;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
