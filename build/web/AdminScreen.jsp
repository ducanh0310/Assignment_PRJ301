<%-- 
    Document   : AdminScreen
    Created on : Mar 11, 2023, 2:50:03 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Word"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="newcss.css" />
    </head>
    <body>
        <form action="admin" method="get">
            <%
                HttpSession ses = request.getSession();
            if (ses.getAttribute("accountAdmin") != null) {
            
//            ArrayList<Word> data = new ArrayList<>();
//                if(request.getAttribute("data")!=null) {
//                    data = ArrayList<Word>(request.getAttribute("data"));
//                }
            %>
            
            <div class="a">
                
           
            <table border="1">
                <tr>
                    <td>Id</td>
                    <td>Vietnamese</td>
                    <td>English</td>
                    <td>Type</td>
                    <td>Example</td>
                </tr>                                
                <c:forEach  items="${data}" var="item">
                    <tr>
                        <td><a href="word?id=${item.getId()}&mod=1">${item.getId()}</a></td>
                        <td>${item.getVie()}</td>
                        <td>${item.getEng()}</td>
                        <td>${item.getLoaitu()}</td>
                        <td>${item.getViduv()}<br>${item.getVidue()}</td>
                        <td><a href="word?id=${item.getId()}&mod=2">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
                
                 </div>
            <a href="AddWord.jsp">Add new Word</a><br>
            
            <%
           }
               else  {
                         out.print("May khong phai la admin!");
            %>
            <br><a href="index.jsp">Home</a>
            <%
        }
            %>
        </form>
        
        
        
        
        <form action="admin"method="post">
            <%
            if (ses.getAttribute("accountAdmin") != null) {
            %>
            <input type="submit" name="logout" value="Logout">
              <%
        }
            %>
        </form>
    </body>
</html>
