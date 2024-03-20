package com.example.module3project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    private String message1;
    private String message2;
    private String message3;
    private String message4;
    private String message5;

    @Override
    public void init() throws ServletException {
        message1 = "Пролог";
        message2 = "Ты стоишь в космическом порту и готов подняться на борт\n" +
                "своего корабля. Разве ты не об этом мечтал? Стать капиатном\n" +
                "галактического судна с экипажем, который будет совершать\n" +
                "подвиги под твоим командованием.\n" +
                "Так что вперед!";
        message3 = "Знакомство с экипажем";
        message4 = "Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в руках:\n" +
                "- Здравствуйте, командир! Я Зинаиса - ваша помощница. Видите? Там в углу пьет кофе\n" +
                "наш штурман - серфант Перегарный Шлейф, под штурвалом спит наш бортмеханик - Черный Богдан,\n" +
                "а фотографирует его Сергей Стальная Пятка - наш навигатор.\n" +
                "А как обращаться к вам?";
        message5 = "Представиться";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // HttpSession session = req.getSession();
        //printPage(resp);
        req.setAttribute("message1", message1);
        req.setAttribute("message2", message2);
        req.setAttribute("message3", message3);
        req.setAttribute("message4", message4);
        req.setAttribute("message5", message5);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("servlet1.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int count = (Integer) session.getAttribute("count");
        if (count != 1) {
            resp.sendRedirect(req.getContextPath() + "/take-challenge-ufo");
            return;
        }

        resp.sendRedirect(req.getContextPath() + "/take-challenge-ufo");
    }

}
