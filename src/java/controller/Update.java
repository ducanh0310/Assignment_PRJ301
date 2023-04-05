/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.WordController.removeCharAt;
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
public class Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vie = "", eng = "", type = "", examv = "", exame = "", c = "";
        int id = Integer.parseInt(req.getParameter("id"));
        if (req.getParameter("back") != null) {
            resp.sendRedirect("AdminScreen.jsp");
            return;
        }
        try {
            vie = req.getParameter("vie");
            eng = req.getParameter("eng");

            if (req.getParameter("0") != null) {
                type += "Danh từ(noun), ";
            }
            if (req.getParameter("1") != null) {
                type += "Tính từ(adj), ";
            }
            if (req.getParameter("2") != null) {
                type += "Động từ(verb), ";
            }
            if (req.getParameter("3") != null) {
                type += "Trạng từ(adv), ";
            }
            if (req.getParameter("4") != null) {
                type += "Đại từ(pronouns), ";
            }
            if (req.getParameter("5") != null) {
                type += "Giới từ(preposition), ";
            }
            if (req.getParameter("6") != null) {
                type += "Mạo từ(article), ";
            }

            examv = req.getParameter("examv");
            exame = req.getParameter("exame");
            type = removeCharAt(type, type.length() - 1);
            type = removeCharAt(type, type.length() - 1);

            if (vie.equals("") || eng.equals("") || exame.equals("") || examv.equals("")) {
                throw new Exception();
            }
        } catch (Exception e) {
            c = "Vui long nhap day du!";
            req.setAttribute("c", c);
            req.getRequestDispatcher("Update.jsp").forward(req, resp);
            return;
        }

        HttpSession ses = req.getSession();
        ArrayList<Word> data = (ArrayList<Word>) (ses.getAttribute("data"));

        if (req.getParameter("add") != null) {
            Word w = new Word(eng, vie, type, examv, exame);
            
            w.Update(id);
            data = w.getListWord();
            ses.setAttribute("data", data);
            resp.sendRedirect("AdminScreen.jsp");
        }

    }

}
