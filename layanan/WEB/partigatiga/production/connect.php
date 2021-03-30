<?php 
$connect =  new mysqli("localhost","root","","par33");

if(!$connect){
	die("Error".mysqli_connect_error());
}
?>	