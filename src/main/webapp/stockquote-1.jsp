
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Stock Quote Entry</title>
</head>
<body>

    <!-- The mapping in the xml isn't working on Tomcat 9 -->
<!--    <form name="stockquery" >   -->
        <div>
            <table border="1">
                <tr>
                    <td>Stock symbol to search</td>
                    <td><input name="symbol" type="text"></td>
                </tr>
                <tr>
                    <td>From Date</td>
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
                <tr>
                    <td><a class="btn btn-default" method="get" href="/ExampleWebApp/servlets/RequestQuoteInfoExample">Quote</a></td>
                    <td><a class="btn btn-default" href="/ExampleWebApp/servlets/RequestWebQuoteInfoExample">WebQuote </a></td>
                </tr>
            </table>
        </div>

        <footer position="fixed" bottom="0">
            <hr>
            Version 0.78.3
        </footer>
   <!--   </form>  -->

</body>
</html>
