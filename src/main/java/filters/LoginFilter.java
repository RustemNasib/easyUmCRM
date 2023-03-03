package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    /* Приведем переменные ServletRequest и ServletResponse к дочернему типу HttpServletRequest, чтобы получить методы
    работы с сессиями getSession()
     */
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // Разрешить доступ запросов браузера на файлы ресуросв сайта типа css, js и тд
        String url = req.getRequestURI();
        if (url.endsWith(".css") || url.endsWith(".js")){

            // тогда такой запрос пропускаем на контроллер без изменений
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //Проверим есть ли у req аттрибут isLogin в сессии Томката ранее созданной
        Object isLogin = req.getSession().getAttribute("isLogin");

    //Если isLogin = true, то пользователь в сессии залогинен, и он идет на login
        if (isLogin != null && url.endsWith("/login")) {
            //перенаправляем на index
            resp.sendRedirect("/");
            return;
        }

        //Если isLogin = true, то пользователь в сессии залогинен и он идет не на login
        if (isLogin != null && !url.endsWith("/login")) {
            //пропускаем запрос как есть без изменений
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
//Если isLogin = null, то пользователь в сессии незалогинен и он идет на login
        if (url.endsWith("/login")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {

    }
}
