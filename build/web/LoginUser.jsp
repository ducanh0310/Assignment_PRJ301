<%-- 
    Document   : LoginUser
    Created on : Mar 9, 2023, 4:47:28 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="get">
             <%            
             String c = "";          
                 if(request.getAttribute("c") != null) {
               c = (String)request.getAttribute("c");
           }
    %>
            <table>
                <tr>
                    <td>Account: </td>
                    <td><input type="text" name="acc"></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="text" name="pass"></td>
                </tr>
                <tr>
                    <td> </td>
                    <td><input type="submit" name="ok" value="LOGIN">
                    <input type="submit" name="back" value="BACK"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>Do you have any account?<a href="Register.jsp">Register</a></td>
                </tr>
                
                <tr>
                    <td> </td>
                    <td><%out.print(c);%></td>
                </tr>
            </table>
        </form>
    </body>
</html>
