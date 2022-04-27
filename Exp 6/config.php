<?php

$host = "localhost"; /* Host name */
$user = "root"; /* User */
$password = "password"; /* Password */
$dbname = "email"; /* Database name */

$con = new mysqli($host, $user, $password,$dbname);
// Check connection
if (!$con) {
  die("Connection failed: " . mysqli_connect_error());
}
$sql = "SELECT * FROM users";
$result = $con->query($sql);
$row=$result->fetch_array(MYSQLI_NUM);
echo ($row[0]);
echo ($row[1]);
echo ($row[2]);
echo ($row[3]);
$sql1 = "INSERT INTO users(name, email, password, verification_code, email_verified_at) VALUES ('123', '1@12d.com', '12', '12', NULL)";
$con->query($sql1);
?>