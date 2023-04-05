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
public class WordController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vie = "", eng = "", type = "", examv = "", exame = "", c = "";
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
            req.getRequestDispatcher("AddWord.jsp").forward(req, resp);
            return;
        }

        HttpSession ses = req.getSession();
        ArrayList<Word> data = (ArrayList<Word>) (ses.getAttribute("data"));

        if (req.getParameter("add") != null) {
            Word w = new Word(eng, vie, type, examv, exame);
            w.addWord();
            w.setId(w.getID());
            data.add(w);
            ses.setAttribute("data", data);
            resp.sendRedirect("AdminScreen.jsp");
        }

    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = 0;
        id = Integer.parseInt(req.getParameter("id"));
        Word w = new Word();
        if (req.getParameter("mod").equals("1") && id != 0) {
            w = w.getWordById(id);
            
             HttpSession session = req.getSession(); 
             session.setAttribute("wu", w);
            
            
            
            req.setAttribute("w", w);
            req.getRequestDispatcher("Update.jsp").forward(req, resp);
            System.out.println(w.toString());
        }

        if (req.getParameter("mod").equals("2") && id != 0) {
            w.Delete(id);
//           
            resp.sendRedirect("admin");

        }
    }
}
