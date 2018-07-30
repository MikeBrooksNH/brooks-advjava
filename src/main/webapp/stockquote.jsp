<%--
  Created by IntelliJ IDEA.
  User: michaelbrooks
  Date: 7/21/18
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stock Quote Entry</title>
</head>
<body>

    <!-- The mapping in the xml isn't working on Tomcat 9 -->
    <form name="stockquery" action="/ExampleWebApp/servlets/RequestQuoteInfoExample" method="post">
        <table border="1">
            <tr>
                <td>Stock symbol to search</td>
                <td><input name="symbol" type="text"></td>
            </tr>
            <tr>
                <td>From Dateh</td>
                <td><input name="from" type="text"></td>
            <tr>
                <td>Until Date</td>
                <td><input name="until" type="text"></td>
            </tr>
            <tr>
                <!-- This doesn't seem to be getting passed along... -->
                <td>Frequency</td>
                <td><input type="checkbox" name="Daily"   title="Daily"/>Daily<br>
                    <input type="checkbox" name="Weekly"  title="Weekly"/>Weekly<br>
                    <input type="checkbox" name="Monthly" title="Monthly"/>Monthly<br>
                </td>
            </tr>
        </table>
        <input type="submit" value="Submit" name="submit" />
    </form>

</body>
</html>
