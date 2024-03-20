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

class TakeChallengeTest {

    @Test
    void doPost() throws ServletException, IOException {
        //given
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        HttpServletResponse responseMock = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcherMock = mock(RequestDispatcher.class);
        HttpSession sessionMock = mock(HttpSession.class);

        //when
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(requestMock.getRequestDispatcher("takeChallenge.jsp")).thenReturn(requestDispatcherMock);
        when(sessionMock.getAttribute("count")).thenReturn(5);
        when(sessionMock.getAttribute("ip")).thenReturn("127.0.0.1");
        when(sessionMock.getAttribute("name")).thenReturn("Mike");
        doNothing().when(requestMock).setAttribute(eq("message1"), anyString());
        doNothing().when(requestMock).setAttribute(eq("message2"), anyString());
        doNothing().when(requestMock).setAttribute(eq("message3"), anyString());
        doNothing().when(requestMock).setAttribute(eq("message4"), anyString());
        doNothing().when(requestMock).setAttribute(eq("message5"), anyString());
        doNothing().when(requestMock).setAttribute(eq("message6"), anyString());
        doNothing().when(requestMock).setAttribute(eq("message7"), anyString());
        doNothing().when(requestMock).setAttribute(eq("count"), anyInt());


        //then
        TakeChallenge takeChallenge = new TakeChallenge();
        takeChallenge.init();
        takeChallenge.doPost(requestMock, responseMock);

        verify(requestMock, atLeast(1)).setAttribute(eq("message1"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("message2"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("message3"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("message4"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("message5"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("message6"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("message7"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("count"), anyInt());
        verify(requestMock, atLeastOnce()).getRequestDispatcher("takeChallenge.jsp");
        verify(requestDispatcherMock, only()).forward(requestMock,responseMock);
        verify(sessionMock, atLeast(1)).getAttribute(eq("ip"));
        verify(sessionMock, atLeast(1)).getAttribute(eq("name"));
        verify(sessionMock, atLeast(1)).getAttribute(eq("count"));
        verify(requestMock,atLeastOnce()).getSession();
    }
}