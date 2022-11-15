package com.app.controllers;

import com.app.dao.UserDao;
import com.app.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@WebServlet("/usercontroller")
public class UserController extends HttpServlet {

    UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        List<User> userlist = userDao.getListUser();

        User finded = null;
        for (User user : userlist) {
            if((user.getLogin().equals(login)) && (user.getPassword().equals(password.substring(0,
                    password.length()-3)))){
                finded = user;
                break;
            }
        }
        System.out.println(userlist);
        if(finded != null){
            System.out.println("Есть такой!");
            req.getServletContext().setAttribute("time", new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime()));
            req.getRequestDispatcher("/time.jsp").forward(req, resp);
        } else {
            System.out.println("Нет такого!");
            String path = "/index.html";
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello");
    }
}
