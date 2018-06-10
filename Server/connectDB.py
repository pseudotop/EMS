#!/usr/bin/python3
import mysql.connector
import json

class ConnectDB():
  def __init__(self, filename):
    self.filename = filename
  
  def connect(self):
    json_data = open(self.filename).read()
    print(json_data)
    data = json.loads(json_data)
    self.conn = mysql.connector.connect(**data)
    self.cursor = self.conn.cursor()

  def close(self):
    self.commit()
    self.cursor.close()
    self.conn.close()

  def commit(self):
    self.conn.commit()
