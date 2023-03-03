package controllers;

import db.DBServices;
import entity.Discipline;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "DisciplinesListController", urlPatterns = "/disciplinesList")
    public class DisciplinesListController extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //Создать объект типа dbServices
            DBServices dbServices = new DBServices();

            //Вызвать метод getAllActiveStudents, что бы достать всех активных студентов из SQL
            List<Discipline> disciplines = dbServices.getAllActiveDisciplines();

            //Дополняем полученными данными из SQL request(запрос)
            req.setAttribute("allActiveDisciplines", disciplines);

            //resp.getWriter().println("Hello");
            req.getRequestDispatcher("WEB-INF/disciplinesList.jsp").forward(req, resp);
        }
    }

