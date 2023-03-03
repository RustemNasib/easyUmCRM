package controllers;

import db.DBServices;
import entity.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        распарсиваем три поля из login.jsp
        String role = req.getParameter("role");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

// Проверка на пустой логин и пароль
        if (login == null || login.equals("") || password == null || password.equals("")) {
            req.setAttribute("Error", 2);
            DBServices services = new DBServices();
            List<Role> roles = services.getAllActiveRoles();
//        к запросу пользователя добавляем аттрибут, который нужно передать на jsp страничку
            req.setAttribute("allActiveRoles", roles);
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
            return;
        }


//        создаем объект подключения к базе данных
        DBServices services = new DBServices();

//        через созданный объект вызвали метод (из DBDervices) в который передали поля
        if (services.canLogin(login, password, role)) {
            // если логин пользователя найден в БД
            req.getSession().setAttribute("isLogin", true);
            req.getSession().setAttribute("role", role);
            req.getSession().setAttribute("login", login);

//            переадресовываем на страницу Index.jsp
            resp.sendRedirect("/");

        } else {
            // если логин пользователя не найден в БД
            req.setAttribute("Error", 1);
            List<Role> roles = services.getAllActiveRoles();
            req.setAttribute("allActiveRoles", roles);
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBServices services = new DBServices();
        List<Role> roles = services.getAllActiveRoles();
//        к запросу пользователя добавляем аттрибут, который нужно передать на jsp страничку
        req.setAttribute("allActiveRoles", roles);
        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
    }
}
