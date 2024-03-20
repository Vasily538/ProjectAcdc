package com.example.module3project.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.verification.VerificationMode;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IntroduceTest {

    @Test
    void IntroduceServletTestfnameFilled() throws IOException, ServletException {
        //given
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        HttpServletResponse responseMock = mock(HttpServletResponse.class);
        HttpSession sessionMock = mock(HttpSession.class);

        //when
        when(requestMock.getParameter("fname")).thenReturn("Mike");
        when(requestMock.getRemoteAddr()).thenReturn("127.0.0.1");
        when(requestMock.getContextPath()).thenReturn("");
        when(requestMock.getSession()).thenReturn(sessionMock);

        //then
        new Introduce().doPost(requestMock, responseMock);

        verify(requestMock, atLeast(1)).getParameter("fname");
        verify(requestMock, atLeast(1)).getContextPath();
        verify(requestMock, atLeast(1)).getRemoteAddr();
        verify(sessionMock, atLeast(1)).setAttribute("name", "Mike");
        verify(sessionMock, atLeast(1)).setAttribute("count", 1);
        verify(sessionMock, atLeast(1)).setAttribute("ip", "127.0.0.1");
        verify(responseMock, atLeast(1)).sendRedirect("/take-challenge-ufo");
    }


    @Test
    void IntroduceServletTestfnameNotFilled() throws IOException, ServletException {
        //given
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        HttpServletResponse responseMock = mock(HttpServletResponse.class);
        HttpSession sessionMock = mock(HttpSession.class);

        //when
        when(requestMock.getParameter("fname")).thenReturn("");
        when(requestMock.getRemoteAddr()).thenReturn("127.0.0.1");
        when(requestMock.getContextPath()).thenReturn("");
        when(requestMock.getSession()).thenReturn(sessionMock);

        //then
        new Introduce().doPost(requestMock, responseMock);

        verify(requestMock, atLeast(1)).getParameter("fname");
        verify(requestMock, atLeast(1)).getContextPath();
        verify(requestMock, never()).getRemoteAddr();
        verify(sessionMock, never()).setAttribute("name", "Mike");
        verify(sessionMock, never()).setAttribute("count", 1);
        verify(sessionMock, never()).setAttribute("ip", "127.0.0.1");
        verify(responseMock, atLeast(1)).sendRedirect("/servlet1");
    }
}