---
layout: default
title: Event
parent: API 2
---

# Event
* 이벤트 리스너들에 사용되는 `Event`들의 상수값을 가지고 있어요.

## String MESSAGE = "message"
* 채팅이 수신되면 발생하는 이벤트에요.

```javascript
function(chat) {
/*
 * chat - 수신된 채팅의 정보가 담겨있는 객체
 * chat.content - 수신된 채팅 내용
 * chat.reply(msg) - 채팅이 수신된 채팅방으로 응답 전송
 * chat.markAsRead() - 채팅이 수신된 채팅방에 별도의 채팅을 보내지 않고 읽음으로 처리
 * 
 * chat.room - 채팅이 수신된 방의 정보가 담겨있는 객체
 * chat.room.name - 채팅이 수신된 방의 이름
 * chat.room.chatId - 채팅이 수신된 방의 chat_id. 카톡 로컬 DB 뜯으면 나오는 그 chat_id가 맞아요.
 * chat.room.isGroupChat - 채팅이 수신된 방이 단체채팅방이라면 `true`, 1:1 채팅방이라면 `false`
 * chat.room.isOpenChat - 채팅이 수신된 방이 오픈채팅방이라면 `true`, 아니라면 `false`
 * chat.room.icon - 채팅이 수신된 방의 방 아이콘 정보가 담긴 객체
 * chat.room.icon.getBase64() - 채팅이 수신된 방의 아이콘를 Base64로 인코딩된 문자열로 반환
 * chat.room.icon.getBitmap() - 채팅이 수신된 방의 아이콘를 android.graphics.Bitmap 인스턴스로 반환
 * 
 * chat.author - 채팅을 보낸 사람의 정보가 담긴 객체
 * chat.author.name - 채팅을 보낸 사람의 이름
 * chat.author.hash - 채팅을 보낸 사람의 해시. 채팅방마다 다르며, 상대방이 무슨 짓을 하든 같은 계정이라면 절대로 바뀌지 않음. 현재 배포 중인 버전에는 아직 구현되어 있지 않아요.
 * chat.author.avatar - 채팅을 보낸 사람의 프로필 사진을 가지고 올 수 있는 객체
 * chat.author.avatar.getBase64() - 채팅을 보낸 사람의 프로필 사진을 Base64로 인코딩된 문자열로 반환
 * chat.author.avatar.getBitmap() - 채팅을 보낸 사람의 프로필 사진을 android.graphics.Bitmap 인스턴스로 반환
 * 
 * chat.image - 수신된 채팅이 이미지라면 해당 이미지의 정보가 담긴 객체.
 * chat.image.getBase64() - 수신된 이미지를 Base64로 인코딩된 문자열로 반환
 * chat.image.getBitmap() - 수신된 이미지를 android.graphics.Bitmap 인스턴스로 반환
 * 
 * chat.hasMention - 수신된 채팅에 멘션이 포함된 경우 true, 아니면 false. 현재 배포 중인 버전에는 아직 구현되어 있지 않아요.
 * chat.isMention - hasMention과 동일. 구버전 호환용이니 안쓰는거 권장
 * chat.chatLogId - 수신된 채팅의 chatLogId
 * chat.packageName - 채팅이 수신된 앱의 패키지명
 */
}
```

## String COMMAND = "command"
* `Bot#setCommandPrefix(String prefix);`으로 설정한 문자열로 시작하는 채팅이 수신되면 발생하는 이벤트에요.

```javascript
function(chat) {
/*
 * chat - 수신된 채팅의 정보가 담겨있는 객체. Event.MESSAGE의 매개변수에 다음 필드 두 개가 추가됨
 * chat.command - 수신된 채팅 내용을 띄어쓰기로 나눈 결과물 중 가장 앞에 있는 값에서 prefix를 제외한 부분
 * chat.args - 수신된 채팅 내용을 띄어쓰기로 나눈 결과물 중 가장 앞에 있는 어절을 제외한 배열
 */
}
```

## String START_COMPILE = "startCompile"
* 봇 컴파일이 시작되면 발생하는 이벤트에요.
* 매개변수는 없어요

## String TICK = "tick"
* 매 틱(1초)마다 발생하는 이벤트에요.
* 매개변수는 없어요

## String NOTIFICATION_POSTED = "notificationPosted"
* 상단바에 알림이 뜨면 발생하는 이벤트에요.

```javascript
function(sbn, sm) {
/*
 * sbn - NofiticationListenerService에 있는 onNotificationPosted 메서드의 의 매개변수로 넘어오는 StatusBarNotification 인스턴스
 * sm - 동적으로 세션을 등록할 수 있게 해주는 객체 (SessionManager)
   - .bindSession(String packageName, String room, Notification.Action action);
   - .bindSession(String room, Notification.Action action);
 */
}
```

## String NOTIFICATION_REMOVED = "notificationRemoved"
* {{ site.misc.chatbot }}
* 상단바에 뜬 알림이 사라지면 발생하는 이벤트에요.
* 안드로이드 8 미만에서는 매개변수 `rankingMap`와 `reason`는 넘어오지 않아요.

```javascript
function(sbn, rankingMap, reason) {
/*
 * sbn - NofiticationListenerService에 있는 onNotificationRemoved의 매개변수로 넘어오는 StatusBarNotification 인스턴스
 * rankingMap - NofiticationListenerService에 있는 onNotificationRemoved의 매개변수로 넘어오는 NotificationListenerService.RankingMap 인스턴스
 * reason - NofiticationListenerService에 있는 onNotificationRemoved의 매개변수로 넘어오는 reason
 */
}
```

## String BATTERY_LEVEL_CHANGED = "batteryLevelChanged"
* {{ site.misc.chatbot }}
* 배터리 잔량이 바뀐게 감지되면 발생하는 이벤트에요
* 배터리 잔량 확인 주기는 10초에요.

```javascript
function(batteryStatus) {
/*
 * batteryStatus - 배터리 정보가 담긴 객체
 * batteryStatus.level.before - 배터리 잔량 변동이 감지되기 전 잔량
 * batteryStatus.level.after - 배터리 잔량 변동이 감지된 후 현재 잔량
 * batteryStatus.status - 배터리 상태 (1 ~ 5)
 */
}
```


## String MEMBER_COUNT_CHANGED = "memberChanged"
* {{ site.misc.chatbot }}
* 오픈채팅방 입퇴장 API 사용시 방 인원수가 변하면 발생하는 이벤트에요.
* **언제든지 불시에 사라질 수도 있어요.**

```javascript
function(data) {
/*
 * data - 인원수 변동이 감지된 방의 정보가 담겨요.
 * data.room -  인원수 변동이 감지된 방의 이름
 * 
 * chat.count - 인원수 변동이 감지된 방의 인원수 정보
 * chat.count.before - 인원수 변동이 감지되기 직전의 인원수
 * chat.count.after - 인원수 변동이 감지된 직후의 인원수
 */
}
```

# Event.Activity
* 스크립트 액티비티와 관련된 `Event`들의 상수값들인거에요.

## String Activity.BACK_PRESSED = "activityBackPressed"
- 스크립트 액티비티의 `onBackPressed` 메서드가 호출되면 발생하는 이벤트에요.

## String Activity.CREATE = "activityCreate"
- 스크립트 액티비티의 `onCreate` 메서드가 호출되면 발생하는 이벤트에요.

## String Activity.DESTROY = "activityDestroy"
- 스크립트 액티비티의 `onDestroy` 메서드가 호출되면 발생하는 이벤트에요.

## String Activity.PAUSE = "activityPause"
- 스크립트 액티비티의 `onPause` 메서드가 호출되면 발생하는 이벤트에요.

## String Activity.RESTART = "activityRestart"
- 스크립트 액티비티의 `onRestart` 메서드가 호출되면 발생하는 이벤트에요.

## String Activity.RESUME = "activityResume"
- 스크립트 액티비티의 `onResume` 메서드가 호출되면 발생하는 이벤트에요.

## String Activity.START = "activityStart"
- 스크립트 액티비티의 `onStart` 메서드가 호출되면 발생하는 이벤트에요.

## String Activity.STOP = "activityStop"
- 스크립트 액티비티의 `onStop` 메서드가 호출되면 발생하는 이벤트에요.
