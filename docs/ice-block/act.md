---
layout: default
title: 동작 실행
parent: 일반 자동응답
---

# 동작 실행

블록 종류에서 `동작 실행`을 선택하시면 다음과 같은 창이 뜰거에요.

![]({{ site.imageurl }}ice-block/act/0.png)

현재 지원하고 있는 동작들은 다음과 같아요.

![]({{ site.imageurl }}ice-block/act/1.png)

다음은 `토스트다냥`이라는 토스트를 띄우는 예시로, 토스트 생성은 딱히 반환하는 값이 없음으로, `동작을 실행한 결과가 저장될 변수`는 생략랬어요.

![]({{ site.imageurl }}ice-block/act/2.png)

토스트 출력과는 달리 동작을 위해 값을 넘길 필요가 없는 경우는 다음과 같이 `토스트 내용` 등을 입력하는 텍스트 입력란이 사라져요.

![]({{ site.imageurl }}ice-block/act/3.png)


***

### 다음은 현재 시간을 가지고오는 예시에요.
일단, 현재 시간 중 `시` 부분이 저장될 변수(hour)를 만들고(변수의 이름이 꼭 사진과 같을 필요는 없어요),

![]({{ site.imageurl }}ice-block/act/4.png)

현재 시간 중 '분' 부분이 저장될 변수(min)를 만들어요.

![]({{ site.imageurl }}ice-block/act/5.png)

그리고, 변수 hour에 현재 시간 중 '시' 부분을 가지고오는 동작을 수행한 결과를 저장하고

![]({{ site.imageurl }}ice-block/act/6.png)

변수 min에는 현재 시간 중 '분' 부분을 가지고오는 동작을 수행한 결과를 저장한 뒤,

![]({{ site.imageurl }}ice-block/act/7.png)

각 변수들에 저장된 값을 다음과 같이 사용해요. `버전 5.0 beta`부터는 `${hour}`과 `${min}`로 해야 해요.

![]({{ site.imageurl }}ice-block/act/8.png)

이제 `동작 테스트`라는 채팅이 수신되면, 토스트 메시지와 함께 현재 시간을 출력하는 기능이 완성되었어요!

![]({{ site.imageurl }}ice-block/act/9.jpg)


실행 모습 : 
![]({{ site.imageurl }}ice-block/act/10.png)

