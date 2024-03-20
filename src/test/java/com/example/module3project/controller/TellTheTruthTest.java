package com.example.module3project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.only;

class TellTheTruthTest {

    @Test
    void doPost() throws ServletException, IOException {
        //given
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        HttpServletResponse responseMock = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcherMock = mock(RequestDispatcher.class);

        //when
        when(requestMock.getRequestDispatcher("tellTheTruth.jsp")).thenReturn(requestDispatcherMock);

        doNothing().when(requestMock).setAttribute(eq("message1"), anyString());
        doNothing().when(requestMock).setAttribute(eq("message2"), anyString());
        doNothing().when(requestMock).setAttribute(eq("message3"), anyString());

        //then
        TellTheTruth tellTheTruth = new TellTheTruth();
        tellTheTruth.init();
        tellTheTruth.doPost(requestMock, responseMock);

        verify(requestMock, atLeast(1)).setAttribute(eq("message1"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("message2"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("message3"), anyString());
        verify(requestMock, atLeastOnce()).getRequestDispatcher("tellTheTruth.jsp");
        verify(requestDispatcherMock, only()).forward(requestMock,responseMock);
    }
}