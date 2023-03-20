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

@WebServlet(name = "TermsListController", urlPatterns = "/termsList")
public class TermsListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //вытянем из базы данных все семестры для страницы
        DBServices services = new DBServices();
        List<Term> terms = services.getAllActiveTerms();

        //полученные из базы данных семестры сажаем в запрос
        req.setAttribute("terms", terms);

        //Определим нажал-ли кнопку "Выбрать" пользователь
        // при изменении семестры на странице и нажатии кнопки выбрать нужно получить id семестра
        String idSelectedTerm = req.getParameter("idSelectedTerm");
        //если кнопку никто не нажимал, значит idSelectedTerm == null и это первая загрузка
        if (idSelectedTerm == null) {
            //Полученные из базы семестры, по умолчанию вытягиваем дисциплины по первому семестру в базе
            if (terms.size() != 0) {

                //открытие страницы "Семестры"
                Term SelectedTerm = terms.get(0);
                req.setAttribute("SelectedTerm", SelectedTerm);

                //Осталось вытянуть дисциплины
                //Добавим в атрибуты дисциплины этого семестра
                List<Discipline> disciplines = services.getDisciplinesByTerm(SelectedTerm.getId() + "");
                req.setAttribute("disciplines", disciplines);
            }
        } else {
            //Нажата кнопка "Выбрать" на странице "Семестры"
            //Если idSelectedTerm не null, то вытягиваем его из базы
            Term selectedTerm = services.getTermById(idSelectedTerm);
            req.setAttribute("selectedTerm", selectedTerm);

            //Осталось вытянуть дисциплины
            //Добавим в атрибуты дисциплины этого семестра
            List<Discipline> disciplines = services.getDisciplinesByTerm(selectedTerm.getId() + "");
            req.setAttribute("disciplines", disciplines);
        }
        // создаем перенаправление
        req.getRequestDispatcher("WEB-INF/termsList.jsp").forward(req, resp);

    }
}
