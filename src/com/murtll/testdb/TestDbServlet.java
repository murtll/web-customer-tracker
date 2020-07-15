package com.murtll.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

//    private Driver driver;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        setup connection variables
        String username = "student";
        String password = "student";
        String dbUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";

        String driver = "com.mysql.cj.jdbc.Driver";

//        test connection
        try {
            PrintWriter out = response.getWriter();

            out.println("Connecting to the database " + dbUrl + "...");

            Class.forName(driver);

            Connection connection = DriverManager.getConnection(dbUrl, username, password);

            out.println("Connection successful!");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
