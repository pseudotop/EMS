#!/usr/bin/python3
import json
import requests

class Rest:

  def __init__(self):
    self.token = "G4YYFBaplc540lRgRulVszjROVxZr6ZYJG4R05u8k086hT98X2P5ntEinw343pvG51mCxITovYTsE2QA%2Bydrdg%3D%3D"
    # gangnam-gu
    self.station = "%EA%B0%95%EB%82%A8%EA%B5%AC"
    self.url = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?serviceKey=" + self.token + "&numOfRows=1&pageSize=1&pageNo=1&startPage=1&stationName=" + self.station +"&dataTerm=DAILY&ver=1.3&_returnType=json"
    self.rd = None

  def get(self):
    self.rd = requests.get(self.url)
  
  def getItem(self):
    if self.rd == None:
      self.get()
    print(self.rd)
    item = json.loads(self.rd.text)
    return item

if __name__ == '__main__':
  rest = Rest()
  try:
    item = rest.getItem()
    print(json.dumps(item, indent=4))
    print(item["list"][0]["pm10Value"])
  except:
    print("failed")
