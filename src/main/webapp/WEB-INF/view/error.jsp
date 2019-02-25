<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>ERROR</title>
</head>
<body>
<H1>ERROR HAS NO AYTHORITY TO ENTER</H1>
<form:form method="GET" action="/user">
    <input type="submit" value="GO TO USER PAGE"/>
</form:form>
</body>
</html>