---
layout: default
title: Event
parent: API 2
---

# Event
* 이벤트 리스너들에 사용되는 `Event`들의 상수값을 가지고 있어요.

## String MESSAGE = "message"
* 채팅이 수신되면 발생하는 이벤트에요.

## String COMMAND = "command"
* `Bot#setCommandPrefix(String prefix);`으로 설정한 문자열로 시작하는 채팅이 수신되면 발생하는 이벤트에요.

## String START_COMPILE = "startCompile"
* 봇 컴파일이 시작되면 발생하는 이벤트에요.

## String MEMBER_COUNT_CHANGED = "memberChanged"
* 오픈채팅방 입퇴장 API 사용시 방 인원수가 변하면 발생하는 이벤트에요.
* **언제든지 불시에 사라질 수도 있어요.**

## String TICK = "tick"
* 매 틱(1초)마다 발생하는 이벤트

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
