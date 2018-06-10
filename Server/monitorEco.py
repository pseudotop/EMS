#!/usr/bin/python3
import connectDB, requestAPI
import RPi.GPIO as GPIO
import time
import datetime
import requests
from DHT11 import dht11

# initialize time
now = prev = datetime.datetime.now()

# initialize REST API
rest = requestAPI.Rest()
pm10Value = 0

# initialize GPIO
GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)
GPIO.cleanup()

while True:
  now = datetime.datetime.now()

  # read data using pin 4
  instance = dht11.DHT11(pin=4)
  result = instance.read()
  if not result.is_valid():
    continue

  # get outer Dust data per an hour
  if (prev.hour!=now.hour or now==0):
    item = rest.getItem()
    if (now.strftime("%Y-%m-%d %H:%M:%S") is not item["list"][0]["dataTime"]):
      # rewind time
      now = now - datetime.timedelta(minutes=1)
    else:  
      pm10Value = item["list"][0]["pm10Value"]
      if (pm10Value == "-"):
        pm10Value = pm10Value.replace("-",0)
      
  # connect Database
  conn = connectDB.ConnectDB("config.json")
  conn.connect()

  # access Data
  cursor = conn.cursor
  add_row = ("INSERT INTO classEco "
            "(temperature, humidity, innerdust, outerdust, reg_time) "
            "VALUES (%s, %s, %s, %s, %s)")
  data_row = (result.temperature, result.humidity, 0, pm10Value, now.strftime('%Y-%m-%d %H:%M:%S'))
  
  cursor.execute(add_row, data_row)
  conn.commit()

  # destroy Resources
  conn.close()
  prev = now
  time.sleep(60)
