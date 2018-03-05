<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty login}">
|<a href="login.jsp">Login</a>|

</c:if>
<c:if test="${not empty login}">
|<a href="EstudianteServlet?action=logout">Logout</a>|
|<a href="EstudianteServlet?action=list">Lista de Materias</a>|
|<a href="EstudianteServlet?action=listMatricula">Matricula</a>|
|<a href="EstudianteServlet?action=profile"><font face="arial,sans-serif">Perfil</font></a>|


</c:if>



|<a href="EstudianteServlet?action=about">About</a>|
<hr/>