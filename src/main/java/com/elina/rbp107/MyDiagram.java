package com.elina.rbp107;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* Объявляем класс наследующийся от HttpServlet и переопределяющий два его метода
doGet(HttpServletRequest req, HttpServletResponse resp) и
doPost(HttpServletRequest req, HttpServletResponse resp)
 */
public class MyDiagram extends HttpServlet {

    // Переменные отвечающие за среднее значение по каждой области
    public static Double health_ave;
    public static Double fun_ave;
    public static Double environment_ave;
    public static Double rich_ave;

    /**
     * Метод строящий график, метод срабатывает при запросе типа GET
     *
     * @param req отвечает за объект-запрос
     * @param resp отвечает за объект-ответ
     * @throws ServletException исключение типа ServletException
     * @throws IOException исключение типа IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        BufferedImage image = new BufferedImage(1500, 900, BufferedImage.TYPE_INT_RGB);

        Graphics graphics = image.getGraphics();

        // Заполняет фон белый цветом
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 1500, 900);

        // Рисуем часть графика, отвечающего за Здоровье
        graphics.setColor(Color.GREEN);
        Double w_h_health = health_ave * 80;
        graphics.fillArc((int) (760 - w_h_health / 2), (int) (460 - w_h_health / 2), w_h_health.intValue(), w_h_health.intValue(), 90, 90);

        // Рисуем часть графика, отвечающего за Яркость жизни
        graphics.setColor(Color.RED);
        Double w_h_fun = fun_ave * 80;
        graphics.fillArc((int) (760 - w_h_fun / 2), (int) (460 - w_h_fun / 2), w_h_fun.intValue(), w_h_fun.intValue(), 0, 90);

        // Рисуем часть графика, отвечающего за Окружение
        graphics.setColor(Color.BLUE);
        Double w_h_environment = environment_ave * 80;
        graphics.fillArc((int) (760 - w_h_environment / 2), (int) (460 - w_h_environment / 2), w_h_environment.intValue(), w_h_environment.intValue(), 180, 90);

        // Рисуем часть графика, отвечающего за Обеспеченность
        graphics.setColor(Color.MAGENTA);
        Double w_h_rich = rich_ave * 80;
        graphics.fillArc((int) (760 - w_h_rich / 2), (int) (460 - w_h_rich / 2), w_h_rich.intValue(), w_h_rich.intValue(), 270, 90);

        // Рисуноем стрелки и оси
        graphics.setColor(Color.BLACK);
        graphics.drawLine(760, 0, 760, 900);
        graphics.drawLine(0, 460, 1500, 460);
        graphics.drawString("0", 748, 455);
        graphics.drawString("1", 748, 415);
        graphics.drawString("2", 748, 375);
        graphics.drawString("3", 748, 335);
        graphics.drawString("4", 748, 295);
        graphics.drawString("5", 748, 255);
        graphics.drawString("6", 748, 215);
        graphics.drawString("7", 748, 175);
        graphics.drawString("8", 748, 135);
        graphics.drawString("9", 748, 95);
        graphics.drawString("10", 740, 55);

        graphics.setColor(Color.LIGHT_GRAY);
        graphics.drawArc(720, 420, 80, 80, 0, 360);
        graphics.drawArc(680, 380, 160, 160, 0, 360);
        graphics.drawArc(640, 340, 240, 240, 0, 360);
        graphics.drawArc(600, 300, 320, 320, 0, 360);
        graphics.drawArc(560, 260, 400, 400, 0, 360);
        graphics.drawArc(520, 220, 480, 480, 0, 360);
        graphics.drawArc(480, 180, 560, 560, 0, 360);
        graphics.drawArc(440, 140, 640, 640, 0, 360);
        graphics.drawArc(400, 100, 720, 720, 0, 360);
        graphics.drawArc(360, 60, 800, 800, 0, 360);

        /* Рисуем условные обозначения по цветам для каждой области,
        которые будут отображаться слева наверху
         */
        graphics.setColor(Color.GREEN);
        graphics.fillRect(30, 30, 50, 30);
        graphics.setColor(Color.RED);
        graphics.fillRect(30, 70, 50, 30);
        graphics.setColor(Color.BLUE);
        graphics.fillRect(30, 110, 50, 30);
        graphics.setColor(Color.MAGENTA);
        graphics.fillRect(30, 150, 50, 30);

        /*
        Пишем текст напротив обозначений цветов для каждоый области
         */
        graphics.setColor(Color.BLACK);
        graphics.drawString(new String("- ЗДОРОВЬЕ".getBytes(), Charset.forName("UTF-8")), 90, 50);
        graphics.drawString(new String("- ЯРКОСТЬ ЖИЗНИ".getBytes(), Charset.forName("UTF-8")), 90, 90);
        graphics.drawString(new String("- ОКРУЖЕНИЕ".getBytes(), Charset.forName("UTF-8")), 90, 130);
        graphics.drawString(new String("- ОБЕСПЕЧЕННОСТЬ".getBytes(), Charset.forName("UTF-8")), 90, 170);

        graphics.dispose();

        // Отрисовываем изображение на экране
        resp.setContentType("image/png");
        OutputStream outputStream = resp.getOutputStream();
        ImageIO.write(image, "png", outputStream);
        outputStream.close();
    }

    /**
     * Метод считающий средние значения по каждоый области,
     * метод срабатывает при запросе типа GET
     *
     * @param req отвечает за объект-запрос
     * @param resp отвечает за объект-ответ
     * @throws ServletException исключение типа ServletException
     * @throws IOException исключение типа IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Считаем среднее значение по области Здоровье
        Integer health_sum =
                        Integer.parseInt(req.getParameter("health_1") == "" ? "0" : req.getParameter("health_1")) +
                        Integer.parseInt(req.getParameter("health_2") == "" ? "0" : req.getParameter("health_2")) +
                        Integer.parseInt(req.getParameter("health_3") == "" ? "0" : req.getParameter("health_3")) +
                        Integer.parseInt(req.getParameter("health_4") == "" ? "0" : req.getParameter("health_4")) +
                        Integer.parseInt(req.getParameter("health_5") == "" ? "0" : req.getParameter("health_5")) +
                        Integer.parseInt(req.getParameter("health_6") == "" ? "0" : req.getParameter("health_6")) +
                        Integer.parseInt(req.getParameter("health_7") == "" ? "0" : req.getParameter("health_7"));
        health_ave = Math.round(((double) health_sum + 0.0) / 7.0 * 100.0) / 100.0;

        // Считаем среднее значение по области Яркость жизни
        Integer fun_sum =
                        Integer.parseInt(req.getParameter("fun_1") == "" ? "0" : req.getParameter("fun_1")) +
                        Integer.parseInt(req.getParameter("fun_2") == "" ? "0" : req.getParameter("fun_2")) +
                        Integer.parseInt(req.getParameter("fun_3") == "" ? "0" : req.getParameter("fun_3")) +
                        Integer.parseInt(req.getParameter("fun_4") == "" ? "0" : req.getParameter("fun_4")) +
                        Integer.parseInt(req.getParameter("fun_5") == "" ? "0" : req.getParameter("fun_5"));
        fun_ave = Math.round(((double) fun_sum + 0.0) / 5.0 * 100.0) / 100.0;

        // Считаем среднее значение по области Окружение
        Integer environment_sum =
                        Integer.parseInt(req.getParameter("environment_1") == "" ? "0" : req.getParameter("environment_1")) +
                        Integer.parseInt(req.getParameter("environment_2") == "" ? "0" : req.getParameter("environment_2")) +
                        Integer.parseInt(req.getParameter("environment_3") == "" ? "0" : req.getParameter("environment_3")) +
                        Integer.parseInt(req.getParameter("environment_4") == "" ? "0" : req.getParameter("environment_4")) +
                        Integer.parseInt(req.getParameter("environment_5") == "" ? "0" : req.getParameter("environment_5"));
        environment_ave = Math.round(((double) environment_sum + 0.0) / 5.0 * 100.0) / 100.0;

        // Считаем среднее значение по области Обеспеченность
        Integer rich_sum =
                Integer.parseInt(req.getParameter("rich_1") == "" ? "0" : req.getParameter("rich_1")) +
                Integer.parseInt(req.getParameter("rich_2") == "" ? "0" : req.getParameter("rich_2")) +
                Integer.parseInt(req.getParameter("rich_3") == "" ? "0" : req.getParameter("rich_3")) +
                Integer.parseInt(req.getParameter("rich_4") == "" ? "0" : req.getParameter("rich_4")) +
                Integer.parseInt(req.getParameter("rich_5") == "" ? "0" : req.getParameter("rich_5"));
        rich_ave = Math.round(((double) rich_sum + 0.0) / 5.0 * 100.0) / 100.0;

        // Вызываем метод doGet этого же класса
        doGet(req, resp);

    }

}