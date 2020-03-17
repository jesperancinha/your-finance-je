package org.jesperancinha.fintech.controller;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;

@WebServlet("/control")
public class SimpleServlet extends HttpServlet {

    @Context
    private SecurityContext sc;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("This is just a control point to the banking application");
//        response.getWriter().println(sc.getAuthenticationScheme());
    }
}