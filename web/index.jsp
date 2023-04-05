<%-- 
    Document   : index
    Created on : Mar 21, 2023, 12:49:16 AM
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
        <h1>Welcome</h1>

        <%
               HttpSession ses = request.getSession();
           if (ses.getAttribute("accountAdmin") == null) {
        %>
        
        <a href="LoginAdmin.jsp">Login as admin</a><br>

        <%
            }
        %>

        <%
        if (ses.getAttribute("accountUser") == null) {
        %>

        <a href="LoginUser.jsp">Login as user</a><br>

        <%
            }
        %>
        
        <a href="Translate.jsp">Translate without login</a><br><!-- comment -->
          <%
        if (ses.getAttribute("accountUser") != null || ses.getAttribute("accountAdmin") != null) {
        %>
        
        <input type="submit" name="ok" value="Log out">
        
        <%
            }
        %>
    </body>
</html>
