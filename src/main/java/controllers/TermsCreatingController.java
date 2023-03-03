package controllers;

import db.DBServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TermsCreatingController", urlPatterns = "/termsCreating")
public class TermsCreatingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/termsCreating.jsp").forward(req, resp);


        //Нужно из запроса request получить данные формы по созданию студента
        String term = req.getParameter("term");
        String duration = req.getParameter("duration");


        if (term == null || term.equals("") ||
                duration == null || duration.equals("")) {
            req.setAttribute("Error", 1);
            req.getRequestDispatcher("WEB-INF/termsCreating.jsp").forward(req,resp);
            return;
        }

        //Создаем объект подключения к базе данных для вызова метода создать семестр
        DBServices dbServices = new DBServices();

       dbServices.createTerm(term, duration);

        //Перенаправляем клиента на termsList.jsp
        resp.sendRedirect("/termsList");

    }
}