#!/usr/bin/python3
import mysql.connector
import json

class ConnectDB:
  def __init__(self, filename):
    self.filename = filename
  
  def connect(self):
    json_data = open(self.filename).read()
    print(json_data)
    data = json.loads(json_data)
    self.conn = mysql.connector.connect(**data)

  def close(self):
    self.conn.close()
