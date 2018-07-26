<%--
  Created by IntelliJ IDEA.
  User: michaelbrooks
  Date: 7/20/18
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stock Price for -Insert symbol here-</title>
</head>
<body>
<jsp:useBean id="mybean" scope="session" class="com.origami.teach.model.Quotes" />
<jsp:setProperty name="mybean" property="symbol" />


<table border="1">
    <tr>
        <td>Results of the quote search</td>
        <td><jsp:getProperty name="mybean" property="symbol" /></td>

    </tr>
    <tr>
        <td><jsp:getProperty name="mybean" property="price" /></td>
        <td><jsp:getProperty name="mybean" property="time" /></td>
    </tr>
</table>
</body>
</html>
