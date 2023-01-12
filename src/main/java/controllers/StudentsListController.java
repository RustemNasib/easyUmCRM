package controllers;

import db.DBServices;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentsListController", urlPatterns = "/studentsList")
public class StudentsListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().println("Hello");
        req.getRequestDispatcher("WEB-INF/studentsList.jsp").forward(req, resp);
        //Создать объект типа dbServices
        DBServices dbServices = new DBServices();

        //Вызвать метод getAllActiveStudents
        List<Student> students = dbServices.getAllActiveStudents();

        //Дополняем полученными данными из SQL request(запрос)
        req.setAttribute("allActiveStudents", students);
    }
}
