<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/css/style.css">
        <meta charset="ISO-8859-1">
        <title>Dashboard</title>
    </head>
    <body>
        <div style="text-align: left">
            <h1>SPORTY SHOES MARKETPLACE</h1>
        	<h2>Customer Portal</h2><br><br>
            <h2>Welcome, ${user.login.username}!</h2>
            <br>
            <a href="/cart" class="button">Shop</a>
            <br/>
            <a href="/purchases?userId=${user.id}" class="button">View Purchase History</a>
            <br/>
            <a href="/" class="button">Logout</a>
            <br/>
        </div>
    </body>
</html>