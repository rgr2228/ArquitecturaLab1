<%-- 
    Document   : profile
    Created on : 1/03/2018, 06:49:32 PM
    Author     : Personal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        
         <form action="EstudianteServlet?action=upload" method="post" enctype="multipart/form-data">
             <h1> <center> <font face="arial,sans-serif">Perfil</font> <center></h1>
             <table>
                <tr>
                    <td colspan="3"><img src="${estudiante.getFotoBase64()}" width="250" height="250"></td>
                </tr>
                <tr>
                    <td colspan="3"><input type="file" name="file" required=""></td>
                </tr>
                <tr>
                    <td>Nombre:${estudiante.name}</td>
                </tr>
                <tr>  
                    <td>Código: ${estudiante.id}</td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Actualizar foto"></td>
                </tr>   
            </table>
         </form>
                
         
    </body>
</html>
