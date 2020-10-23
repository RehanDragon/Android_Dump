<?php


$con = mysqli_connect("localhost" , "root" , "" , "login_demo");


$name = $_GET['name'];

$pass = $_GET['pass'];

$res = mysqli_query($con , "select * from info where name = '$name' and pass  = '$pass'");


$count = mysqli_num_rows($res);
if($count == 1){
/*  

seperation like

C/images/image.png

*/


header("location:welcome.php");


}else{

header("location:index.php");







}


?>