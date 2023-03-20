package controllers;

import db.DBServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplineDeleteController", urlPatterns = "/disciplineDelete")
public class DisciplineDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Объект подключения к SQL
        DBServices services = new DBServices();

//        Сохранить String полученный из формы
        String idsToDelete = req.getParameter("hiddenDelete");

// Разбиваем id-шники
        String[] ids = idsToDelete.split(" ");

        // Удаляем по одной дисциплине
        for (String id : ids) {
            services.deleteDiscipline(id);
        }
        // Далее перенаправляем пользователя на /disciplinesList.jsp
        resp.sendRedirect("/disciplinesList");
    }
}
