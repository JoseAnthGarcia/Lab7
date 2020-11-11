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
    <title>Title</title>
    <% for (Banda banda : lista) { %>
    <tr>
        <td><%=banda.getIdBanda()%>
        </td>
        <td><%=banda.getNombre_banda()%>
        </td>
        <td><%=banda.getIdlider()%>
        </td>
    </tr>
    <%} %>
</head>
<body>

</body>
</html>
