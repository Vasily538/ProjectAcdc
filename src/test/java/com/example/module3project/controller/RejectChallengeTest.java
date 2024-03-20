package com.example.module3project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;

class RejectChallengeTest {

    @Test
    void doPostTest() throws ServletException, IOException {
        //given
        HttpServletRequest requestMock = mock(HttpServletRequest.class);
        HttpServletResponse responseMock = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcherMock = mock(RequestDispatcher.class);

        //when
        when(requestMock.getRequestDispatcher("rejectChallenge.jsp")).thenReturn(requestDispatcherMock);

        doNothing().when(requestMock).setAttribute(eq("message1"), anyString());
        doNothing().when(requestMock).setAttribute(eq("message2"), anyString());
        doNothing().when(requestMock).setAttribute(eq("message3"), anyString());

        //then
        RejectChallenge rejectChallenge = new RejectChallenge();
        rejectChallenge.init();
        rejectChallenge.doPost(requestMock, responseMock);

        verify(requestMock, atLeast(1)).setAttribute(eq("message1"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("message2"), anyString());
        verify(requestMock, atLeast(1)).setAttribute(eq("message3"), anyString());
        verify(requestMock, atLeastOnce()).getRequestDispatcher("rejectChallenge.jsp");
        verify(requestDispatcherMock, only()).forward(requestMock,responseMock);

    }
}