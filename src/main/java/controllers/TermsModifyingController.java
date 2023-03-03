package controllers;

import db.DBServices;
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
import java.util.Locale;

@WebServlet(name = "TermsModifyingController", urlPatterns = "/termsModifying")
public class TermsModifyingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Нужно по id получить семестр для модификации
        //Сначала сохраним полученную id на переменную
        String id = req.getParameter("hiddenModify");

        //Получить из SQL семестр по id
        DBServices services = new DBServices();
        Term term = services.getTermById(id);

        //Семестр из sql перенаправить в запросе на TermsModifying.jsp
        req.setAttribute("term", term);
        req.getRequestDispatcher("WEB-INF/termsModifying.jsp").forward(req, resp);
    }
        @Override
        protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //Нужно из запроса request получить данные формы по созданию семестра
            String id = req.getParameter("id");
            String term = req.getParameter("term");
            String duration = req.getParameter("duration");



            //Создаем объект подключения к базе данных для вызова метода создать семестр
            DBServices dbServices = new DBServices();


            dbServices.modifyTerm(id, term, duration);

            //Перенаправляем клиента на termsList.jsp
            resp.sendRedirect("/termsList");
        }
    }

