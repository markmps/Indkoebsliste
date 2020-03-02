<%--
  Created by IntelliJ IDEA.
  User: Marks
  Date: 02-03-2020
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Huskeliste</title>
</head>
<body>

${sessionScope.besked}

<h1>Du er klar til at tilføje emner til din indkøbskurv</h1>


<form action="AddItemServlet" method="post">
    <label for="fname">Skriv vare:</label><br>
    <input type="text" id="fname" name="vareNavn"><br>
    <input type="submit" value="Tilføj">
</form>

<br>
<br>
<br>

${requestScope.besked}

<br>
<br>

<c:forEach var="element" items="${sessionScope.basket}">

    ${element}
    <br>

</c:forEach>

<br>
<br>
<br>
<br>


<form action="LogOutServlet" method="post">
    <%--<label for="fname">Skriv vare:</label><br>
    <input type="text" id="fname" name="vareNavn"><br>--%>

    <input type="submit" value="LogOut">
</form>



</body>
</html>
