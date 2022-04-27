<?php
    //Import PHPMailer classes into the global namespace
    //These must be at the top of your script, not inside a function
    require_once 'C:\Users\91877\vendor\autoload.php';

    use PHPMailer\PHPMailer\PHPMailer;
    use PHPMailer\PHPMailer\Exception;
    use PHPMailer\PHPMailer\SMTP;

    require 'C:\Users\91877\vendor\phpmailer\phpmailer\src\PHPMailer.php';
    require 'C:\Users\91877\vendor\phpmailer\phpmailer\src\Exception.php';
    require 'C:\Users\91877\vendor\phpmailer\phpmailer\src\SMTP.php';
 
    echo $_POST["register"];
    echo isset($_POST["register"]);
    if (isset($_POST["register"]))
    {
        $name = $_POST["name"];
        $email = $_POST["email"];
        $password = $_POST["password"];
        echo $name;
        echo $email;
        echo $password;
        //Instantiation and passing `true` enables exceptions
        $mail = new PHPMailer(true);
 
        try {
            //Enable verbose debug output
            $mail->SMTPDebug = 0;//SMTP::DEBUG_SERVER;
 
            //Send using SMTP
            $mail->isSMTP();
 
            //Set the SMTP server to send through
            $mail->Host = 'smtp.gmail.com';
 
            //Enable SMTP authentication
            $mail->SMTPAuth = true;
 
            //SMTP username
            $mail->Username = 'youremail@gmail.com';
 
            //SMTP password
            $mail->Password = 'yourpassword';
 
            //Enable TLS encryption;
            $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;
 
            //TCP port to connect to, use 465 for `PHPMailer::ENCRYPTION_SMTPS` above
            $mail->Port = 587;
 
            //Recipients
            $mail->setFrom('youremail@gmail.com', 'yourname');
 
            //Add a recipient
            $mail->addAddress($email, $name);
 
            //Set email format to HTML
            $mail->isHTML(true);
 
            $verification_code = substr(number_format(time() * rand(), 0, '', ''), 0, 6);
 
            $mail->Subject = 'Email verification';
            $mail->Body    = '<p>Your verification code is: <b style="font-size: 30px;">' . $verification_code . '</b></p>';
 
            $mail->send();
            // echo 'Message has been sent';
 
            //$encrypted_password = password_hash($password, PASSWORD_DEFAULT);
 
            // connect with database
            $conn =  new mysqli("localhost","root","password","email");
            if (!$conn) {
              die("Connection failed: " . mysqli_connect_error());
            }
            // insert in users table
            $sql = "INSERT INTO users(name, email, password, verification_code, email_verified_at) VALUES ('" . $name . "', '" . $email . "', '" . $password . "', '" . $verification_code . "', NULL)";
            $conn->query($sql);
            
 
            header("Location: email-verification.php?email=" . $email);
            exit();
            $conn->close();
        } catch (Exception $e) {
            echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
        }
    }
    
?>