<%@ page import="Beans.TourCiudad" %><%--
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
<jsp:useBean id="listToursPorCiudad" scope="request" type="java.util.ArrayList<Beans.TourCiudad>"/>
<html>
<head>
    <jsp:include page="includes/bootstrapRepository.jsp"/>

    <jsp:include page="static/head.jsp">
        <jsp:param name="title" value="Lista de Tours por Ciudad"/>
    </jsp:include>
    <style>
        .tableHeader{
            color:#BBBBBB;
        }
        .tableRow{
            color:#FFFFFF;
        }
        .content{
            max-width: 70%;
            margin: auto;
            margin-top: 40px;
        }
    </style>

</head>
<body>
<jsp:include page="includes/navbar.jsp">
    <jsp:param name="page" value="tpc"/>
</jsp:include>
<div class="content">
    <H1 style="color:white">Lista de Tours por Ciudad</H1>
    <table class="table">
    <tr class="tableHeader">
        <th>#</th>
        <th>TOUR</th>
        <th>CIUDAD</th>
        <th>FECHA</th>
    </tr>
    <%int i =1;
        for(TourCiudad tourCiudad: listToursPorCiudad){%>
    <tr class="tableRow">
        <td><%=i%></td>
        <td><%=tourCiudad.getTourName()%></td>
        <td><%=tourCiudad.getCiudad()%></td>
        <td><%=tourCiudad.getFecha().toString()%></td>
    </tr>
    <%i++;
        }%>
</table>
</div>
</body>
</html>
