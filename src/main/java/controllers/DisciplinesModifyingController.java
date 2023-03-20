package controllers;

import db.DBServices;
import entity.Discipline;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplinesModifyingController", urlPatterns = "/disciplinesModifying")
public class DisciplinesModifyingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Нужно по id получить студента для модификации
        //Сначала сохраним полученную id на переменную
        String id = req.getParameter("hiddenModify");

        //Получить из SQL дисциплину по id
        DBServices services = new DBServices();
        Discipline discipline = services.getDisciplineById(id);

        //Дисциплину из sql перенаправить в запросе на disciplinesModifying.jsp
        req.setAttribute("discipline", discipline);
        req.getRequestDispatcher("WEB-INF/disciplinesModifying.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Нужно из запроса request получить данные формы по созданию дисциплины
        String id = req.getParameter("id");
        String discipline = req.getParameter("discipline");

        //Создаем объект подключения к базе данных для вызова метода создать студента
        DBServices dbServices = new DBServices();

        dbServices.modifyDiscipline(id, discipline);

        //Перенаправляем клиента на disciplinesList.jsp
        resp.sendRedirect("/disciplinesList");
    }

}
