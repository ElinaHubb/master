package com.elina.rbp107;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Объявляем класс наследующийся от HttpServlet и переопределяющий его метод
doGet(HttpServletRequest req, HttpServletResponse resp)
 */
public class MyServlet extends HttpServlet {

    /**
     * Метод загружающий страницу page.jsp,
     * метод срабатывает при запросе типа GET
     *
     * @param req отвечает за объект-запрос
     * @param resp отвечает за объект-ответ
     * @throws ServletException исключение типа ServletException
     * @throws IOException исключение типа IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //Показываем страницу page.jsp
        req.getRequestDispatcher("page.jsp").forward(req, resp);
    }

}
