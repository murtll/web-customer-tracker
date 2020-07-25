<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send Message</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Customer Tracker</h2>
    </div>
</div>

<div id="container">
    <h3>Send Message</h3>

    New message to ${customer.firstName} ${customer.lastName}, ${customer.email}<br>



    <form:form action="send-mail" modelAttribute="mailModel" method="POST">

        <form:hidden path="from"/>
        <form:hidden path="to"/>

        Subject: <form:input path="subject"/>
        <br>
        Message:
        <br>
        <br>
        <form:textarea path="text" rows="15" cols="100" />
        <br>
        <input type="submit" value="Send" class="save" />

    </form:form>

    <div style="clear; both;"></div>

    <p>
        <a href="${pageContext.request.contextPath}/customer/list">&#8592 Back to the list</a>
    </p>

</div>

</body>
</html>
