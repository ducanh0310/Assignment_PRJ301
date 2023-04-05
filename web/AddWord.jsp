<%-- 
    Document   : AddWord
    Created on : Mar 15, 2023, 4:09:19 PM
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
        <form action="word" method="post">
            Vietnamese word: <input type="text" name="vie"><br>
            English word: <input type="text" name="eng"><br>
            Type of word: <input type="checkbox" name="0" value="0">Danh từ(n) 
            <input type="checkbox" name="1" value="1">Tính từ(n) 
            <input type="checkbox" name="2" value="2">Động từ(n) 
            <input type="checkbox" name="3" value="3">Trạng từ(n) 
            <input type="checkbox" name="4" value="4">Đại từ(p) 
            <input type="checkbox" name="5" value="5">Giới từ(n) 
            <input type="checkbox" name="6" value="6">Mạo từ(a)<br>
            
            Example for Vietnamese word: <input type="text" name="examv"><br>
            Example for English word: <input type="text" name="exame"><br>
            <input type="submit" name="add" value="Add"> <br>
            <input type="submit" name="back" value="Back"> <br>
            <%
                String c = "";
                if(request.getAttribute("c")!=null) {
                    c = (String)request.getAttribute("c");
                    out.print(c);
                }
            %>
        </form>
    </body>
</html>
