<%-- 
    Document   : Translate
    Created on : Mar 9, 2023, 5:05:32 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="translate" method="get">
            <%
                  Word w1 = new Word();          
                  if(request.getAttribute("w1") != null) {
                w1 = (Word)request.getAttribute("w1");
            }
           
                  Word w2 = new Word();          
                  if(request.getAttribute("w2") != null) {
                w2 = (Word)request.getAttribute("w2");
            }
           

                 String c1 = "";
                 if(request.getAttribute("c1") != null) {
                 c1 = (String)request.getAttribute("c1");
                 }
                 String c2 = "";
                 if(request.getAttribute("c2") != null) {
                 c2 = (String)request.getAttribute("c2");
                 }
            %>

            <table>
                <tr>           
                    <td>VIETNAMESE TO ENGLISH</td>
                </tr>
                <tr>
                    <c:if test = "${w1.getVie()!= null}">
                        <td><input type="text" name="vie1" value="<%=w1.getVie()%>"></td>
                        </c:if>

                    <c:if test = "${w1.getVie()== null}">
                        <td><input type="text" name="vie1" value=""></td>
                        </c:if>

                    <td><input type="submit" name="ok1" value="TRANSLATE"></td>

                    <c:if test = "${w1.getEng()!= null}">
                        <td><input type="text" name="eng2" readonly="" value="<%=w1.getEng()%>"></td>                            
                        </c:if>

                    <c:if test = "${w1.getEng()== null}">
                        <td><input type="text" name="eng2" readonly="" value=""></td>
                        </c:if>
                </tr>



                <c:if test = "${! empty  w1.getEng()}">
                    <td><%out.print(w1.getLoaitu() + "");%><br>
                        <%out.print("Ví dụ: " + w1.getViduv() + "");%><br>
                        <%out.print("Example: " + w1.getVidue() + "");%></td>                   
                    </c:if>    

                <td> <%out.print(c1);%></td>



                <tr>
                    <td><br></td>
                    <td><br></td>
                    <td><br></td>
                </tr>

                <tr>           
                    <td>ENGLISH TO VIETNAMESE</td>
                </tr>

                <tr>
                    <c:if test = "${w2.getEng()!= null}">
                        <td><input type="text" name="eng1"value="<%=w2.getEng()%>"></td>
                        </c:if>
                        <c:if test = "${w2.getEng()== null}">
                        <td><input type="text" name="eng1"value=""></td>
                        </c:if>

                    <td><input type="submit" name="ok2" value="TRANSLATE"></td>


                    <c:if test = "${w2.getVie()!= null}">
                        <td><input type="text" name="vie2" readonly="" value="<%=w2.getVie()%>"></td>
                        </c:if>
                        <c:if test = "${w2.getVie()== null}">
                        <td><input type="text" name="vie2" readonly="" value=""></td>
                        </c:if>
                </tr>    

                <c:if test = "${!empty w2.getVie() }">
                    <td><%out.print(w2.getLoaitu());%><br>
                        <%out.print("Ví dụ: " + w2.getViduv());%><br>
                        <%out.print("Example: " + w2.getVidue());%></td>                   
                    </c:if>
                <td> <%out.print(c2);%></td>
                <tr>
                    <td><br></td>
                    <td><br></td>
                    <td><br></td>
                </tr>
                
               
                
                <tr>
                    <td><input type="submit" name="back" value="BACK"></td>
                    <td><br></td>
                    <td><br></td>
                </tr>
         </table>
        </form>
    </body>
</html>
