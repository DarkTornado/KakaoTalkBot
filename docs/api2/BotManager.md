---
layout: default
title: BotManager
parent: API 2
---

## boolean compile(String botName);
* 해당 봇을 리로드(컴파일)시켜요.
* 성공시 `true`, 실패시 `false`를 반환해요.

## Bot getBot(String botName);
* 해당 이름을 가진 봇의 `Bot 인스턴스`를 반환해요.

## Bot[] getBotList();
* 모든 봇들의 `Bot 인스턴스`들을 배열로 반환해요.

## Bot getCurrentBot();
* 현재 봇의 `Bot 인스턴스`를 반환해요.

## boolean getPower(String botName);
* 해당 봇이 켜져있는지 반환해요.

## String[] getRooms(\[String packageName\]);
* 해당 패키지명을 가진 메신저 앱에서 채팅 전송이 가능한 채팅방 목록을 반환해요.
* `packageName` 생략시 가장 최근에 알림이 수신된 메신저 앱을 기준으로 작동해요.

## void setPower(String botName, boolean isOn);
* 해당 봇을 키거나 꺼요.