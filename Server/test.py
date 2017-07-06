import serial
import time

ser = serial.Serial(
 port='/dev/ttyAMA0',
 baudrate=9600,
 parity=serial.PARITY_NONE,
 stopbits=serial.STOPBITS_ONE,
 bytesize=serial.EIGHTBITS,
 timeout=1)

try:
  while 1:
    response = ser.readline()
    print(response)
except KeyboardInterrupt:
  ser.close()
  
