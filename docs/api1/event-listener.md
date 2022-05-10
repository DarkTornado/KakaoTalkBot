---
layout: default
title: 이벤트 리스너
parent: Legacy API
nav_order: 1
---

# 이벤트 리스너

* 어떠한 이벤트가 발생하면 호출되는 함수에요.

## function response(String room, String msg, String sender, boolean isGroupChat, Replier replier, ImageDB imageDB, String packageName)
* 채팅이 수신되면 호출되는 이벤트 리스너

```javascript
function response(room, msg, sender, isGroupChat, replier, ImageDB, packageName, isMultiChat) {
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
 * isMultiChat - 듀얼 메신저 등으로 복제된 앱이라면 true, 아니라면 false. 배포 중인 버전에는 아직 미구현
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
## function onNotificationRemoved(StatusBarNotification sbn, NotificationListenerService.RankingMap rankingMap, int reason)
* 알림을 읽도록 설정한 앱에서 알림이 띄운 알림이 사라지면 호출되는 리스너
* 안드로이드 8 미만에서는 매개변수 `rankingMap`와 `reason`는 넘어오지 않음.

```javascript
function onNotificationRemoved(sbn, rankingMap, reason) {
/*
 * sbn - NofiticationListenerService에 있는 onNotificationRemoved의 매개변수로 넘어오는 StatusBarNotification 인스턴스
 * sbn - NofiticationListenerService에 있는 onNotificationRemoved의 매개변수로 넘어오는 NotificationListenerService.RankingMap 인스턴스
 * sbn - NofiticationListenerService에 있는 onNotificationRemoved의 매개변수로 넘어오는 reason
 */
}
```

## function onCreate(Bundle savedInstanceState Activity activity)
- 스크립트 액티비티의 `onCreate` 메서드가 호출되면 호출되는 리스너

```javascript
function onCreate(savedInstanceState, activity) {
/*
 * savedInstanceState - Activity에 있는 onCreate의 매개변수로 넘어오는 Bundle 인스턴스
 * activity - 해당 스크립트 액티비티의 this
 */
}
```

## function onDestroy(Activity activity)
- 스크립트 액티비티의 `onDestroy` 메서드가 호출되면 호출되는 리스너

```javascript
function onDestroy(activity) {
/*
 * activity - 해당 스크립트 액티비티의 this
 */
}
```

## function onPause(Activity activity)
- 스크립트 액티비티의 `onPause` 메서드가 호출되면 호출되는 리스너

```javascript
function onPause(activity) {
/*
 * activity - 해당 스크립트 액티비티의 this
 */
}
```

## function onResume(Activity activity)
- 스크립트 액티비티의 `onResume` 메서드가 호출되면 호출되는 리스너

```javascript
function onResume(activity) {
/*
 * activity - 해당 스크립트 액티비티의 this
 */
}
```

## function onStart(Activity activity)
- 스크립트 액티비티의 `onStart` 메서드가 호출되면 호출되는 리스너

```javascript
function onStart(activity) {
/*
 * activity - 해당 스크립트 액티비티의 this
 */
}
```

## function onStop(Activity activity)
- 스크립트 액티비티의 `onStop` 메서드가 호출되면 호출되는 리스너

```javascript
function onStop(activity) {
/*
 * activity - 해당 스크립트 액티비티의 this
 */
}
```

## function onRestart(Activity activity)
- 스크립트 액티비티의 `onRestart` 메서드가 호출되면 호출되는 리스너

```javascript
function onRestart(activity) {
/*
 * activity - 해당 스크립트 액티비티의 this
 */
}
```

## function onBackPressed(Activity activity)
- 스크립트 액티비티의 `onBackPressed` 메서드가 호출되면 호출되는 리스너

```javascript
function onBackPressed(activity) {
/*
 * activity - 해당 스크립트 액티비티의 this
 */
}
```