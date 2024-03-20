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

class WentUpToTheBridgeTest {

    @Test
    void doPost() throws ServletException, IOException {
        //given
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        HttpServletResponse responseMock = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcherMock = mock(RequestDispatcher.class);

        //when
        when(requestMock.getRequestDispatcher("wentToTheBridge.jsp")).thenReturn(requestDispatcherMock);

        doNothing().when(requestMock).setAttribute(eq("message1"), anyString());
        doNothing().when(requestMock).setAttribute(eq("message2"), anyString());
        doNothing().when(requestMock).setAttribute(eq("message3"), anyString());
        doNothing().when(requestMock).setAttribute(eq("message4"), anyString());

        //then
        WentUpToTheBridge wentUpToTheBridge = new WentUpToTheBridge();
        wentUpToTheBridge.init();
        wentUpToTheBridge.doPost(requestMock, responseMock);

        verify(requestMock, atLeast(1)).setAttribute(eq("message1"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("message2"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("message3"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("message4"), anyString());
        verify(requestMock, atLeastOnce()).getRequestDispatcher("wentToTheBridge.jsp");
        verify(requestDispatcherMock, only()).forward(requestMock,responseMock);
    }
}