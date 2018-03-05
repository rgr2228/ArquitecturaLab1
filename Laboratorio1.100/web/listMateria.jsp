
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
        <h1>Lista de Materias</h1>
        
        <c:forEach var="a" items="${materias}">
            
           |${a.code}| |${a.name}| |${a.credits}| |${a.horary}| |${a.capacity}|
           <a onclick="return confirm('Esta seguro?')" href="EstudianteServlet?action=enrollment&id=${a.code}">Aceptar</a>
           <hr/>
        </c:forEach>        
        
    </body>
</html>


