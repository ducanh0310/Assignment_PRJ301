<%-- 
    Document   : UserScreen
    Created on : Mar 11, 2023, 2:27:21 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form action="user" method="post">

            <%
                   HttpSession ses = request.getSession();
               if (ses.getAttribute("accountUser") != null) {
               User u = (User)ses.getAttribute("accountUser");
               out.print("Welcome " + u.getName());
            %>
            
            
            
           <br> <input type="submit" name="translate" value="Translate"><br>
            <input type="submit" name="viewhis" value="View history"><br>
            <input type="submit" name="viewstar" value="View star"><br>
            <input type="submit" name="logout" value="Log out"><br>
            <%
          }
              else  {
                        out.print("Bạn chưa đăng nhập!");
            %>

            <br><a href="index.jsp">Home</a>
            <%
        }
            %>
        </form>

    </body>
</html>
