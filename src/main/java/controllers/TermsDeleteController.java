package controllers;

import db.DBServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TermsDeleteController", urlPatterns = "/termsDelete")
public class TermsDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Объект подключения к SQL
        DBServices services = new DBServices();

    // Сохранить String полученный из формы
       String idTermToDelete = req.getParameter("hiddenDeleteTerm");

    // Удаляем по id
        //проверяем если не последний семестр
        if (!services.isItLastTerm()) {
            services.deleteTerm(idTermToDelete);
        }
        // Далее перенаправляем пользователя на /termsList.jsp
        resp.sendRedirect("/termsList");
    }
}



