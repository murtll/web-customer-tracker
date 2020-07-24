<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Customer Tracker</h2>
    </div>

    <div id="container">
        <div id="content">

            <input type="button" value="Add customer" onclick="window.location.href='add'; return false" class="add-button">

            <form action="${pageContext.request.contextPath}/customer/list">
                <input type="text" name="search" placeholder="Search" minlength=1>
                <input type="submit" value="Search" class="search-button">
                <a href="${pageContext.request.contextPath}/customer/list">Show all</a>
            </form>

            <table>
                <tr>
                   <th>First name</th>
                   <th>Last name</th>
                   <th>Email</th>
                   <th></th>
                </tr>

                <c:forEach var="customer" items="${customers}">

                    <c:url var="deleteUrl" value="/customer/delete">
                        <c:param name="id" value="${customer.id}"/>
                    </c:url>

                    <c:url var="sendEmailUrl" value="/customer/send-mail">
                        <c:param name="id" value="${customer.id}"/>
                    </c:url>

                    <tr>
                        <td> ${customer.firstName} </td>
                        <td> ${customer.lastName} </td>
                        <td> ${customer.email} </td>
                        <td>
                            <a href="${deleteUrl}" onclick="if (!(confirm('Are you sure you wanna delete this man?'))) return false">Delete</a>
                            |
                            <a href="${pageContext.request.contextPath}/customer/update?id=${customer.id}">Update</a>
                            |
                            <a href="${sendEmailUrl}">Send email</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>

</body>
</html>
