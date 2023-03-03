package controllers;

import db.DBServices;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


@WebServlet(name = "StudentModifyingController", urlPatterns = "/studentModifying")
public class StudentModifyingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Нужно по id получить студента для модификации
        //Сначала сохраним полученную id на переменную
        String id = req.getParameter("hiddenModify");

        //Получить из SQL студента по id
        DBServices services = new DBServices();
        Student student = services.getStudentById(id);

        //Студента из sql перенаправить в запросе на studentModifying.jsp
        req.setAttribute("student", student);
        req.getRequestDispatcher("WEB-INF/studentModifying.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Нужно из запроса request получить данные формы по созданию студента
        String id = req.getParameter("id");
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String dateFromUser = req.getParameter("date");


        //Создаем объект подключения к базе данных для вызова метода создать студента
        DBServices dbServices = new DBServices();

        //Формат даты
        //String to Date (преобразовываем формат Стринг в Дату)
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date;
        try {
            date = format.parse(dateFromUser);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //Date to String (преобразовываем формат Дату в Стринг)
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToBd = formatter.format(date);


        dbServices.modifyStudent(id, surname, name, group, dateToBd);

        //Перенаправляем клиента на studentList.jsp
        resp.sendRedirect("/studentsList");
    }
}
