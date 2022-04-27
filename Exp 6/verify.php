<?php
 
    if (isset($_POST["verify_email"]))
    {
        $email = $_POST["email"];
        $verification_code = $_POST["verification_code"];
 
        // connect with database
        $conn =  new mysqli("localhost","root","password","email");
 
        // mark email as verified
        $sql = "UPDATE users SET email_verified_at = NOW() WHERE email = '" . $email . "' AND verification_code = '" . $verification_code . "'";
        $result  = $conn->query($sql);
 
        if ($conn->affected_rows == 0)
        {
            
            echo "<script>alert('Verification Code Failed');window.location.href='http://localhost/email_verify/email-verification.php?email=" . $email . "';</script>";

        }
 
        echo "<script>alert('YOU can Login Now');window.location.href='http://localhost/email_verify/index.php';</script>";
        $conn->close();
        exit();
    }
 
?>