
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body{ font: 14px sans-serif;
            background-color: coral; }
        .wrapper{
             width: 50%; 
             padding: 40px;
             border: 5px solid black;
             margin-left:22%;
             margin-top:5%;
             margin-right:20%;
             background-color: white;
             border-radius: 10px;
             
         }
         h1{
             text-align:center;
             font-size:30px;
             margin:25px auto;
             display:block;
         }
         h2,p{
             padding-bottom:20px;
             text-align: center;
             font-size:20px;
         }
         .form-group{

             margin:5px;
             height:75px;
             box-sizing: border-box;
             border-radius: 2px;
         }
         label{font-weight: bold;
        font-size:20;
    padding:10px 0 0 10px;
    margin-left:5px;}
    input{font-weight: bold;
        font-size:20;
    padding:2px;
width:60%;
height:40px;
margin-top:10px;
margin-left:15px;
border-radius: 10px;}
.Submit-button
{   position: relative;
    left:15%;
    display:block;
    background-color: darkblue;
    color:white;
    padding:10px;
    font-size: 1em;
    cursor:pointer;
    border-radius: 10%;
}
a:focus{
    text-decoration: none;
}
    </style>
</head>
<body>

    <h1>ONLINE TEST</h1>
    <div class="wrapper">
        <h2>Login</h2>
        <form action="acceptuser.jsp" method="post">
            <div class="form-group">
                <label>Username</label>
                <input type="text" name="username" class="txt_uname" value="" placeholder="Username" required>
            </div>    
            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" class="txt_pwd" value="" placeholder="Password" required>
            </div>    
            <div class="Submit">
                <input type="submit" class="Submit-button" value="Submit"  name="but_submit" id="but_submit">
            </div>
            <p>Dont have an account? <a href="signup.html">Sign Up here</a>.</p>
        </form>
    </div>    
</body>
</html>