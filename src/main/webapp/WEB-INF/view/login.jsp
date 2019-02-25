<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login page</title>
</head>
<body>
<h4>Login Form</h4>

<c:if test="${param.error != null}">
    <div class="error">${error}</div>
</c:if>
<c:if test="${param.logout != null}">
    <div class="logout">${message}</div>
</c:if>

<form action="<c:url value='/login' />" method='POST'>
    <table>
        <tr>
            <td>Username:</td>
            <td><input type='text' name='name' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit"
                                   value="submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>