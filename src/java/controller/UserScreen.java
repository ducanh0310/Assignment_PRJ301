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
import model.User;
import model.Word;

/**
 *
 * @author DELL
 */
public class UserScreen extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("translate") != null) {
            resp.sendRedirect("UserTranslate.jsp");
        }
       
        if (req.getParameter("change") != null) {
            resp.sendRedirect("ChangePass.jsp");
        }

        if (req.getParameter("viewhis") != null) {
            
            resp.sendRedirect("viewhis");
        }
        if (req.getParameter("viewstar") != null) {
            
            resp.sendRedirect("viewstar");
        }

        if (req.getParameter("logout") != null) {
            HttpSession session = req.getSession();
            session.setAttribute("accountUser", null);
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
