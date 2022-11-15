package com.app.controllers;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@WebServlet("/guestbook")
public class GuestBook extends HttpServlet {

    String filePath = new File("").getAbsolutePath();

    String filename = filePath.concat("/src/main/resources/names");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        try {
            Files.write(Paths.get(filename), ("\n" + name).getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            String[] namesArr = everything.split("\n");
            req.getServletContext().setAttribute("namesArr", namesArr);
            req.getServletContext().setAttribute("names", everything);
        }

        req.getRequestDispatcher("/guestBook.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            String[] namesArr = everything.split("\n");
            req.getServletContext().setAttribute("namesArr", namesArr);
            req.getServletContext().setAttribute("names", everything);
        }

        req.getRequestDispatcher("/guestBook.jsp").forward(req, resp);
    }
}
