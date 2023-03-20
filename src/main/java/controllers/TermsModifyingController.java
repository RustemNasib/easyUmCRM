package controllers;

import db.DBServices;
import entity.Discipline;
import entity.Student;
import entity.Term;

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
import java.util.List;
import java.util.Locale;

@WebServlet(name = "TermsModifyingController", urlPatterns = "/termsModifying")
public class TermsModifyingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Нужно по id получить семестр для модификации
        //Сначала сохраним полученную id от формы на переменную
        String id = req.getParameter("hiddenModifyTerm");

        //Получить по id из SQL семестр
        DBServices services = new DBServices();
        Term term = services.getTermById(id);

        //теперь по вытянутому семестру еще вытянем его дисциплины
        List<Discipline> disciplines = services.getAllActiveDisciplines();
        // Перенаправляем запрос на termsModifying.jsp, но добавив атрибуты для наполнения страниц
        req.setAttribute("term", term);
        req.setAttribute("disciplines", disciplines);
        req.getRequestDispatcher("WEB-INF/termsModifying.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //нужно из запроса req получить данные формы для модификации семестра id, duratuon и id дисциплины
        String idTerm = req.getParameter("idTerm");
        String newDuration = req.getParameter("newDuration");
        String[] newIdsDisciplines = req.getParameterValues("newIdsDisciplines");


        //Создаем объект подключения к базе данных для вызова метода создать семестр
        DBServices services = new DBServices();
        services.modifyTerm(idTerm, newDuration, newIdsDisciplines);
        //Перенаправляем клиента на termsList.jsp
        resp.sendRedirect("/termsList?idSelectedTerm=" + idTerm);
    }
}

