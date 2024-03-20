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

@WebServlet("/take-challenge")
public class TakeChallenge extends HttpServlet {
    private String message1;
    private String message2;
    private String message3;
    private String message4;
    private String message5;
    private String message6;
    private String message7;

    @Override
    public void init() throws ServletException {
        message1 = "Ты принял вызов";
        message2 = "Поднимаешься на мостик к капитану?";
        message3 = "Подняться на мостик";
        message4 = "Отказаться подниматься на мостик";
        message5 = "Статистика:";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        message6 = session.getAttribute("ip").toString();
        message7 = session.getAttribute("name").toString();
        int count = (Integer) session.getAttribute("count");
        req.setAttribute("message1",message1);
        req.setAttribute("message2",message2);
        req.setAttribute("message3",message3);
        req.setAttribute("message4",message4);
        req.setAttribute("message5",message5);
        req.setAttribute("message6",message6);
        req.setAttribute("message7",message7);
        req.setAttribute("count",count);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("takeChallenge.jsp");
        requestDispatcher.forward(req,resp);
        count++;
        session.setAttribute("count", count);
    }
}
