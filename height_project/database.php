<?php
$con = mysqli_connect("172.30.1.144","MS","123456","HEIGHT");

if(mysqli_connect_errno()){
    echo 'Failed to connect to MySQL: ' .mysqli_connect_error();
}