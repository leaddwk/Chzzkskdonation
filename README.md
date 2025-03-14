# Chzzkskdonation
마인크래프트에서 Skript로 치지직 도네를 가져와 확장성 높은 스크립팅을 할 수 있도록 만들어 봤습니다
[taromati](https://github.com/taromati)님의 [done-connector](https://github.com/taromati/done-connector)을 이용하여 치지직용으로 수정하였습니다
done-connector의 config.xml도 작동하기 때문에 필요하신대로 맞춰 쓰시면 됩니다
*훌륭하신 개발자 분들께 존경의 말씀을 드립니다*

## 설치 방법
paper로 서버를 열어줍니다
plugin 폴더에 Skript 2.10.2버전을 확인하시고 넣어줍니다
이 프로젝트의 플러그인을 받아서 plugin폴더에 넣어줍니다
한번 실행하고 나면 config.xml이 나옵니다
적절히 수정하시고 서버를 켜시면 됩니다

-서버를 켠 상태에서 config.xml만 다시 읽으려면 ```/done reload```를 입력하시면 됩니다

## 빌드
Java 21
Papermc(아무 버전이나 상관없으나 Skript플러그인의 버전을 맞춰야 합니다)
Skript 2.10.2

## 예제 코드(example.sk)
```
on chzzk donation:
    set {_tag} to chzzk donation tag
    set {_nickname} to chzzk donation nickname
    set {_amount} to chzzk donation amount
    set {_message} to chzzk donation message
    broadcast "[%{_tag}%] %{_nickname}%님이 %{_amount}%원 후원! > %{_message}%"
```

## 사용할 수 있는 것들
on chzzk donation:
-치지직 도네가 왔을때 실행합니다
chzzk donation tag
-config.xml에서 설정한 마크 닉네임입니다
chzzk donation nickname
-후원을 한 사람의 이름입니다("익명의 후원자"는 "익명"으로 표시됩니다)
chzzk donation amount
-치즈 값을 긇어옵니다
chzzk donation message
-도네 메세지를 긇어옵니다
