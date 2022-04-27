<?php
 
    if (isset($_POST["login"]))
    {
        $email=$_POST['email'];
        $password=$_POST['password'];
 
        // connect with database
        $conn =  new mysqli("localhost","root","password","email");
 
        // mark email as verified
        $sql = "SELECT * from users WHERE email = '" . $email . "' AND password = '" . $password . "'";
        $result  = $conn->query($sql);
        $user=$result->fetch_object();
        if ($result->num_rows == 0)
        {
            echo "<script>alert('Invalid Credentials');window.location.href='http://localhost/email_verify/index.php';</script>";

        }
        
        else if ($user->email_verified_at == null)
        {
            //die("Please verify your email <a href='email-verification.php?email=" . $email . "'>from here</a>");
            echo "<script>alert('Please Verify your email');window.location.href='http://localhost/email_verify/email-verification.php?email=" . $email . "';</script>";
        }
        else
        {
        header("Location: dashboard.php");
        }
        $conn->close();
        exit();
        
    }

?>