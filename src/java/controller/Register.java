/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acc = "", pass = "", repass = "", name = "", gender = "", dob = "", address = "";

        if (req.getParameter("create") != null) {
            try {
                acc = req.getParameter("acc");
                pass = req.getParameter("pass");
                repass = req.getParameter("repass");
                name = req.getParameter("name");
                gender = "Male";
                if (req.getParameter("gender").equals("0")) {
                    gender = "Female";
                }
                dob = req.getParameter("dob");
                address = req.getParameter("address");
                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
//                dob1 = Date.valueOf(dob);

                if (acc.equals("") || pass.equals("") || repass.equals("") || name.equals("") || gender.equals("") || dob.equals("") || address.equals("")) {
                    throw new Exception();
                }

            } catch (Exception e) {
                resp.setContentType("text/html;charset=UTF-8");
                try ( PrintWriter out = resp.getWriter()) {
                    out.print("vui long dien du ttin");
                    return;
                }
            }

            User u = new User(acc, "");
            if (u.check()) {
                resp.setContentType("text/html;charset=UTF-8");
                try ( PrintWriter out = resp.getWriter()) {
                    out.print("da co acc");
                    return;
                }
            }

            if (!pass.equals(repass)) {
                resp.setContentType("text/html;charset=UTF-8");
                try ( PrintWriter out = resp.getWriter()) {
                    out.print("mat khau khong khop");
                    return;
                }
            }
            LocalDate dob1 = LocalDate.parse(dob);
            if (dob1.compareTo(java.time.LocalDate.now()) >= 0) {
                resp.setContentType("text/html;charset=UTF-8");
                try ( PrintWriter out = resp.getWriter()) {
                    out.print("nhap sai ngay sinh");
                    return;
                }
            }
            u.setPass(pass);
            u.setName(name);
            u.setGender(gender);
            u.setDob(dob);
            u.setAddress(address);
            u.register();
            HttpSession session = req.getSession();
            session.setAttribute("accountUser", u);
            req.getRequestDispatcher("UserScreen.jsp").forward(req, resp);
//            ArrayList<User> data = u.getListUser();
//            req.setAttribute("data", data);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

}
