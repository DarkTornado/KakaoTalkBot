---
layout: default
title: 변수
parent: 일반 자동응답
nav_order: 3
---

# 변수

`어떠한 또는 특정한 값을 저장할 수 있는 공간`을 변수라고 해요.

## 변수 생성

블록 종류에서 `변수 생성`을 선택하면 다음과 같은 창이 떠요.

![]({{ site.imageurl }}ice-block/var/0.png)

텍스트 입력란에 생성할 변수의 이름을 적으시면 되고,

![]({{ site.imageurl }}ice-block/var/1.png)

확인 버튼을 누르면 다음과 같이 블록이 추가될거에요.

![]({{ site.imageurl }}ice-block/var/2.png)

`변수 생성`을 통해 생성된 변수는 지역변수이기 때문에, 채팅 처리가 끝나면 자동으로 사라져요.


## 변수 값 설정 및 변경

블록 종류에서 '변수 생성'을 선택하시면 다음과 같은 창이 떠요.

![]({{ site.imageurl }}ice-block/var/3.png){: width="48%"}
![]({{ site.imageurl }}ice-block/var/4.png){: width="48%"}

|종류|설명|
|:--:|:--:|
|값 설정|변수에 저장된 값을 입력한 값으로 설정|
|값 증가|변수에 저장된 값을 입력한 값만큼 증가. 변수에 숫자만 저장되어 있어야 정상적으로 작동|
|값 감소|변수에 저장된 값을 입력한 값만큼 감소. 변수에 숫자만 저장되어 있어야 정상적으로 작동|
|다른 변수의 값으로 설정|변수에 저장된 값을 입력한 변수에 저장된 값으로 설정|

다음은 변수 a의 값을 5로 설정하는 예시이고,

![]({{ site.imageurl }}ice-block/var/5.png)

`확인` 버튼을 누르면 다음과 같이 블록이 추가될거에요.

![]({{ site.imageurl }}ice-block/var/6.png)

변수에 저장된 값은 채팅 자동응답 봇 5.0부터는 `${변수이름}`으로, 5.0 미만에서는 `[[변수이름]]`으로 가지고올 수 있어요.

![]({{ site.imageurl }}ice-block/var/7.png)

## 작동 모습

![]({{ site.imageurl }}ice-block/var/8.png)
