package controllers;

import db.DBServices;
import entity.Mark;
import entity.Student;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProgressStudentsController", urlPatterns = "/studentProgress")
public class ProgressStudentsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Сохраним полученную id студента
        String idStudent = req.getParameter("hiddenProgressStudent");
        DBServices services = new DBServices();

        // Передаем на jsp студента для просмотра его оценок
        Student student = services.getStudentById(idStudent);
        req.setAttribute("student", student);
        req.setAttribute("selectedTerm", student);

        // Передадим список семестров на jsp
        List<Term> terms = services.getAllActiveTerms();
        req.setAttribute("terms", terms);

        //При изменении семестра на странице studentProgress.jsp
        String idSelectTerm = req.getParameter("idSelectTerm");
        if (idSelectTerm == null) {
            if (terms.size() != 0) {
                Term selectedTerm = terms.get(0);
                req.setAttribute("selectedTerm", selectedTerm);
            }
        } else {
            //idSelectTerm установлен, т.е. не null
            Term selectedTerm = services.getTermById(idSelectTerm);
            req.setAttribute("selectedTerm", selectedTerm);
        }
        //делаем запрос в таблицу mark
        List<Mark> marks = services.getMarks(idStudent, idSelectTerm);
        req.setAttribute("marks", marks);

        // Средний балл
        float y = 0, x = 0, res = 0;
        for (Mark mark : marks) {
            x += mark.getMark();
            y++;
            res = x / y;
        }
        req.setAttribute("res", res);

        req.getRequestDispatcher("WEB-INF\\studentProgress.jsp").forward(req, resp);

    }
}

