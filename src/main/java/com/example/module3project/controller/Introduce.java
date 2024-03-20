package com.example.module3project.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/introduce-servlet")
public class Introduce extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("fname");
        if (name != null && !name.equals("")) {
            HttpSession session = req.getSession();
            session.setAttribute("name", name);
            session.setAttribute("count", 1);
            session.setAttribute("ip", req.getRemoteAddr().toString());
            resp.sendRedirect(req.getContextPath() + "/take-challenge-ufo");
        } else {
            resp.sendRedirect(req.getContextPath() + "/servlet1");
        }
    }

}
