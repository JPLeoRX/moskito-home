<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>MoSKito Home - Register</title>
</head>
<body>
    <form:form id="regForm" modelAttribute="user" action="registerProcess" method="post">
        <table align="center">
            <tr>
                <td><form:label path="username">Username</form:label></td>
                <td><form:input path="username" name="username" id="username" /></td>
            </tr>

            <tr>
                <td><form:label path="password">Password</form:label></td>
                <td><form:password path="password" name="password" id="password" /></td>
            </tr>

            <tr>
                <td></td>
                <td><form:button id="register" name="register">Register</form:button></td>
            </tr>

            <tr></tr>

            <tr>
                <td></td>
                <td><a href="../home.jsp">Home</a></td>
            </tr>
        </table>
    </form:form>
</body>
</html>