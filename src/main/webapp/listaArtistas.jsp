<%@ page import="Beans.TourCiudad" %>
<%@ page import="Beans.Cancion" %>
<%@ page import="Beans.Artista" %><%--
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
<jsp:useBean id="listArtistas" scope="request" type="java.util.ArrayList<Beans.Artista>"/>
<jsp:useBean id="order" scope="request" type="java.lang.String"/>
<html>
<head>
    <jsp:include page="includes/bootstrapRepository.jsp"/>

    <jsp:include page="static/head.jsp">
        <jsp:param name="title" value="Lista de Artistas"/>
    </jsp:include>

</head>
<body>
<jsp:include page="includes/navbar.jsp">
    <jsp:param name="page" value="artistas"/>
</jsp:include>
<%if(order==null){%>
<H1 style="color:white">Lista de Canciones</H1>
<%}else{%>
<H1 style="color:white">Lista de Canciones Filtrada</H1>
<%}%>

<a class="btn btn-warning" href="<%=request.getContextPath()+"/listaCanciones?filter=on"%>">Ordenar por nombre de cancion</a>
<table class="table">
    <tr>
        <th>ID</th>
        <th>CANCION</th>
        <th>BANDA</th>
    </tr>

    <%String class_name = "";
        for(Artista artista: listArtistas){
            switch (artista.getIdinstrumento()){
                case "GUI":
                    class_name = "fila-red";
                    break;
                case "BSS":
                    class_name = "fila-purple";
                    break;
                case "DRM":
                    class_name = "fila-blue";
                    break;
                case "VOC":
                    class_name = "fila-yellow";
                    break;

            }%>

        <tr class="<%=class_name%>">
            <td><%=artista.getIdArtista()%></td>
            <td><%=artista.getNombre_artista()%></td>
            <td><%=artista.getIdbanda()%></td>
            <td><%=artista.getIdinstrumento()%></td>
        </tr>
    <%
        }%>
</table>
</body>
</html>
