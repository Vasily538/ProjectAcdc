package com.example.module3project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;

class GoUpToTheBridgeTest {

    @Test
   void doPostTest() throws ServletException, IOException {
        //given
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        HttpServletResponse responseMock = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcherMock = mock(RequestDispatcher.class);
        //when
        when(requestMock.getRequestDispatcher("goUpToTheBridge.jsp")).thenReturn(requestDispatcherMock);
         //then
        new GoUpToTheBridge().doPost(requestMock, responseMock);

        verify(requestMock, atLeastOnce()).getRequestDispatcher("goUpToTheBridge.jsp");
        verify(requestDispatcherMock, only()).forward(requestMock,responseMock);
    }
}