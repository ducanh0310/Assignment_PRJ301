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
public class ViewHisotry extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("back")!= null) {
            resp.sendRedirect("UserScreen.jsp");
        }
        
        if(req.getParameter("out") != null) {
            HttpSession session = req.getSession();
            session.setAttribute("accountUser", null);
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ses = req.getSession();
        User u = (User)ses.getAttribute("accountUser");
        ArrayList<Word> hisl = u.viewHis(u.getHis());
        req.setAttribute("hist", hisl);
        req.getRequestDispatcher("History.jsp").forward(req, resp);
        
    }

}
