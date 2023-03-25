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

@WebServlet(name = "DisciplineCreatingController", urlPatterns = "/disciplineCreating")
public class DisciplineCreatingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/disciplineCreating.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*      Ошибки
        Код 300 - ошибка перенаправления на другой сервер
        код 400 - томкат не нашел сервлет (контроллер по указанному в req url)
        код 405 - томкат нашел сервлет (контроллер), но нет метода doGet или doPost
        код 500 - сервер получил ошибку (exception) и не знал, что ответить на front
        */

        //Нужно из запроса request получить данные формы по созданию дисциплины
        String discipline = req.getParameter("newDiscipline");

        if (discipline == null || discipline.equals("")) {
            req.setAttribute("Error", 1);
            req.getRequestDispatcher("WEB-INF/disciplineCreating.jsp").forward(req,resp);
            return;
        }

        //Создаем объект подключения к базе данных для вызова метода создать дисциплину
        DBServices dbServices = new DBServices();

        dbServices.createDiscipline(discipline);

        //Перенаправляем клиента на disciplinesList.jsp
        resp.sendRedirect("/disciplinesList");
    }
}
