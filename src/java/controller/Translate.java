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
import model.User;
import model.Word;

/**
 *
 * @author DELL
 */
public class Translate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User u = new User();
        HttpSession ses = req.getSession();
        String vie1 = "", eng1 = "";
        if (ses.getAttribute("accountUser") != null) {
            u = (User) ses.getAttribute("accountUser");
            Word w1 = new Word();
            Word w2 = new Word();
            String c1 = "", c2 = "";
            int check = 1;
            try {
                vie1 = req.getParameter("vie1");
                eng1 = req.getParameter("eng1");

                if (req.getParameter("ok1") != null) {
                    w1.translateVieToEng(vie1);
                    u.addHis(w1);
                    req.setAttribute("w1", w1);
                    if (w1.getEng() == null && !w1.getVie().equals("")) {
                        c1 = "Sorry, we don't have this word in our dictionary yet!";
                    }
                }

                if (req.getParameter("star1") != null) {
                    w1.translateVieToEng(vie1);
                    u.addHis(w1);
                    u.addStar(w1);
                    req.setAttribute("w1", w1);
                    c1 = "Add Star Successfully";
                    if (w1.getEng() == null && !w1.getVie().equals("")) {
                        c1 = "Sorry, we don't have this word in our dictionary yet!";
                    }
                }

                if (req.getParameter("ok2") != null) {
                    check = 2;
                    w2.translateEngToVie(eng1);
                    u.addHis(w2);
                    req.setAttribute("w2", w2);

                    if (w2.getVie() == null && !w2.getEng().equals("")) {
                        c2 = "Sorry, we don't have this word in our dictionary yet";

                    }
                }
                if (req.getParameter("star2") != null) {
                    check = 2;
                    w2.translateEngToVie(eng1);
                    u.addHis(w2);
                    u.addStar(w2);
                    req.setAttribute("w2", w2);
                    c2 = "Add Star Successfully";
                    if (w2.getVie() == null && !w2.getEng().equals("")) {
                        c2 = "Sorry, we don't have this word in our dictionary yet";

                    }
                }
                
                 if (req.getParameter("back") != null) {
                     resp.sendRedirect("UserScreen.jsp");
                     return;
                 }
                
            } catch (Exception e) {
                if (check == 1) {
                    if (vie1.equals("")) {
                        c1 = "Please enter a word";
                    } else {
                        c1 = "Sorry, we don't have this word in our dictionary yet";
                    }
                }
                if (check == 2) {
                    if (eng1.equals("")) {
                        c2 = "Please enter a word";
                    } else {
                        c2 = "Sorry, we don't have this word in our dictionary yet";
                    }
                }

            }
            req.setAttribute("c2", c2);
            req.setAttribute("c1", c1);
            req.setAttribute("u", u);
            req.getRequestDispatcher("UserTranslate.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ses = req.getSession();
        String c1 = "", c2 = "", vie1 = "", eng1 = "";
        Word w1 = new Word();
        Word w2 = new Word();
        int check = 1;
        if (ses.getAttribute("accountUser") != null) {
            resp.sendRedirect("UserTranslate.jsp");
            return;
        }

        try {
            vie1 = req.getParameter("vie1");
            eng1 = req.getParameter("eng1");

            if (req.getParameter("ok1") != null) {
                w1.translateVieToEng(vie1);

                if (w1.getEng() == null && !w1.getVie().equals("")) {
                    c1 = "Sorry, we don't have this word in our dictionary yet!";
                }

            }
            if (req.getParameter("ok2") != null) {
                w2.translateEngToVie(eng1);
                check = 2;
                if (w2.getVie() == null && !w2.getEng().equals("")) {
                    c2 = "Sorry, we don't have this word in our dictionary yet";

                }
            }
            
             if (req.getParameter("back") != null) {
                     resp.sendRedirect("index.jsp");
                     return;
                 }
            
        } catch (Exception e) {
            if (check == 1) {
                if (vie1.equals("")) {
                    c1 = "Please enter a word";
                } else {
                    c1 = "Sorry, we don't have this word in our dictionary yet";
                }
            }
            if (check == 2) {
                if (eng1.equals("")) {
                    c2 = "Please enter a word";
                } else {
                    c2 = "Sorry, we don't have this word in our dictionary yet";
                }
            }
        }
        req.setAttribute("c1", c1);
        req.setAttribute("c2", c2);
        req.setAttribute("w1", w1);
        req.setAttribute("w2", w2);

        req.getRequestDispatcher("Translate.jsp").forward(req, resp);

    }

}
