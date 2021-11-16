package ru.gb.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
@WebServlet(name = "TestHttpServlet", urlPatterns = "test_http_servlet")
public class TestHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("New Get for TestHttpServlet");
        log.info(req.getContextPath());
        log.info(req.getServletPath());
        log.info(req.getQueryString());
        resp.setHeader("Content-Type","text/html; charset=utf-8");
        resp.getWriter().println("<h1>New Get Request</h1>");

        resp.getWriter().println("<h2>Parameters</h2>");
        resp.getWriter().printf("<h2>Param1=%s, Param2=%s, Param3=%s</h2>",
                req.getParameter("param1"),
                req.getParameter("param2"),
                req.getParameter("param3"));

        /* Перенаправление реквеста*/
        getServletContext().getRequestDispatcher("/basic_servlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("New Post for TestHttpServlet");

        resp.getWriter().println("<h1>New POST request</h1>");
        resp.getWriter().printf("<h1>Echo: %s</h1>", readAllLines(req.getReader()));
    }

    private String readAllLines(BufferedReader reader) throws IOException {
        StringBuilder content = new StringBuilder();
        String line;

        while((line = reader.readLine()) != null){
            content.append(line);
            content.append(System.lineSeparator());
        }
        return content.toString();
    }
}
