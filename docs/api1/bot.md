---
layout: default
title: Bot
parent: Legacy API
---

# Bot
* 이 API는 `채팅 자동응답 봇`에만 있습니다.

### android.content.Content getContext();
* 봇 구동 서비스의 Context를 반환해요.

### String getJsVersion();
* 자바스크립트의 버전을 반환해요

### String getVersion();
* 채팅 자동응답 봇의 버전을 반환해요

### void off(String botName);
* 해당 이름을 가진 봇을 꺼요.

### void on(String botName);
* 해당 이름을 가진 봇을 켜요.

### boolean reload(String botName);
* `Api.reload();`와 동일

### void runOnUiThread(final String name, final Function func);
* 해당 봇의 UI 쓰레드에서 `func`를 실행해요.

### boolean send(String room, String msg, String packageName);
* `Api.replyRoom();`와 동일