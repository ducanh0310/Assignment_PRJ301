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
import model.Word;

/**
 *
 * @author DELL
 */
public class AdminScreen extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
               
        if (req.getParameter("logout") != null) {
            HttpSession session = req.getSession();
            session.setAttribute("accountAdmin", null);
            resp.sendRedirect("index.jsp");
        }
        if (req.getParameter("back") != null) {            
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Word w = new Word();
        ArrayList<Word> data = w.getListWord();
        HttpSession ses = req.getSession();
        ses.setAttribute("data", data);
        req.getRequestDispatcher("AdminScreen.jsp").forward(req, resp);

    }

}
