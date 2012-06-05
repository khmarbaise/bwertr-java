<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>bwertr - welcome</title></head>
<body>
<h1>Welcome to bwertr @ SEACON 2012</h1>
<p>This presentation has already been rated <span id="numberOfRatings">${numberOfRatings}</span> times.</p>
<form action="/" method="POST">
    <label for="rating">Please choose:</label>
    <select id="rating" name="rating">
        <c:forEach items="${possibleRatings}" var="rating">
            <option value="${rating}">${rating}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Rate now!">
</form>
</body>
</html>