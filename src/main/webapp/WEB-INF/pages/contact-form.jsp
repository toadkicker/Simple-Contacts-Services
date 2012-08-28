<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head><title>New Contact</title></head>
<body>

<h3>${message}</h3>

<form:form modelAttribute="contact" method="${actionMethod}" action="${actionName}">

    <table>
        <tr>
            <td><form:label path="firstName">First Name</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Last Name</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><form:label path="entityName">Entity Name</form:label></td>
            <td><form:input path="entityName"/></td>
        </tr>
        <tr>
            <td><form:label path="emailAddress">Email</form:label></td>
            <td><form:input path="emailAddress"/></td>
        </tr>
        <tr>
            <td><form:label path="areaCode">Area Code</form:label></td>
            <td><form:input path="areaCode"/></td>
        </tr>
        <tr>
            <td><form:label path="phoneNumber">Phone Number</form:label></td>
            <td><form:input path="phoneNumber"/></td>
        </tr>
        <tr>
            <td><form:label path="streetAddress1">Street Address Line 1</form:label></td>
            <td><form:input path="streetAddress1"/></td>
        </tr>
        <tr>
            <td><form:label path="streetAddress2">Street Address Line 2</form:label></td>
            <td><form:input path="streetAddress2"/></td>
        </tr>
        <tr>
            <td><form:label path="city">City</form:label></td>
            <td><form:input path="city"/></td>
        </tr>
        <tr>
            <td><form:label path="state">State</form:label></td>
            <td><form:input path="state"/></td>
        </tr>
        <tr>
            <td><form:label path="zipCode">Zip</form:label></td>
            <td><form:input path="zipCode"/></td>
        </tr>
        <tr>
            <td><form:label path="country">Country</form:label></td>
            <td><form:input path="country"/></td>
        </tr>
        <tr>
            <td><form:label path="notes">Notes</form:label></td>
            <td><form:textarea path="notes"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <form:hidden path="id"/>
                <input type="submit" value="${buttonMessage}"/>
            </td>
        </tr>
    </table>

</form:form>

</body>
</html>