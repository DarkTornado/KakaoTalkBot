---
layout: default
title: Api
parent: Legacy API
---

# Api
* 이 API 증 일부는 `메신저봇`에도 있어요.

## boolean canReply(String room, String pack);
* 해당 채팅방으로 채팅을 보낼 수 있는지 반환해요. 

## boolean compile(String botName);
* `Api.reload();`와 동일

## void gc();
* 가비지 콜랙터를 강제로 실행해요.
* 사실 `java.lang.System.gc();` 호출이에요.

## android.content.Content getContext();
* 봇 구동 서비스의 Context를 반환해요.

## String getLastImage();
* 가장 최근에 수신된 것 같은 이미지를 `Base64 문자열`로 인코딩해서 가지고 와요.
* 옛날 방식을 사용하기 때문에, 안드로이드 10 이하에서만 작동해요.

## android.graphics.Bitmap getLastImageBitmap();
* 가장 최근에 수신된 것 같은 이미지를 `android.graphics.Bitmap` 인스턴스로 가지고 와요.
* 옛날 방식을 사용하기 때문에, 안드로이드 10 이하에서만 작동해요.

## String[] getRoomList(String packageName);
* 모든 방 목록(정확히는 응답 전송이 가능한 방 목록)을 불러와요.
* `packageName` 생략시 가장 최근에 알림이 수신된 메신저 앱을 기준으로 작동해요.

## String[] getScriptNames();
* 모든 봇 목록을 불러와요.

## boolean isOn(String botName);
* 해당 이름을 가진 봇이 켜졌는지 확인해요.

## void makeNoti(String title, String content, int id)
* 상단바에 제목이 `title`, 내용은 `content`인 알림을 띄워요.
* `id`가 같으면 덮어씌우는데, 10 이하인 id들은 앱 자체에서 사용하는 영역이니 10 이상으로 사용하는 것을 권장해요.

## boolean markAsRead(String room, String packageName);
* 해당 패키지명을 가진 메신저 앱의 해당 채팅방의 채팅을 읽음처리 해요.
* `packageName` 생략시 가장 최근에 알림이 수신된 메신저 앱을 기준으로 작동해요.

## void off(String botName);
* 해당 이름을 가진 봇을 꺼요.

## void on(String botName);
* 해당 이름을 가진 봇을 켜요.

## String papagoTranslate(String lang1, String lang2, String value);
* 파파고 번역.
* `value`의 언어를 `lang1`이라고 가정하고, `lang2` 언어로 번역해요.

## String papagoTranslate(String lang1, String lang2, String value, String id, String secret);
* 위와 동일하지만, 사용자가 발급받은 `Client Id`와 `Client Secret`를 사용할 수 있어요.

## int prepare(String botName);
* 해당 이름을 가진 봇이 리로드된 적이 없다면 리로드해요. 리로드 된 적이 없으면 2, 리로드 성공시 1, 리로드 실패시 0을 반환해요.

## boolean reload(String botName);
* 해당 이름을 가진 봇을 리로드해요.

## boolean replyRoom(String room, String msg, String pack);
* 이름이 `room`인 채팅방으로 `msg`를 보내요.
* `packageName` 생략시 가장 최근에 알림이 수신된 메신저 앱을 기준으로 작동해요.

## void showToast(String msg, int leng);
* `msg`를 토스트 메시지로 출력해요.

## void UIThread(Function func);
* UI 쓰레드에서 해당 함수를 실행해요

## boolean unload(String botName);
* 해당 이름을 가진 봇의 리로드를 풀어요.