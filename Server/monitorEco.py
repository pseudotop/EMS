#!/usr/bin/python3
import connectDB

conn = connectDB.ConnectDB("config.json")
conn.connect()

cursor = conn.cursor()
add_row = ("INSERT INTO classeco "
          "(temperature, humidity, innerdust, outerdust, reg_time) "
          "VALUES (%s, %s, %s, %s, %s)")
data_row = ()


conn.close()
