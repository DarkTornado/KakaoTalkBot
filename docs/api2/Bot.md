---
layout: default
title: Event
parent: API 2
---

# Bot
* BotManager 클래스를 통해 가지고온 Bot 인스턴스에서 사용할 수 있는 method들이에요.

```javascript
//올바른 예시
let bot = BotManager.getCurrentBot();
bot.addListener(Event.MESSAGE, (chat) => {
    //내용
});

//잘못된 예시
Bot.addListener(Event.MESSAGE, (chat) => {
    //내용
});
```

## void addListener(String eventName, Function listener);
* 이벤트 리스너를 등록해요.

## boolean canReply(String room\[, String packageName\]);
* 해당 방으로 채팅을 보낼 수 있는지 반환해요.
* `packageName` 생략시 가장 최근에 알림이 수신된 메신저 앱을 기준으로 작동해요.

## boolean compile();
* 현재 봇을 리로드(컴파일)시켜요.
* 성공시 `true`, 실패시 `false`를 반환해요.

## String getName();
* 현재 봇의 이름을 반환해요.

## boolean getPower();
* 현재 봇이 켜져있는지 반환해요.

## markAsRead(String room\[, String packageName\]);
* 해당 패키지명을 가진 메신저 앱의 해당 채팅방의 채팅을 읽음처리 해요.
* `packageName` 생략시 가장 최근에 알림이 수신된 메신저 앱을 기준으로 작동해요.

## void removeAllListener(String eventName, Function listener);
* 등록된 모든 이벤트 리스너를 삭제해요.

## void removeListener(String eventName, Function listener);
* 등록된 이벤트 리스너를 삭제해요.

## void setCommandPrefix(String prefix);
* 명령어의 시작 문자열을 설정해요.
* 수신된 채팅 내용이 `prefix`로 시작하면 `Event.COMMAND` 이벤트가 발생해요.

## void setPower(boolean isOn);
* 봇을 키거나 꺼요.

## boolean send(String room, String msg\[, String packageName\]);
* 해당 패키지명을 가진 메신저 앱의 해당 채팅방으로 채팅을 보내요.
* `packageName` 생략시 가장 최근에 알림이 수신된 메신저 앱을 기준으로 작동해요.