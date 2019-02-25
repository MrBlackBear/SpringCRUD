<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>UPDATE CRUD</title>
</head>
<body>
<form:form action="/admin/update" modelAttribute="user" method="post" >
    <div>Name: ${user.name}</div>
    <div>Login: ${user.login}</div>
    <div>Password: ${user.password}</div>
    <table>
        <form:hidden path="id"></form:hidden>
        <form:hidden path="name"></form:hidden>
        <tr>
            <td>Login <form:input path="login"></form:input></td>
        </tr>
        <tr>
            <td>Password <form:input path="password"></form:input></td>
        </tr>
        <tr>
            <td>Role <select name="role">
                <option value="1">ROLE_ADMIN</option>
                <option value="2">ROLE_USER</option>
            </select></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Update"></td>
        </tr>
    </table>
</form:form>
<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>