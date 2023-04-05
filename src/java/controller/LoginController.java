/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import model.Admin;
import model.User;

/**
 *
 * @author DELL
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acc = "";
        String pass = "";
        String c = "";
        try {
            acc = req.getParameter("acc");
            pass = req.getParameter("pass");
            if(req.getParameter("back")!=null) {
                resp.sendRedirect("index.jsp");
                return;
            }
            
            if (acc.equals("") || pass.equals("")) {
                throw new Exception();
            }
        } catch (Exception e) {
            c = "Please enter full information";
            req.setAttribute("c", c);
            req.getRequestDispatcher("LoginUser.jsp").forward(req, resp);
            return;
        }
        User u = new User(acc, pass);
        if (u.check()) {
            u.getUser();
            HttpSession session = req.getSession();
            session.setAttribute("accountUser", u);
            req.getRequestDispatcher("UserScreen.jsp").forward(req, resp);

        } else {
            c = "Incorrect password or account! Please re-enter";
            req.setAttribute("c", c);
            req.getRequestDispatcher("LoginUser.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acc = "";
        String pass = "";
        String c = "";

        try {
            acc = req.getParameter("acc");
            pass = req.getParameter("pass");
            if(req.getParameter("back")!=null) {
                resp.sendRedirect("index.jsp");
                
                return;
            }
            if (acc.equals("") || pass.equals("")) {
                throw new Exception();
            }
        } catch (Exception e) {
            c = "Please enter full information";
            req.setAttribute("c", c);
            req.getRequestDispatcher("LoginAdmin.jsp").forward(req, resp);
            return;
        }

        Admin a = new Admin(acc, pass);
        if (a.getAdmin()) {
            HttpSession session = req.getSession();
            session.setAttribute("accountAdmin", a);
            resp.sendRedirect("admin");
        } else {
            c = "Incorrect password or account! Please re-enter";
            req.setAttribute("c", c);
            req.getRequestDispatcher("LoginAdmin.jsp").forward(req, resp);
        }

    }

}
