---
layout: default
title: 이벤트 리스너
parent: Legacy API
nav_order: 1
---

# 이벤트 리스너

* 어떠한 이벤트가 발생하면 호출되는 함수입니다.

## function response(String room, String msg, String sender, boolean isGroupChat, Replier replier, ImageDB imageDB, String packageName)
* 채팅이 수신되면 호출되는 이벤트 리스너

```javascript
function response(room, msg, sender, isGroupChat, replier, ImageDB, packageName) {
/*
 * room - 채팅이 수신된 채팅방의 방 이름. 1:1채팅방이라면 채팅을 보낸 사람의 닉네임
 * msg - 수신된 채팅 내용
 * sender - 채팅을 보낸 사람의 닉네임
 * isGroupChat - 단체채팅방이면 true, 1:1 채팅방이면 false
 * replier - 채팅방에 응답을 보낼 때 사용하는 객체
   - .reply(String msg); - 채팅이 수신된 채팅방으로 응답 전송 
   - .reply(String room, String msg); - 해당 채팅방으로 응답 전송 
   - .reply(String room, String msg, String packageName); - 해당 메신저 앱의 해당 채팅방으로 응답 전송
   - .replier.replyDelayed(String msg, long ms); - ms 밀리초 뒤에 채팅이 수신된 채팅방으로 응답 전송 
   - .replier.replyDelayed(String room, String msg, long ms); - ms 밀리초 뒤에 해당 채팅방으로 응답 전송 
   - .replier.markAsRead(); - 채팅이 수신된 채팅방에 응답을 보내지 않고 읽음으로 처리
   - .replier.markAsRead(String room); - 해당 채팅방에 응답을 보내지 않고 읽음으로 처리
   - .replier.markAsRead(String room, String packageName); - 해당 앱의 해당 채팅방에 응답을 보내지 않고 읽음으로 처리
 * imageDB - 이미지 정보가 담겨 있는 객체
   - .getProfileImage(); - 채팅을 보낸 사람의 프로필 사진을 Base64로 인코딩된 문자열로 가지고 옴
   - .getProfileImageBitmap(); - 채팅을 보낸 사람의 프로필 사진을 android.graphics.Bitmap 인스턴스로 가지고 옴
   - .getProfileBitmap(); - imageDB.getProfileImageBitmap();과 동일
   - .getProfileHash(); - 채팅을 보낸 사람의 프로필 사진을 Base64로 인코딩된 문자열에 java.lang.String.hashCode(); 메서드를 실행한 결과를 가지고 옴
   - .getImage(); - 사진이 수신된 경우, 해당 사진을 Base64로 인코딩된 문자열로 가지고 옴
   - .getImageBitmap(); - 사진이 수신된 경우, 해당 사진을 android.graphics.Bitmap 인스턴스로 가지고 옴
 * packageName - 채팅이 수신된 앱의 패키지명
 */
}
```

## function onStartCompile()
* 스크립트가 리로드되기 직전에 호출되는 이벤트 리스너

```javascript
function onStartCompile() {
/* 매개변수 없음 */
}
```

## function onLoaded(Context ctx)
* 리로드 버튼을 눌렀을 때, 스크립트 리로드가 끝나면 호출되는 이벤트 리스너

```javascript
function onLoaded(ctx) {
/*
 * ctx - 현재 액티비티의 android.content.Context
 */
}
```

## function secondTick()
* 1초마다 호출되는 이벤트 리스너

```javascript
function secondTick() {
/* 매개변수 없음 */
}
```

## function onNotificationPosted(StatusBarNotification sbn, SessionManager sm)
* 알림을 읽도록 설정한 앱에서 알림이 뜨면 호출되는 리스너

```javascript
function onNotificationPosted(sbn, sm) {
/*
 * sbn - NofiticationListenerService에 있는 onNotificationPosted의 매개변수로 넘어오는 StatusBarNotification 인스턴스
 * sm - 동적으로 세션을 등록할 수 있게 해주는 객체
   - .bindSession(String packageName, String room, Notification.Action action);
   - .bindSession(String room, Notification.Action action);
 */
}
```