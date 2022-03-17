---
layout: default
title: Bridge
parent: Legacy API
---

# Bridge
* 이 API 증 일부는 `메신저봇`에도 있어요.

## boolean isAllowed(String botName);
* 해당 봇의 전역 스코프에 `Bridge`로 접근할 수 있는지 반환해요.

## ScriptableObject getScopeOf(String botName);
* 해당 봇의 전역 스코프를 가지고와요.


## boolean evaluateStringIn(String botName, String src);
* 해당 봇의 전역 스코프에서 해당 소스를 실행해요.

## String getGlobalVariable(String name);
* `단순 자동응답` 기능에 있는 해당 이름을 가진 `[[전체변수]]`에 저장된 값을 가지고와요.

## String getVariable(String room, String name);
* `단순 자동응답` 기능에 있는 해당 이름을 가진 `[[변수]]`에 저장된 값을 가지고와요.
* `[[변수]]` 태그는 방마다 따로따로 처리되기 때문에 방 이름도 함께 넘겨야 해요.

## String setGlobalVariable(String name, String value);
* `단순 자동응답` 기능에 있는 해당 이름을 가진 `[[전체변수]]`에 `value`를 저장해요.

## String setVariable(String room, String name, String value);
* `단순 자동응답` 기능에 있는 해당 이름을 가진 `[[변수]]`에  `value`를 저장해요.
* `[[변수]]` 태그는 방마다 따로따로 처리되기 때문에 방 이름도 함께 넘겨야 해요.