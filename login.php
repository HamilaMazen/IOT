<?php
$l=$_POST["login"];
$p=$_POST["password"];
$con=mysqli_connect("localhost","root","","domoenig");
$res=mysqli_query($con,"select * from user where login='$l' and password='$p'");
if($r=mysqli_fetch_array($res,MYSQLI_NUM))
{
	$response["x"]=$r[1];
}
else
{
	$response["x"]="introuvable";
}
echo json_encode($response);
?>