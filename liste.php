<?php
$con=mysqli_connect("localhost","root","","domoenig");
$res=mysqli_query($con,"select * from capteurs order by date,heure desc");
$i=0;
while($r=mysqli_fetch_array($res,MYSQLI_NUM))
{
	$response[$i]["temp"]=$r[0];
		$response[$i]["hum"]=$r[1];
			$response[$i]["lum"]=$r[2];
			$response[$i]["date"]=$r[3];
			$response[$i]["heure"]=$r[4];
			$i=$i+1;
}
echo json_encode($response);
?>