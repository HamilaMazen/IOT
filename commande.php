<?php
$n=$_POST["nom"];
$e=$_POST["etat"];
$con=mysqli_connect("localhost","root","","domoenig");
$res=mysqli_query($con,"update equipement set etat=$e where nom='$n'");
if($res==1)
{
	$response["flag"]="ok";
}
else
{
	$response["flag"]="no";
}
echo json_encode($response);
?>