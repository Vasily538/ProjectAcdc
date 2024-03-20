package com.example.module3project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/went-up-to-the-bridge")
public class WentUpToTheBridge extends HttpServlet {
    private String message1;
    private String message2;
    private String message3;
    private String message4;

    @Override
    public void init() throws ServletException {
        message1 = "Ты Поднялся на мостик.";
        message2 = "Ты кто?";
        message3 = "Рассказать правду о себе";
        message4 = "Солгать о себе";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setAttribute("message1",message1);
        req.setAttribute("message2",message2);
        req.setAttribute("message3",message3);
        req.setAttribute("message4",message4);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("wentToTheBridge.jsp");
        requestDispatcher.forward(req,resp);
    }
}
