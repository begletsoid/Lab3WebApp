<!DOCTYPE html>
<html lang="en">
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta charset="UTF-8">
    <title>Time</title>
</head>
<body>
<form action="/guestbook" method="post">
    <input type="text" name="name">
    <input type="submit" value="Enter name">
</form>
<c:forEach begin="0" end="${fn:length(namesArr) - 1}" var="index">
        <p><c:out value="${namesArr[index]}"/></p>
</c:forEach>
</body>
</html>