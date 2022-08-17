---
layout: default
title: API 종류
parent: API 개요
nav_order: 2
---

# API 종류
* 일단 채팅 자동응답 봇을 기준으로 설명할거에요.

## [레거시 API]({{ site.url }}{{ site.baseurl }}/docs/api1/api1)
* `function response() {}` 어쩌고를 사용하는 예전부터 있던 봇 API에요.
* 거의 대부분의 봇 구동 앱에서 지원하며, `채팅 자동응답 봇`과 `메신저봇`에서도 지원해요.
* 자바스크립트, 커피스크립트, 비쥬얼 베이직으로 봇을 만들 때 사용할 수 있어요.
* 채팅 자동응답 봇은 개발자가 이상한 사람이라 `레거시 API`와 `API 2`를 동시에 사용할 수 있어요.

## [API 2]({{ site.url }}{{ site.baseurl }}/docs/api2/api2)
* 봇 구동 앱 개발자들 사이에서 논의되던 표준안이에요.
* 현재 주로 사용되는 봇 구동 앱들 중에서는, `채팅 자동응답 봇`과 `메신저봇`이 지원하고 있어요.
* 자바스크립트로 봇을 만들 때 사용할 수 있어요.
* 채팅 자동응답 봇은 개발자가 이상한 사람이라 `레거시 API`와 `API 2`를 동시에 사용할 수 있어요.

## [SQL API]({{ site.url }}{{ site.baseurl }}/docs/sql-api)
* 데이터베이스와 관련된 것들을 다룰 수 있는 API로, SQLite로 구현되어 있어요.

## [Lua API]({{ site.url }}{{ site.baseurl }}/docs/lua-api/lua-api)
* 루아로 봇을 만들 때 지원하는 API 목록이 설명되어 있어요.

***

# API 종류 - 메신저봇 기준
* 원래, `레거시 API`와 `API 2`는 동시에 사용할 수 있는게 이상한거에요.
* 메신저봇에서는 봇을 추가할 때 둘 중 하나만 사용하도록 고를 수 있도록 되어있어요.

## 레거시 API에서만 사용 가능한 것
* Api
* Bridge
* DataBase
* Utils

## API2에서만 사용 가능한 것
* App
* Bot
* BotManager
* Broadcast
* Database
* Event
* Http
* Security

## 두 가지 모두에서 사용 가능한 것
* AppData
* Device
* FileStream
* GlobalLog
* Log

