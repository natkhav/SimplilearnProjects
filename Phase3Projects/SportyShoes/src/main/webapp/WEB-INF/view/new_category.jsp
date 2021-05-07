<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/css/style.css">
        <title>New Category</title>
    </head>
    <body>
    <div align="left">
        <h1>SPORTY SHOES MARKETPLACE</h1>
        <h2>Admin Portal</h2><br><br>
        <h3>Add New Shoes Category</h3>
        <form action="save_category" method="post">
            <table border="0" cellpadding="5" class="tg" style="margin-right:auto;margin-left:0px">
                <tr>
                    <td class="tg-general">Name:</td>
                    <td class="tg-general"><input type="text" id="name" name="name"></td>
                </tr>
            </table>
            <input type="submit" name="register" value="Save" class="previous">
        </form><br>
        <a href="/admin?id=<%=(Long)session.getAttribute("adminId")%>" class="previous">&laquo; Back to Admin Dashboard</a>
    </div>
    </body>
</html>