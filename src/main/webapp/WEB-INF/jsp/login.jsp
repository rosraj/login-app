<html>

<head>
    <title>Web Application</title>
</head>
<div style="text-align: center;">
    <h1>Welcome to Login Page</h1>

    <h2>Login To Proceed</h2>
    <form method="post">
        User Name : <input type="text" name="username"/><br><br>
        Password  : <input type="password" name="password"/><br><br>
        <input type="submit"/>
    </form>
    <span style="color: red; ">${errorMessage}</span>
</div>
</body>
</html>