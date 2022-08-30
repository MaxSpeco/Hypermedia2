<%-- 
    Document   : welcome
    Created on : Aug 19, 2020, 12:52:42 AM
    Author     : User
--%>

<%@page import="model.Student"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servlet Welcome Servlet</title>
    </head>
    <body>

        <%
            List<Student> listPersons = (List<Student>) request.getAttribute("listPers");

            for (Student p : listPersons) {
                System.out.println("name" + p.getStudentName());
            }

        %>
        <% for (Student p : listPersons) {%>           

    <%=p.getStudentName()%>;   <br>


        <%}%>

        <a href="student.html" >new</a>


    </body>
</html>
