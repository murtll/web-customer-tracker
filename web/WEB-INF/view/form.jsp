<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add customer</title>

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
    <h3>Save Customer</h3>

    <form:form action="save" modelAttribute="customer" method="POST">

        <form:hidden path="id"/>

        <table>
            <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td><form:input path="firstName" /> <form:errors path="firstName" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label>Last name:</label></td>
                <td><form:input path="lastName" /> <form:errors path="lastName" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label>Email:</label></td>
                <td><form:input path="email" /> <form:errors path="email" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save" /></td>
            </tr>

            </tbody>
        </table>


    </form:form>

    <div style="clear; both;"></div>

    <p>
        <a href="${pageContext.request.contextPath}/customer/list">&#8592 Back to the list</a>
    </p>

</div>

</body>
</html>
