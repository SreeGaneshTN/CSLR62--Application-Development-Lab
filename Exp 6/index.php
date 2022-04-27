<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' href='login.css' type='text/css' />
</head>

<body>
    <div class="wrapper">
        <h3>Welcome to Sree.GG</h3>
        <h3>Login</h3>
        <hr>
        <form method="post" action="signin.php">
            <div class="form-group">
                <input type="text" name="email" value="" class="form-control" placeholder="Email" size="12" />
            </div>
            <div class="form-group">
                <input type="password" name="password" value="" class="form-control" placeholder="Password" size="12" />
            </div>
            <div class="form-group">
                <input type="submit" class="btn-primary" name="login" value="login">
            </div>
        </form>
        <span>Don't Have an Account?? <a href="signup.php">Sign Up Here</a></span>
    </div>
</body>

</html>

