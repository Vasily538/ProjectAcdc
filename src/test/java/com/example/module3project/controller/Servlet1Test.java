package com.example.module3project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.only;

class Servlet1Test {

    @Test
    void doGet() throws ServletException, IOException {
        //given
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        HttpServletResponse responseMock = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcherMock = mock(RequestDispatcher.class);

        //when
        when(requestMock.getRequestDispatcher("servlet1.jsp")).thenReturn(requestDispatcherMock);

        doNothing().when(requestMock).setAttribute(eq("message1"), anyString());
        doNothing().when(requestMock).setAttribute(eq("message2"), anyString());
        doNothing().when(requestMock).setAttribute(eq("message3"), anyString());
        doNothing().when(requestMock).setAttribute(eq("message4"), anyString());
        doNothing().when(requestMock).setAttribute(eq("message5"), anyString());

        //then
        Servlet1 servlet1 = new Servlet1();
        servlet1.init();
        servlet1.doGet(requestMock, responseMock);

        verify(requestMock, atLeast(1)).setAttribute(eq("message1"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("message2"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("message3"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("message4"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("message5"), anyString());

        verify(requestMock, atLeastOnce()).getRequestDispatcher("servlet1.jsp");
        verify(requestDispatcherMock, only()).forward(requestMock, responseMock);
    }

    @Test
    void doPostCountIsNotOne() throws IOException, ServletException {
        //given
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        HttpServletResponse responseMock = mock(HttpServletResponse.class);
        HttpSession sessionMock = mock(HttpSession.class);

        //when
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(sessionMock.getAttribute("count")).thenReturn(2);
        when(requestMock.getContextPath()).thenReturn("");

        //then
        Servlet1 servlet1 = new Servlet1();
        servlet1.init();
        servlet1.doPost(requestMock, responseMock);
        verify(sessionMock, atLeast(1)).getAttribute("count");
        verify(requestMock, atLeast(1)).getContextPath();
        verify(responseMock, atLeast(1)).sendRedirect("/take-challenge-ufo");

    }

    @Test
    void doPostCountIsOne() throws ServletException, IOException {
        //given
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        HttpServletResponse responseMock = mock(HttpServletResponse.class);
        HttpSession sessionMock = mock(HttpSession.class);

        //when
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(sessionMock.getAttribute("count")).thenReturn(1);
        when(requestMock.getContextPath()).thenReturn("");

        //then
        Servlet1 servlet1 = new Servlet1();
        servlet1.init();
        servlet1.doPost(requestMock, responseMock);
        verify(sessionMock, atLeast(1)).getAttribute("count");
        verify(requestMock, atLeast(1)).getContextPath();
        verify(responseMock, atLeast(1)).sendRedirect("/take-challenge-ufo");
    }
}