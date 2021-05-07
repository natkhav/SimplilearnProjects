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
        	<h2>Admin Portal</h2><br><br>
            <h3>Welcome, ${admin.login.username}!</h3>
            
            <br/>
            <a href="/categories" class="button">Shoes Categories</a> <a href="/new_category" class="button">Add New Category</a>          
            <br/>            
            <br/>
            <a href="/products" class="button">Shoes</a> <a href="/new_product" class="button">Add New Shoes</a>
            <br/>
            <br/>
            <a href="/users" class="button">Users</a> <a href="/purchase_report" class="button">Purchase Report</a>
            <br/>          
            <br/>
            <a href="/admin/edit?id=${admin.id}" class="button">Change Password</a> <a href="/" class="button">Logout</a>
            <br/>         
            <br/>
        </div>
    </body>
</html>