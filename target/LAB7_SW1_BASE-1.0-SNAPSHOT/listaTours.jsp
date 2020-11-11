<%@ page import="Beans.Tour" %><%--
  Created by IntelliJ IDEA.
  User: jose_
  Date: 10/11/2020
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listTours" scope="request" type="java.util.ArrayList<Beans.Tour>"/>
<html>
<head>
    <jsp:include page="includes/bootstrapRepository.jsp"/>

    <jsp:include page="static/head.jsp">
        <jsp:param name="title" value="Lista de Tours"/>
    </jsp:include>

</head>
<body>
<jsp:include page="includes/navbar.jsp">
    <jsp:param name="page" value="tours"/>
</jsp:include>
<H1 style="color:white">Lista de Tours (*world*)</H1>
<table class="table">
    <tr>
        <th>ID</th>
        <th>TOUR</th>
        <th>BANDA</th>
    </tr>
    <%for(Tour tour: listTours){%>
        <tr>
            <td><%=tour.getId()%></td>
            <td><%=tour.getNombreTour()%></td>
            <td><%=tour.getBanda()%></td>
        </tr>
    <%}%>
</table>
</body>
</html>
