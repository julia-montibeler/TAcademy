package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
//    @Override
//    protected  void doGet(HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException {
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
////            response.getWriter().println("<h3>Olá da Servlet</h3>");
//            out.println("<h3>Olá da Servlet</h3>");
//
//    }
    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setAttribute("mensagem", "Olá da Servlet");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}