package com.example.module3project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/take-challenge-ufo")
public class TakeChallengeUfo extends HttpServlet {
    private String message1;
    private String message2;
    private String message3;
    private String message4;

    @Override
    public void init() throws ServletException {
        message1 = "Ты потерял память";
        message2 = "Принять вызов НЛО?";
        message3 = "Принять вызов";
        message4 = "Отклонить вызов";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message1",message1);
        req.setAttribute("message2",message2);
        req.setAttribute("message3",message3);
        req.setAttribute("message4",message4);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("takeChallengeUfo.jsp");
        requestDispatcher.forward(req,resp);
    }
}
