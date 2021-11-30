<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h2>Please enter your person data</h2>
<br>
<form:form action="saveUser" modelAttribute="user">
    First name <form:input path="firstName"/>
    <form:errors path="firstName"/>
    <br><br>
    Last name <form:input path="lastName"/>
    <form:errors path="lastName"/>
    <br><br>
    Email <form:input path="email"/>
    <form:errors path="email"/>
    <br><br>
    Password <form:input path="password"/>
    <form:errors path="password"/>
    <br><br><br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
