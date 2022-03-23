---
layout: default
title: 이벤트 리스너
parent: Lua API
nav_order: 1
---

# 이벤트 리스너

* 어떠한 이벤트가 발생하면 호출되는 함수에요.

## function response(String room, String msg, String sender, boolean isGroupChat, Replier replier, ImageDB imageDB, String packageName)
* 채팅이 수신되면 호출되는 이벤트 리스너

```lua
function response(room, msg, sender, isGroupChat, replier, ImageDB, packageName)
--[[
 * room - 채팅이 수신된 채팅방의 방 이름. 1:1채팅방이라면 채팅을 보낸 사람의 닉네임
 * msg - 수신된 채팅 내용
 * sender - 채팅을 보낸 사람의 닉네임
 * isGroupChat - 단체채팅방이면 true, 1:1 채팅방이면 false
 * replier - 채팅방에 응답을 보낼 때 사용하는 객체
   - :reply(String msg); - 채팅이 수신된 채팅방으로 응답 전송 
   - :reply(String room, String msg); - 해당 채팅방으로 응답 전송 
   - :reply(String room, String msg, String packageName); - 해당 메신저 앱의 해당 채팅방으로 응답 전송
 * imageDB - 이미지 정보가 담겨 있는 객체
   - :getProfileImage(); - 채팅을 보낸 사람의 프로필 사진을 Base64로 인코딩된 문자열로 가지고 옴
   - :getProfileHash(); - 채팅을 보낸 사람의 프로필 사진을 Base64로 인코딩된 문자열에 java.lang.String.hashCode(); 메서드를 실행한 결과를 가지고 옴
   - :getImage(); - 사진이 수신된 경우, 해당 사진을 Base64로 인코딩된 문자열로 가지고 옴
 * packageName - 채팅이 수신된 앱의 패키지명
 ]]
end
```

## function secondTick()
* 1초마다 호출되는 이벤트 리스너

```lua
function secondTick()
-- 매개변수 없음
end
```