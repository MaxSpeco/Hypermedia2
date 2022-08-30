<%-- 
    Document   : login
    Created on : Aug 29, 2020, 11:59:31 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="LoginController" method="post">
            Enter username :<input type="text" name="username" value="admin"> <br>
            Enter password :<input type="password" name="password" value="admin"><br>
            <input type="submit" value="Login">
        </form>


        <div align = "center">
            <p>${param["message"]}</p>
        </div>
    </body>
</html>
