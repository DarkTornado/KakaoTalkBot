---
layout: default
title: GlobalLog
parent: API 2
---

# GlobalLog
* 각각 GlobalLog.d();, GlobalLog.e();, GlobalLog.i();로도 사용할 수 있어요.

## void info(String log, boolean showToast);
* 글로벌 로그를 기록해요.
* `showToast`가 `true`라면 로그가 토스트 메시지로도 출력될거에요.

## void debug(String log, boolean showToast);
* 녹색 글씨로 글로벌 로그를 기록해요.
* `showToast`가 `true`라면 로그가 토스트 메시지로도 출력될거에요.

## void error(String log, boolean showToast);
* 빨간색 글씨로 글로벌 로그를 기록해요.
* `showToast`가 `true`라면 로그가 토스트 메시지로도 출력될거에요.

