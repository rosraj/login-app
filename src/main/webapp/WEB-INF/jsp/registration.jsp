<html>

<head>
    <title>Web Application</title>
</head>
<div style="text-align: center;">
    <h1>Welcome to Registration Page</h1>

    <h2>Registration Details</h2>
    <form method="post">
        Name      : <input type="text" name="name"/><br><br>
        User Name : <input type="text" name="username"/><br><br>
        Password  : <input type="password" name="password"/><br><br>
        email     : <input type="text" name="email"/><br><br>
        <input type="submit"/>
    </form>
    <span style="color: red; ">${errorMessage} <a href="/login"> Login Page</a></span>
</div>
</body>
</html>