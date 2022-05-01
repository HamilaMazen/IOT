<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Contiki</title>
</head>
<body onload="load()" bgcolor="white">
<table border="0" cellpadding="4" cellspacing="4"><tbody><tr><td align="right" valign="top">
<h1>Contiki&nbsp;</h1>
<a href="http://172.16.104.229/">Front page</a><br>
<a href="http://172.16.104.229/neighbors.shtml">Neighbors</a><br>
<a href="http://172.16.104.229/sensors.shtml">Sensors</a><br>
</td><td align="left" valign="top">
<script type="text/javascript">
var start,d=document;i=new Image(50,60);i.src="spin.gif";function load(){var img=d.getElementById("spin");img.innerHTML='&nbsp;';loadData()}function loadData(){var r;try{r=new XMLHttpRequest()}catch(e){try{r=new ActiveXObject("Msxml2.XMLHTTP")}catch(e){try{r=new ActiveXObject("Microsoft.XMLHTTP")}catch(e){alert("Your browser does not support AJAX!");return false}}}r.onreadystatechange=function(){if(r.readyState==1){var img=d.getElementById("spin");img.innerHTML='<img src="spin.gif">'}if(r.readyState==4){var img=d.getElementById("spin");img.innerHTML='took '+((new Date()).getTime()-start.getTime())/1000+' seconds';eval(r.responseText)}};start=new Date();r.open("GET","/sensordata.shtml",true);r.send(null)}function e(el){if(d.getElementById){return d.getElementById(el)}if(d.all){return d.all[el]}}function s(el,n,max,text){e(el).innerHTML='<table width=504 border=0 cellpadding=1 cellspacing=0><tr><td width=200>'+text+'</td><td width='+(300*n/max)+' bgcolor="gray">&nbsp;</td><td width='+(300-300*n/max)+' bgcolor="lightgray">&nbsp;</td></table>'}function dc(n,d){return n.toFixed(d)}function t(m){n=dc(-39.6+0.01*m,1);s('temp',n,40,'Temperature '+n+' &deg;C')}function h(m){n=dc(-4+0.0405*m-2.8e-6*(m*m),2);s('hum',n,100,'Humidity '+n+'%')}function l1(m){n=dc(.7629394375*m,0);s('l1',n,200,'Light 1 '+n)}function l2(m){n=dc(.4693603*m,0);s('l2',n,200,'Light 2 '+n)}function rs(m){n=m+45;s('rs',n,100,'RSSI '+n)}function p(c,l,t,r){tm=c+l;cp=c*1.8/tm;lp=l*0.0545/tm;lt=t*17.7/tm;lr=r*20/tm;n=cp+lp+lt+lr;s('p',n,30,'Power consumption '+dc(n,2)+' mW');s('pc',cp,30,'CPU power '+dc(cp,2)+' mW');s('pl',lp,30,'LPM power '+dc(lp,2)+' mW');s('pr',lr,30,'Radio RX power '+dc(lr,2)+' mW');s('pt',lt,30,'Radio TX power '+dc(lt,2)+' mW')}function i(n){e('i').innerHTML=n}
</script>
<h1>Node
104.229</h1>
<a onclick="loadData();" href="#">Reload</a>
<span id="spin">took 0.788 seconds</span>
<h2>Environment</h2>
<div id="temp"><table border="0" cellpadding="1" cellspacing="0" width="504"><tbody><tr><td width="200">Temperature <?php echo rand(14,33); ?> °C</td><td bgcolor="gray" width="135">&nbsp;</td><td bgcolor="lightgray" width="165">&nbsp;</td></tr></tbody></table></div>
<div id="hum"><table border="0" cellpadding="1" cellspacing="0" width="504"><tbody><tr><td width="200">Humidity<?php echo rand(20,99); ?>%</td><td bgcolor="gray" width="220.2">&nbsp;</td><td bgcolor="lightgray" width="79.80000000000001">&nbsp;</td></tr></tbody></table></div>
<h2>Light</h2>
<div id="l1"><table border="0" cellpadding="1" cellspacing="0" width="504"><tbody><tr><td width="200">light 1 <?php echo rand(10,99); ?>lux</td><td bgcolor="gray" width="90">&nbsp;</td><td bgcolor="lightgray" width="210">&nbsp;</td></tr></tbody></table></div>
<div id="l2"><table border="0" cellpadding="1" cellspacing="0" width="504"><tbody><tr><td width="200">Niveau <?php echo rand(10,99); ?></td><td bgcolor="gray" width="90.2">&nbsp;</td><td bgcolor="lightgray" width="210">&nbsp;</td></tr></tbody></table></div>
<h2>Power</h2>
<div id="p"><table border="0" cellpadding="1" cellspacing="0" width="504"><tbody><tr><td width="200">Power consumption 1.43 mW</td><td bgcolor="gray" width="14.253939803819668">&nbsp;</td><td bgcolor="lightgray" width="285.74606019618034">&nbsp;</td></tr></tbody></table></div>
<div id="pc"><table border="0" cellpadding="1" cellspacing="0" width="504"><tbody><tr><td width="200">CPU power 0.15 mW</td><td bgcolor="gray" width="1.4763350016219978">&nbsp;</td><td bgcolor="lightgray" width="298.523664998378">&nbsp;</td></tr></tbody></table></div>
<div id="pl"><table border="0" cellpadding="1" cellspacing="0" width="504"><tbody><tr><td width="200">LPM power 0.05 mW</td><td bgcolor="gray" width="0.500299856895334">&nbsp;</td><td bgcolor="lightgray" width="299.4997001431047">&nbsp;</td></tr></tbody></table></div>
<div id="pr"><table border="0" cellpadding="1" cellspacing="0" width="504"><tbody><tr><td width="200">Radio RX power 1.22 mW</td><td bgcolor="gray" width="12.232291746907627">&nbsp;</td><td bgcolor="lightgray" width="287.7677082530924">&nbsp;</td></tr></tbody></table></div>
<div id="pt"><table border="0" cellpadding="1" cellspacing="0" width="504"><tbody><tr><td width="200">Radio TX power 0.00 mW</td><td bgcolor="gray" width="0.04501319839471066">&nbsp;</td><td bgcolor="lightgray" width="299.9549868016053">&nbsp;</td></tr></tbody></table></div>
<br><br>
<div id="i">0</div>
</td></tr></tbody></table>


</body></html>