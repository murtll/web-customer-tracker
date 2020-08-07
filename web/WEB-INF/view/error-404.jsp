<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error 404</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Customer Tracker</h2>
    </div>

    <div id="container">
        <div id="content">

            <h3>Error 404! No such page found!</h3>
            <br>
            <br>
            <p>
                <a href="${pageContext.request.contextPath}/customer/list">&#8592 Go to the main page</a>
            </p>
        </div>
    </div>
</div>

</body>
</html>
