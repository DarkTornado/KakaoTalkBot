---
layout: default
title: Log
parent: Lua API
---

# Log
* 각각 Log.d();, Log.e();, Log.i();로도 사용할 수 있어요.

## void debug(String log, boolean isGlobal);
* 로거에 로그를 기록해요.
* `isGlobal`가 `true`라면 글로벌 로그로 기록해요.

## void error(String log, boolean isGlobal, boolean hideToast);
* 로거에 로그를 기록해요.
* `isGlobal`가 `true`라면 글로벌 로그로 기록해요.
* `hideToast`가 `true`라면 오류가 발생했다는 문구를 토스트 메시지로는 출력하지 않아요.

## void info(String log, boolean isGlobal);
* 로거에 로그를 기록해요.
* `isGlobal`가 `true`라면 글로벌 로그로 기록해요.