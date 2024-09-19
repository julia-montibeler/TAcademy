<%@ page import= "java.util.ArrayList"%>

<%
    ArrayList<String> cantores = new ArrayList<>();

    cantores.add("Joelma");
    cantores.add("DIO");
    cantores.add("Trevo Scort");
    cantores.add("Joelma");
    cantores.add("Joelma");
%>

<html>
<%@ include file="header.jsp"%>
<body>
<h2>Hello World!</h2>
<ul>
    <%
        for(String cantor: cantores) {
            out.println("<li>"+cantor+"</li>");
        }
    %>

    <p>Mensagem da Servlet: <%=request.getAttribute("mensagem")%>

</ul>
</body>
</html>
