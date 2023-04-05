<%-- 
    Document   : UpdateWord
    Created on : Mar 17, 2023, 11:02:46 AM
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
         <%
             HttpSession ses = request.getSession(); 
                  Word w = new Word();          
                  if(ses.getAttribute("wu") != null) {
                w = (Word)session.getAttribute("wu");
            }
            %>
            
            
        <form action="update" method="get">
            
            
          
            ID: <input type="text" name="id" value="<%=w.getId()%>" readonly=""><br>
            Vietnamese word: <input type="text" name="vie"  value="<%=w.getVie()%>" ><br>
            English word: <input type="text" name="eng" value="<%=w.getEng()%>" ><br>
            
            
            Type of word: <input type="checkbox" name="0" value="0">Danh từ(n) 
            <input type="checkbox" name="1" value="1" >Tính từ(n) 
            <input type="checkbox" name="2" value="2">Động từ(n) 
            <input type="checkbox" name="3" value="3">Trạng từ(n) 
            <input type="checkbox" name="4" value="4">Đại từ(p) 
            <input type="checkbox" name="5" value="5">Giới từ(n) 
            <input type="checkbox" name="6" value="6">Mạo từ(a)<br>
            
            Example for Vietnamese word: <input type="text" name="examv" value="<%=w.getViduv()%>" ><br>
            Example for English word: <input type="text" name="exame" value="<%=w.getVidue()%>" ><br>
            <input type="submit" name="add" value="Update"  > <br>
            <input type="submit" name="back" value="Back"  > <br>
        </form>
        
        
    </body>
</html>
