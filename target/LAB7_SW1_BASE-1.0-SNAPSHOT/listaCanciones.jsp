<%@ page import="Beans.TourCiudad" %>
<%@ page import="Beans.Cancion" %><%--
  Created by IntelliJ IDEA.
  User: jose_
  Date: 10/11/2020
  Time: 20:09
  To change this template use File | Settings | File Templates.
<%@ page import="Beans.Tour" %><%--
  Created by IntelliJ IDEA.
  User: jose_
  Date: 10/11/2020
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listCanciones" scope="request" type="java.util.ArrayList<Beans.Cancion>"/>
<html>
<head>
    <jsp:include page="includes/bootstrapRepository.jsp"/>

    <jsp:include page="static/head.jsp">
        <jsp:param name="title" value="Lista de Canciones"/>
    </jsp:include>

</head>
<body>
<jsp:include page="includes/navbar.jsp">
    <jsp:param name="page" value="canciones"/>
</jsp:include>
<H1 style="color:white">Lista de Canciones</H1>
<a class="btn btn-warning" href="<%=request.getContextPath()+"/listaCanciones?order=on"%>">Ordenar por nombre de cancion</a>
<table class="table">
    <tr>
        <th>ID</th>
        <th>CANCION</th>
        <th>BANDA</th>
    </tr>
    <%int for(Cancion cancion: listCanciones){%>
    <tr>
        <td><%=cancion.getIdCancion()%></td>
        <td><%=cancion.getNombreCancion()%></td>
        <td><%=cancion.getBanda()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
