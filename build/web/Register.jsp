<%-- 
    Document   : Register.jsp
    Created on : Mar 7, 2023, 10:45:15 AM
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
        <form action="register" method="post">
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
                    <td>Re-Password: </td>
                    <td><input type="text" name="repass"></td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Gender: </td>
                    <td><input type="radio" name="gender" value="1">Male
                    <input type="radio" name="gender" value="0">Female</td>
                </tr>
                <tr>
                    <td>Birthdate: </td>
                    <td><input type="date" name="dob"></td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td><input type="text" name="address"></td>
                </tr>
                <tr>
                    <td> </td>
                    <td><input type="submit" name="create" value="Create"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
