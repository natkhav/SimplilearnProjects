<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Sporty Shoes</title>
    </head>
    <body>
    <div style="text-align: left">
        <h1>SPORTY SHOES MARKETPLACE</h1>      
        <h2>Login Page</h2><br><br>
        <h3>Admins</h3>
        <form action="admin" method="post">
            <label for="username">Username:</label>
            <input type="text" name="username"/>
            <br><br>
            <label for="password">Password:</label>
            <input type="password" name="password"/>
            <br><br>
            <button type="submit">Login</button><br>
        </form><br>
        
        <h3>Customers</h3>
        <form action="user" method="post">
            <label for="username">Username:</label>
            <input type="text" name="username"/>
            <br><br>
            <label for="password">Password:</label>
            <input type="password" name="password"/>
            <br><br>
            <button type="submit">Login</button>
        </form>
    </div>
    </body>
</html>