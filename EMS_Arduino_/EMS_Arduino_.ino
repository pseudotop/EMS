/*
 Main Program by Christopher Nafis
 http://www.seeedstudio.com/depot/grove-dust-sensor-p-1050.html
 http://www.sca-shinyei.com/pdf/PPD42NS.pdf

 Modification Program by SIMP TEAM
 http://www.simpteam.com
 http://www.youtube.com/c/simpteam
*/
#include <DHT11.h>
 
int pin = 8;  //먼지센서
int tempPin = 7;
DHT11 dht11(tempPin);
unsigned long duration;   //지속 시간
unsigned long starttime;  //시작 시간
unsigned long sampletime_ms =60000;   //30초 마다 업데이트
unsigned long lowpulseoccupancy = 0;   //Low 신호가 지속된 시간을 초기화
float ratio = 0;  //비율
float concentration = 0;  //입자 농도 0으로 초기화
float pcsPerCF = 0;  //한 입자당 CF를 0으로 초기화
float ugm3 = 0;  //최종 값으로 세제곱미터 당 마이크로 그램(㎍/㎥)
float temp = 0;  //온도
float humidity = 0; //습도

void setup() {
  Serial.begin(9600);  //시리얼 통신 시작
  pinMode(pin,INPUT);  //미세먼지 센서 입력

  starttime = millis();  //현재 시간 대입
  lowpulseoccupancy = 0;
}

void loop() {
  float temp,humi;
  int err;
  duration = pulseIn(pin, LOW); 
  lowpulseoccupancy = lowpulseoccupancy+duration;
   
  if ((millis()-starttime) >= sampletime_ms && (err=dht11.read(humi,temp))==0)  {   //만약 샘플 시간이 5초라면(위에서 정한 샘플 시간)
    ratio = lowpulseoccupancy/(sampletime_ms*10.0);  // 정수 백분율
    concentration = 1.1*pow(ratio,3)-3.8*pow(ratio,2)+520*ratio+0.62; // 미세먼지 센서 사양 시트 곡선 사용
    pcsPerCF = concentration * 100;  // 입자 농도에 100을 곱하면 입자당 CF값
    ugm3 = pcsPerCF / 13000;  //입자당 CF를 13000으로 나누면 미터세제곱당 마이크로그람의 미세먼지 측정값

    //String ugm3Str = "ugm3 = ";
    //String ugm3Value = String(ugm3);
    //String tempStr = " temp = ";
    //String tempValue = String(temp);
    //String humiStr = " humi = ";
    //String humiValue = String(humi);
    //String result = "";
    
    //ugm3Str.concat(ugm3Value);
    //tempStr.concat(tempValue);
    //humiStr.concat(humiValue);

    //ugm3Str.concat(tempStr);
    //ugm3Str.concat(humiStr);
    //Serial.println(ugm3Str);
    Serial.println(temp);
    Serial.println(humi);
    Serial.println(ugm3);
    lowpulseoccupancy = 0;
    starttime = millis();

  }
}


