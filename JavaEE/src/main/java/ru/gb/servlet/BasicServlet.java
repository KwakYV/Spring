package ru.gb.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;


@Slf4j
public class BasicServlet implements Servlet {
    private transient ServletConfig config;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        log.info("New request for basic servlet");
        servletResponse.getWriter().println("<h1> My first servlet");
    }

    @Override
    public String getServletInfo() {
        return "BasicServlet";
    }

    @Override
    public void destroy() {
        log.info("Application closed!!!");
    }
}
