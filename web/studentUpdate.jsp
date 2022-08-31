<%-- 
    Document   : studentUpdate
    Created on : Aug. 31, 2022, 11:14:09 a.m.
    Author     : glyder319
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="WEB-INF/student.tld" prefix="mm" %>  
<%@page import="model.Student"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        Session:= ${sessionId}
            <mm:IfWeekDayTag> 
                <c:forEach var="student1" items="${x}" >
                    <tr>
                        <td>  ${student1.studentId} </td>
                        <td>   ${student1.studentName} </td>
                        <td>   ${student1.studentCity} </td>
                        <td>   ${student1.studentPhoneNumber} </td>
                        
                        <td>    <a href="<c:url value='/student?x=${student1.studentId}&act=delete'/>">delete</a>   </td>
                        <td>    <a href="<c:url value='/student?x=${student1.studentId}&act=update'/>">update</a>   <br> </td>
                        <%--<td>     <a href="<c:url value='/student?x=${student1.studentId}?act=update'/>">update</a>   <br> </td> --%> 
                    </tr>
                </c:forEach>
            </table>
            <br>
        </mm:IfWeekDayTag> 

        <a href="student.html" >new</a> <br>
        <a href="<c:url value='/logout'/>">logout</a>
    </body>
</html>
