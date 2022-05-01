import MySQLdb 
import time 
import RPi.GPIO as GPIO 
GPIO.setmode(GPIO.BCM) 
GPIO.setwarnings(False) 
while True : 	
	db=MySQLdb.connect("localhost","root","root","domoenig") 	
	cursor=db.cursor() 	
	lines=cursor.execute("""select * from equipement""") 	
	while True : 		
		l=cursor.fetchone() 		 		
		if l==None:break 		
		GPIO.setup(int(l[1]),GPIO.OUT) 		
		GPIO.output(int(l[1]), int(l[2])) 		
		print(int(l[2])) 	
	db.close() 
	time.sleep(1)