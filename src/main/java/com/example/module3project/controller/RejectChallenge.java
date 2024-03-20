package com.example.module3project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reject-challenge")
public class RejectChallenge extends HttpServlet {
    private String message1;
    private String message2;
    private String message3;

    @Override
    public void init() throws ServletException {
        message1 = "Ты отклонил вызов.";
        message2 = "Поражение";
        message3 = "Начать заново";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message1",message1);
        req.setAttribute("message2",message2);
        req.setAttribute("message3",message3);
        RequestDispatcher requestDispatcher =req.getRequestDispatcher("rejectChallenge.jsp");
        requestDispatcher.forward(req,resp);
    }
}
