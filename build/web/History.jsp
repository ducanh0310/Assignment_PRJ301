<%-- 
    Document   : History
    Created on : Mar 16, 2023, 8:34:53 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <table border="1">
            <tr>
                <td>No</td>
                <td>Vietnamese</td>
                <td>English</td>
                <td>Type</td>
                <td>Example</td>
            </tr>                                
            <c:forEach  items="${hist}" var="item">
                <tr>
                    <td>${item.getId()}</td>
                    <td>${item.getVie()}</td>
                    <td>${item.getEng()}</td>
                    <td>${item.getLoaitu()}</td>
                    <td>${item.getViduv()}<br>${item.getVidue()}</td>
                </tr>
            </c:forEach>
        </table>
        <form action="viewhis" method="post">
            <input type="submit" name="back" value="Back">
            <input type="submit" name="out" value="Log out">
        </form>
    </body>
</html>
