<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/css/style.css">
    <title>Edit Category</title>
</head>
<body>
<div align="left">
        <h1>SPORTY SHOES MARKETPLACE</h1>
        <h2>Admin Portal</h2><br><br>
        <h3>Edit Shoes Category</h3>
    <form action="/save_category" method="post">
        <table border="0" cellpadding="5" class="tg" style="margin-right:auto;margin-left:0px">
            <tr>
                <input type="hidden" id="id" name="id" value="${category.id}">
                <td class="tg-general">Name:</td>
                <td class="tg-general"><input type="text" id="name" name="name" value="${category.name}"></td>
            </tr>
            <tr align="center">
                <td colspan="2" class="tg-general">
                    <input type="submit" name="register" value="Save" class="previous">
                </td>
            </tr>
        </table>
    </form>
    <a href="/admin?id=<%=(Long)session.getAttribute("adminId")%>" class="previous">&laquo; Back to Admin Dashboard</a>
</div>
</body>
</html>