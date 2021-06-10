<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Persons</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h2>List of persons</h2>

        <table>
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>City</th>
            </tr>

            <c:forEach var="li" items="${persons}">
                <tr>
                    <td><c:out value="${li.firstName}" /></td>
                    <td><c:out value="${li.lastName}"/></td>
                    <td><c:out value="${li.address}"/></td>
                    <td><c:out value="${li.city}"/></td>
                </tr>
            </c:forEach>

            <form method="DELETE" action="/deletar/{alunoId}" >
                <label for="alunoId">Deletar Aluno</label>
                <input type="text" id="alunoId" >
                <input type="submit">
            </form>
        </table>
    </body>
</html>
