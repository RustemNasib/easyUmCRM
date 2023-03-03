package filters;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Что сделать при запуске Tomcat 1 раз
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // Для каждого контроллера
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");

        // Можно запускать другие фильтры

        //Код до 24 строки обрабатывает req и resp которые идут от user к servlet

        // Выйти из фильтра и продолжить выполнение основного потока
        filterChain.doFilter(servletRequest, servletResponse);

        //Код после 24 строки обрабатывает req и resp которые идут от servlet к user
    }

    @Override
    public void destroy() {
        //Что сделать при выключении Tomcat 1 раз

    }
}
