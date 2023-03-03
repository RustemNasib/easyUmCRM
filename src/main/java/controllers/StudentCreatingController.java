package controllers;

import db.DBServices;

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

@WebServlet(name = "StudentCreatingController", urlPatterns = "/studentCreating")
public class StudentCreatingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/studentCreating.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*      Ошибки
        Код 300 - ошибка перенаправления на другой сервер
        код 400 - томкат не нашел сервлет (контроллер по указанному в req url)
        код 405 - томкат нашел сервлет (контроллер), но нет метода doGet или doPost
        код 500 - сервер получил ошибку (exeption) и не знал, что ответить на front
        */

        //Нужно из запроса request получить данные формы по созданию студента
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String date = req.getParameter("date");

        if (surname == null || surname.equals("") ||
                name == null || name.equals("") ||
                group == null || group.equals("") ||
                date == null || date.equals("")) {
            req.setAttribute("Error", 1);
            req.getRequestDispatcher("WEB-INF/studentCreating.jsp").forward(req,resp);
            return;
        }

        //Создаем объект подключения к базе данных для вызова метода создать студента
        DBServices dbServices = new DBServices();

        //Формат даты
        //String to Date (преобразовываем формат Стринг в Дату)
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date dateFromUser;
        try {
            dateFromUser = format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //Date to String (преобразовываем формат Дату в Стринг)
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToBd = formatter.format(dateFromUser);


        dbServices.createStudent(surname, name, group, dateToBd);

        //Перенаправляем клиента на studentList.jsp
        resp.sendRedirect("/studentsList");
    }
}
