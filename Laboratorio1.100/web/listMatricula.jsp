
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1>Matricula</h1>
        
        <c:forEach var="a" items="${matriculadas}">
             <c:forEach var="ma" items="${a}">
                    |${ma.code}||${ma.name}||${ma.credits}||${ma.horary}| 
           </c:forEach>
           <hr/>
        </c:forEach>        
        
    </body>
</html>


