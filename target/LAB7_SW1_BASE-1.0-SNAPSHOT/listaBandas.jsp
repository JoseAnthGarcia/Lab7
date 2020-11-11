<%@ page import="Beans.Banda" %><%--
  Created by IntelliJ IDEA.
  User: Lapadula
  Date: 10/11/2020
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="lista" type="java.util.ArrayList<Beans.Banda>" scope="request"/>
    <html>
    <head>
        <jsp:include page="includes/bootstrapRepository.jsp"/>

        <jsp:include page="static/head.jsp">
            <jsp:param name="title" value="Lista de Bandas"/>
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
    <H1 style="color:white">Lista de bandas</H1>
    <table class="table">
        <tr class="tableHeader">
            <th>#</th>
            <th>Banda</th>
            <th>ID Líder</th>
        </tr>
        <% for (Banda banda : lista) { %>
        <tr class="tableRow">
            <td><%=banda.getIdBanda()%>
            </td>
            <td><%=banda.getNombre_banda()%>
            </td>
            <td><%=banda.getIdlider()%>
            </td>
        </tr>
        <%} %>
    </table>
</div>
</body>
</html>