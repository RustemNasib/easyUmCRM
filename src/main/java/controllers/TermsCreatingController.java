package controllers;

import db.DBServices;
import entity.Discipline;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TermsCreatingController", urlPatterns = "/termsCreating")
public class TermsCreatingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBServices services = new DBServices();

        List<Discipline> disciplines = services.getAllActiveDisciplines();
        req.setAttribute("disciplines", disciplines);
        req.getRequestDispatcher("WEB-INF/termsCreating.jsp").forward(req, resp);
    }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String duration = req.getParameter("duration");
            String[] selectDisciplines = req.getParameterValues("selectDisciplines");
            //Создаем объект подключения к базе данных для вызова метода создать семестр
            DBServices services = new DBServices();
            services.createTerm(duration, selectDisciplines);

            Term lastTerm = services.getLastTerm();
String idLastTerm = String.valueOf(lastTerm.getId());

            //Перенаправляем клиента на termsList.jsp
            resp.sendRedirect("/termsList?idSelectedTerm="+idLastTerm);
        }

    }

