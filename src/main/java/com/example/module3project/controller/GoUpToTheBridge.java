package com.example.module3project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/go-up-to-the-bridge")
public class GoUpToTheBridge extends HttpServlet {
    private String message1;


    @Override
    public void init() throws ServletException {
        message1 = "Подняться на мостик";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message1", message1);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("goUpToTheBridge.jsp");
        requestDispatcher.forward(req, resp);
    }
}
