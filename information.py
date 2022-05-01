import time
import MySQLdb
import datetime
import urllib

while (True):
	db=MySQLdb.connect("localhost","root","root","domoenig")
	cursor=db.cursor()
	date=datetime.datetime.now()
	ds=str(date.year) +"-"+str(date.month)+"-"+str(date.day)
	ts=str(date.hour)+":"+str(date.minute)+":"+str(date.second)
	url="http://localhost/capteur2.php"
	res=urllib.urlopen(url)
	r=res.read()
	#temperature
	ss=">Temperature"
	i= r.find(ss)
	txt="C<"
	j=r.find(txt)
	jj=j-2
	ii=i+13
	tr=r[ii : jj]
	

	#humidite
	hh=">Humidity"
	ih= r.find(hh)
	jh=r.find("%<")
	jjh=jh-1
	iih=ih+9
	trh=r[iih : jjh]
	

	#light
	ll=">light 1"
	il= r.find(ll)
	jl=r.find("lux")
	jjl=jl
	iil=il+8
	trl=r[iil : jjl]
	
	sql="insert into capteurs values (%s,%s,%s,%s,%s)"
	args=tr,trh,trl,ds,ts
	cursor.execute(sql,args)
	db.commit()

	
	
	db.close()

	time.sleep(6)
